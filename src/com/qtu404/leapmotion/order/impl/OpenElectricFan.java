package com.qtu404.leapmotion.order.impl;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.scoket.SocketClient;

public class OpenElectricFan implements Order {
    private static OpenElectricFan singleton = new OpenElectricFan();

    private OpenElectricFan() {
    }

    public static OpenElectricFan getInstance() {
        return singleton;
    }

    @Override
    public void executeOrder() {
        SocketClient socketClient = new SocketClient();
        socketClient.execute("openFan");
    }
}
