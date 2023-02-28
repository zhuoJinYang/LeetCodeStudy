package com.zjy.study.leetcodestudy.designPattern.Strategy;

import java.math.BigDecimal;

/**
 * @Author zjy
 * @Date 2023/2/27 14:47
 * @Description
 */
public class ZJCouponDiscount implements ICouponDiscount<Double>{
    /**
     * 直减计算
     * 1.使用商品价格减去优惠价格
     * 2.最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1){
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
