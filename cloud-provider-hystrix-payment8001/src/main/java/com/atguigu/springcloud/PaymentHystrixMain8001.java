package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentHystrixMain8001
 * @Description: Hystrix
 *      解决问题：
 *          1.服务降级
 *          2.服务熔断
 *          3.服务限流
 *      产生原因：
 *          1.超时
 *          2.异常
 *          3.线程池满
 *
 *
 * @Author: hejin
 * @Date: 2020/3/8 21:10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //服务端熔断
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }

    /**
     * 配置 Hystrix dashboard 监控流
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
