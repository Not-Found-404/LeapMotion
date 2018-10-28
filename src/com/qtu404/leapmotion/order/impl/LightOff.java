package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class LightOff implements Order {
    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("lightOff");
    }

    private LightOff() {
    }

    private static LightOff singleton = new LightOff();

    public static LightOff getInstance() {
        return singleton;
    }
}