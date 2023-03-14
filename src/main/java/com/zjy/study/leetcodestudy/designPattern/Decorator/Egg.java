package com.zjy.study.leetcodestudy.designPattern.Decorator;

/**
 * @Author zjy
 * @Date 2023/3/14 10:38
 * @Description
 *      鸡蛋配料
 */
public class Egg extends Ingredients{
    public Egg(FriedRice friedRice) {
        super(friedRice);
    }
    @Override
    String getDesc(){
        return super.getDesc() + "+鸡蛋";
    }
    @Override
    Integer getPrice(){
        return super.getPrice() + 2;
    }
}
