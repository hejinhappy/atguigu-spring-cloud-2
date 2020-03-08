package com.atguigu.springcloud.feignservice;

import org.springframework.stereotype.Component;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentHystrixFallbackServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: hejin
 * @Date: 2020/3/8 23:11
 */
@Component
public class PaymentHystrixFallbackServiceImpl implements PaymentHystrixService{

    @Override
    public String hystrixOk() {
        return "hystrixOk----fallback";
    }

    @Override
    public String hystrixTimeout() {
        return "hystrixTimeout----fallback";
    }
}
