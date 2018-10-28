package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class OpenDoor implements Order {
    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("openDoor");
    }

    private OpenDoor(){};

    private static OpenDoor singleton = new OpenDoor();

    public static OpenDoor getInstance() {
        return singleton;
    }
}
