package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class CloseDoor implements Order {
    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("closeDoor");
    }

    private CloseDoor() {
    }

    private static CloseDoor singleton = new CloseDoor();

    public static CloseDoor getInstance() {
        return singleton;
    }
}
