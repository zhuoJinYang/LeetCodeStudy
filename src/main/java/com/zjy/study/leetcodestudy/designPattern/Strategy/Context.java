package com.zjy.study.leetcodestudy.designPattern.Strategy;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author zjy
 * @Date 2023/2/27 14:53
 * @Description
 *      策略控制类
 */
@AllArgsConstructor
public class Context<T>{
    private ICouponDiscount<T> couponDiscount;

    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice){
        return couponDiscount.discountAmount(couponInfo,skuPrice);
    }
}
