package com.study.design.demo2;

import org.springframework.stereotype.Service;

// normal
@Service
public class NormalCalculateService implements CalculateService{
    @Override
    public String userType() {
        return "normal";
    }

    @Override
    public double calculate(double fee) {
        return fee * 0.9; // 复杂的逻辑，可能会频繁修改的，单独抽出来
    }
}
