package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feignservice.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: OrderHystrixController
 * @Description:
 *      目前存在问题：
 *             1。方法膨胀
 *             2.与业务杂合在一起
 *      解决方案:
 *          1.定义全局
 *
 * @Author: hejin
 * @Date: 2020/3/8 22:12
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "hystrixGlobHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrixOk")
    public String hystrixOk() {
        return paymentHystrixService.hystrixOk();
    }

    @GetMapping("/consumer/payment/hystrixTimeout")
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "1500")
    })
    public String hystrixTimeout() {
        return paymentHystrixService.hystrixTimeout();
    }

    public String hystrixTimeoutHandler() {
        return "请求服务异常";
    }

    //全局FallBack
    public String hystrixGlobHandler() {
        return "全局请求服务异常";
    }

}
