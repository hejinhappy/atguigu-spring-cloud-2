package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: OrderOpenfeginMain80
 * @Description:  openfeign使用
 * @Author: hejin
 * @Date: 2020/3/8 20:05
 */
@SpringBootApplication
@EnableFeignClients //开启openfegin
public class OrderOpenfeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignMain80.class,args);
    }

}
