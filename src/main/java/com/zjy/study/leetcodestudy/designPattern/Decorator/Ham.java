package com.zjy.study.leetcodestudy.designPattern.Decorator;

/**
 * @Author zjy
 * @Date 2023/3/14 10:40
 * @Description
 */
public class Ham extends Ingredients{
    public Ham(FriedRice friedRice) {
        super(friedRice);
    }
    @Override
    String getDesc(){
        return super.getDesc() + "+火腿";
    }
    @Override
    Integer getPrice(){
        return super.getPrice() + 3;
    }
}
