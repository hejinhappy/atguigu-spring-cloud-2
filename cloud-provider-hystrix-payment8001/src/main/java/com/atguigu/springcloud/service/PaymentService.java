package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: hejin
 * @Date: 2020/3/8 21:14
 */
public interface PaymentService {

    String hystrixOk();

    String hystrixTimeout();

    String hystrixCircuitBreaker(int i);


}
