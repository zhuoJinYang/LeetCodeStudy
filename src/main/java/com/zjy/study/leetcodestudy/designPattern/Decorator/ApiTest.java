package com.zjy.study.leetcodestudy.designPattern.Decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author zjy
 * @Date 2023/3/14 10:41
 * @Description
 */
@Slf4j
public class ApiTest {
    @Test
    public void TestDecorator(){
        FriedRice friedRice = new FriedRice();
        System.out.println(friedRice.getDesc() + friedRice.getPrice() + "元");// 炒饭5元
        friedRice = new Egg(friedRice);
        System.out.println(friedRice.getDesc() + friedRice.getPrice() + "元"); // 炒饭+鸡蛋7元
        friedRice = new Egg(friedRice);
        System.out.println(friedRice.getDesc() + friedRice.getPrice() + "元");// 炒饭+鸡蛋+鸡蛋9元
        friedRice = new Ham(friedRice);
        System.out.println(friedRice.getDesc() + friedRice.getPrice() + "元");// 炒饭+鸡蛋+鸡蛋+火腿12元
    }
}
