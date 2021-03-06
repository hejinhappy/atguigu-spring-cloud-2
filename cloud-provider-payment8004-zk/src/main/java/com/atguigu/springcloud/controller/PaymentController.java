package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-03-07 17:00
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZk() {
        return "SpringCloud with Zookeeper：" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
