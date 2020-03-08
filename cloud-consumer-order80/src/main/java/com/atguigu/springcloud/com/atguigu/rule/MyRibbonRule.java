package com.atguigu.springcloud.com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 自定义Ribbon的轮询算法、
 *  1.@ComponentScan扫描之外
 *  2.@RibbonClient(name = "custom", configuration = MyRibbonRule.class)
 *
 */
@Configuration
public class MyRibbonRule {


    @Bean
    public IRule getIRule() {
        //Ribbon其中轮询算法
        return new RandomRule();
    }

}
