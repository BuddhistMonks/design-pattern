package com.study.design.demo2;

// service serviceImpl
/** 计费打折接口 */
public interface CalculateService {
    public String userType(); // 返回该打着策略针对哪一种用户

    public double calculate(double fee);
}
