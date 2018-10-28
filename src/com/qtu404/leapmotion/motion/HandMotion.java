package com.qtu404.leapmotion.motion;

import com.qtu404.leapmotion.order.Order;
import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.tool.LogPrint;

import java.util.ArrayList;
import java.util.Date;

public class HandMotion implements Motion {
    ArrayList<Order> orders = new ArrayList<>(0);

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    private String handSignal = null;

    public void setHandSignal(String handSignal) {
        this.handSignal = handSignal;
    }

    @Override
    public boolean judge(Judge judge) {
        return false;
    }

    @Override
    public void doOrder() {
        for (Order order : orders) {
            LogPrint.getInstance().printLog(new Date() + "\n" + handSignal);
            order.executeOrder();
        }
    }
}
