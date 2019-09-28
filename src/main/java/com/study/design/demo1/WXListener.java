package com.study.design.demo1;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 订单事件之后 -- 发送微信
@Component // 交给spring托管，由spring创建对象，并且保留到IOC容器
public class WXListener implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent event) {
        // 3 ---微信---
        System.out.println("3、 微信发送成功");
    }

}
