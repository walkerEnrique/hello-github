package com.study.springboot.controller;

import com.study.springboot.entites.CommonResult;
import com.study.springboot.entites.Payment;
import com.study.springboot.serivce.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> createPayment(Payment payment)
    {
       int id =  paymentService.create(payment);
        if(id>0)
        {
            return new CommonResult<>(200,"插入成功",id);
        }else{
            return new CommonResult<>(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null)
        {
            return new CommonResult<>(200,"获取成功",payment);
        }else{
            return new CommonResult<>(444,"获取失败,查询ID"+id,null);
        }
    }


}
