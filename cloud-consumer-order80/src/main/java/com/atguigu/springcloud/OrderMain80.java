package com.atguigu.springcloud;

import com.atguigu.springcloud.com.atguigu.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-03-06 14:50
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "custom", configuration = MyRibbonRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
