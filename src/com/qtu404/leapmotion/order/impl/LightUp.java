package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class LightUp implements Order {
    private LightUp() {
    }

    private static LightUp singleton = new LightUp();

    public static LightUp getInstance() {
        return singleton;
    }

    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("lightUp");
    }
}
