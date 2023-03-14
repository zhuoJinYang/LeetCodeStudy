package com.zjy.study.leetcodestudy.designPattern.Proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author zjy
 * @Date 2023/3/14 10:13
 * @Description
 */
@Slf4j
public class ApiTest {
    @Test
    public void TestProxy(){
        ProxyPoint proxyPoint = new ProxyPoint();
        TrainStation guangzhouTrainStation = proxyPoint.getProxyObject(new GuangzhouTrainStation());
        // 代售火车票收取5%手续费
        // 广州火车站买票啦
        guangzhouTrainStation.sellTickets();
        TrainStation shenzhenTrainStation = proxyPoint.getProxyObject(new ShenzhenTrainStation());
        // 代售火车票收取5%手续费
        // 深圳火车站买票啦
        shenzhenTrainStation.sellTickets();
    }
}
