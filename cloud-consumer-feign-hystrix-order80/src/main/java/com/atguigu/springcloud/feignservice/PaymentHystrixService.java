package com.atguigu.springcloud.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentHytrixService
 * @Description:
 *
 *      基于feign的全局服务降级处理
 *      1.实现feign接口
 *      2.开启服务降级： feign.hystrix.enabled: true
 *
 * @Author: hejin
 * @Date: 2020/3/8 22:10
 */
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentHystrixFallbackServiceImpl.class)
@Component
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrixOk")
    String hystrixOk();

    @GetMapping("/payment/hystrixTimeout")
    String hystrixTimeout();

}
