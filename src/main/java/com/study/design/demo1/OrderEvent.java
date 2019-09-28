package com.study.design.demo1;

import org.springframework.context.ApplicationEvent;

// 订单创建事件
public class OrderEvent extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}
