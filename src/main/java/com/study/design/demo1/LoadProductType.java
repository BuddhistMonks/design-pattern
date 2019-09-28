package com.study.design.demo1;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// 启动时，加载数据
@Component // 交给spring托管
public class LoadProductType implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("spring启动之后，执行一些初始化的操作（加载数据库的数据，初始化..）");
        // 需求：项目启动时需要把产品类型编号与对应的类型名称缓存到一个Map里面，程序中要用的时候就直接从这个Map里面拿。
    }
}
