package com.study.design.demo1;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// 订单事件之后 -- 发送短信
@Component // 交给spring托管，由spring创建对象，并且保留到IOC容器
public class SmsListener implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent event) {
        // 2 ---发送短信--- TODO 此处省略短信接口调用的N行代码
        System.out.println("2、 短信发送成功");
    }

}
