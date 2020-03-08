package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: HystrixDashboardMain9001
 * @Description: TODO(一句话描述该类的功能)
 * @Author: hejin
 * @Date: 2020/3/9 0:18
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }

}
