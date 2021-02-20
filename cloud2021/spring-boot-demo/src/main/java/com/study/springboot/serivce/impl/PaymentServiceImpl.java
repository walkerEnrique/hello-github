package com.study.springboot.serivce.impl;

import com.study.springboot.dao.PaymentDao;
import com.study.springboot.entites.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
       return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
