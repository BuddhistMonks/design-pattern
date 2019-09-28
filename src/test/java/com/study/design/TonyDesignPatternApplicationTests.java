package com.study.design;

import com.study.design.demo1.OrderService;
import com.study.design.demo2.SaleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TonyDesignPatternApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    public void test1() {
        orderService.saveOrder();
    }

    public void test2() {
        // JDBC数据库操作/redis操作/
        // 1. 获取连接
        // 2. 检查连接是否可用
        // 3. TODO 拿到连接进行业务操作
        // 4. 释放连接
        // spring封装之后的工具 JdbcTemplate、RedisTemplate、KafkaTemplate、rabbittemplate
        RedisTemplate redisTemplate = null;
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO 业务开发人员，只关注拿到connection之后做什么事情
                return null;
            }
        });

    }

    @Autowired
    SaleService saleService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test3() {
        applicationContext.getBean("saleService");

        double svip = saleService.sale("svip", 100);
        System.out.println("svip价格:" + svip);

        double ssvip = saleService.sale("ssvip", 100);
        System.out.println("ssvip价格:" + ssvip);
    }
}
