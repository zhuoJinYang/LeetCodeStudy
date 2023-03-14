package com.zjy.study.leetcodestudy.designPattern.Decorator;

/**
 * @Author zjy
 * @Date 2023/3/14 10:36
 * @Description
 *      配料表
 */
public abstract class Ingredients extends FriedRice{
    private FriedRice friedRice;
    public Ingredients(FriedRice friedRice){
        this.friedRice = friedRice;
    }
    @Override
    String getDesc(){
        return this.friedRice.getDesc();
    }
    @Override
    Integer getPrice(){
        return this.friedRice.getPrice();
    }
}
