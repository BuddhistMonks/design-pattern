package com.study.design.demo2;

import org.springframework.stereotype.Service;

// ssVIP
@Service
public class SSVIPCalculateService implements CalculateService{
    @Override
    public String userType() {
        return "ssvip";
    }

    @Override
    public double calculate(double fee) {
        return fee * 0.4;
    }
}
