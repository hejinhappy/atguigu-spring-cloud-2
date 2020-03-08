package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentServiceImpl
 * @Description:
 *      执行工作流程：
 *      Construct a HystrixCommand or HystrixObservableCommand Object
 *      Execute the Command
 *      Is the Response Cached?
 *      Is the Circuit Open?
 *      Is the Thread Pool/Queue/Semaphore Full?
 *      HystrixObservableCommand.construct() or HystrixCommand.run()
 *      Calculate Circuit Health
 *      Get the Fallback
 *      Return the Successful Response
 *
 *
 * @Author: hejin
 * @Date: 2020/3/8 21:17
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String hystrixOk() {
        return Thread.currentThread().getName()+"调用成功";
    }

    //=========================服务降级

    /**
     * 详细策略：
     *     参考：https://github.com/Netflix/Hystrix/wiki/Configuration
     * 常见使用策略：
     *      HystrixCommandProperties:
     *            execution.isolation.thread.timeoutInMilliseconds
     * @return
     */
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
    })
    @Override
    public String hystrixTimeout() {
        int timeOut = 3;
        try {
            log.info("正在执行。。。。。。");
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"服务调用超时(秒)："+timeOut;
    }

    public String hystrixTimeoutHandler() {
        return Thread.currentThread().getName()+"系统繁忙";
    }

    //================服务熔断：降级->熔断->恢复调用链路
             //       open --> half open --> close

    @HystrixCommand(fallbackMethod = "hystrixCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled" ,value = "true"), //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" ,value = "10"), //请求线程数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" ,value = "50"), //请求错误率
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" ,value = "10000") //请求窗口期
    })
    @Override
    public String hystrixCircuitBreaker(int i) {
        if(i < 0) {
            throw new RuntimeException("参数不能为复数");
        }
        return Thread.currentThread().getName()+"-hystrixCircleBreak";
    }

    public String hystrixCircuitBreakerHandler(int i) {
        return Thread.currentThread().getName()+"参数异常";
    }

}
