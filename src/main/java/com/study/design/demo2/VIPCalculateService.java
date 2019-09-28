package com.study.design.demo2;

import org.springframework.stereotype.Service;

// VIP
@Service
public class VIPCalculateService implements CalculateService{
    @Override
    public String userType() {
        return "vip";
    }

    @Override
    public double calculate(double fee) {
        return fee * 0.8;
    }
}
