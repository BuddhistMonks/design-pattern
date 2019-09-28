package com.study.design.demo2;

import org.springframework.stereotype.Service;

// VIP
@Service
public class SVIPCalculateService implements CalculateService{
    @Override
    public String userType() {
        return "svip";
    }

    @Override
    public double calculate(double fee) {
        return fee * 0.6;
    }
}
