package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.feginservice.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hejin
 * @date 2020-03-06 14:53
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }


    /**
     * 模拟openfeign超时
     *  结果：Read timed out executing GET http://CLOUD-PAYMENT-SERVICE/payment/openfeign/timeout] with root cause
     *  解决方案：底层使用Ribbon，主要进行ribbon设置
     * @return
     */
    @GetMapping(value = "/consumer/payment/openfeign/timeout")
    public String getPaymentOpenfeignTimeout() {
        return paymentService.getPaymentOpenfeignTimeout();
    }


}
