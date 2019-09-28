package com.study.design.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 订单操作，业务伪代码 （需求变更快）
 */
@Service
public class OrderService {

    @Autowired
    ApplicationContext applicationContext; // spring上下文（IOC容器）

    /**
     * 电商 - 新订单
     */
    public void saveOrder() {
        // 1 ---创建订单--- TODO 此处省略100行代码
        System.out.println("1、 订单创建成功");

        OrderEvent orderEvent = new OrderEvent("传一个参数");
        // 发布事件(可以是多线程， 默认当前线程直接触发执行)
        applicationContext.publishEvent(orderEvent); // 触发其他监听器的执行

        // 只需要关注到订单创建。下面的逻辑干掉
    }
}
