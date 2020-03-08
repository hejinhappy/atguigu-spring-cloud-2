package com.atguigu.springcloud.feginservice;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version v1.0
 * @ProjectName: cloud-2020
 * @ClassName: PaymentService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: hejin
 * @Date: 2020/3/8 20:08
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //调用方服务名称
@Component
public interface PaymentService {

    /**
     * rest 接口
     * @param id
     * @return
     */
    @GetMapping(value = "payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "payment/openfeign/timeout")
    String getPaymentOpenfeignTimeout();

}
