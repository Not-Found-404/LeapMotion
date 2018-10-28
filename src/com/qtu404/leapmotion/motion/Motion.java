package com.qtu404.leapmotion.motion;

import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.leapmotion.order.Order;

import java.util.ArrayList;

public interface Motion {
    public boolean judge(Judge judge);

    public void doOrder();

    public void addOrder(Order order);

    public ArrayList<Order> getOrders();
}
