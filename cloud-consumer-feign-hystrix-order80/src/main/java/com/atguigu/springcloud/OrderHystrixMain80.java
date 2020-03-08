package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: OrderHystrixMain80
 * @Description: TODO(一句话描述该类的功能)
 * @Author: hejin
 * @Date: 2020/3/8 22:09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //EnableHystrix --->@EnableCircuitBreaker
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }



}
