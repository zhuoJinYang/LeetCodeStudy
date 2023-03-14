package com.zjy.study.leetcodestudy.designPattern.Proxy;

/**
 * @Author zjy
 * @Date 2023/3/14 10:07
 * @Description
 */
public class ShenzhenTrainStation implements TrainStation{
    @Override
    public void sellTickets() {
        System.out.println("深圳火车站买票啦");
    }
}
