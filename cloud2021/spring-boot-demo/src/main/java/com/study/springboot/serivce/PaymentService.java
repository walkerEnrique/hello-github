package com.study.springboot.serivce;


import com.study.springboot.entites.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
