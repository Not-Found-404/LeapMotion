package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class OpenCurtain implements Order {
    private OpenCurtain() {
    }

    private static OpenCurtain singleton = new OpenCurtain();

    public static Order getInstance() {
        return singleton;
    }

    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("openCurtain");
    }
}
