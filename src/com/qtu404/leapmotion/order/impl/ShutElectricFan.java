package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class ShutElectricFan implements Order {
    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("closeFan");
    }

    private static ShutElectricFan singleton = new ShutElectricFan();

    public static Order getInstance() {
        return singleton;
    }

    private ShutElectricFan() {
    }
}
