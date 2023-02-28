package com.zjy.study.leetcodestudy.designPattern.Strategy;

import java.math.BigDecimal;

/**
 * @Author zjy
 * @Date 2023/2/27 14:52
 * @Description
 */
public class NYGCouponDiscount implements ICouponDiscount<Double>{
    /**
     * n元购购买
     * 1.无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
