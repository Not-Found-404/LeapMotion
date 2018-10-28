package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class CloseCurtain implements Order {
    private CloseCurtain() {
    }

    private static CloseCurtain singleton = new CloseCurtain();

    public static Order getInstance() {
        return singleton;
    }

    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("closeCurtain");
    }
}
