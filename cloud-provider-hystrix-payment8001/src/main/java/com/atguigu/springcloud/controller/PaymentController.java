package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: hejin
 * @Date: 2020/3/8 21:19
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrixOk")
    public String hystrixOk() {
        return paymentService.hystrixOk();
    }

    @GetMapping("/payment/hystrixTimeout")
    public String hystrixTimeout() {
        return paymentService.hystrixTimeout();
    }

    @GetMapping("/payment/hystrixCircuitBreaker/{id}")
    String hystrixCircuitBreaker(@PathVariable("id") int i) {
        return paymentService.hystrixCircuitBreaker(i);
    }


}
