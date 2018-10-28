package com.qtu404.gui.action.impl;

import com.qtu404.factorys.BeanFactory;
import com.qtu404.gui.action.AbstractAction;
import com.qtu404.leapmotion.motion.Motion;
import com.qtu404.leapmotion.order.Order;

import java.util.ArrayList;

public class SetOrderAction extends AbstractAction {
    @Override
    public void execute() throws ClassNotFoundException {
        Motion motion = BeanFactory.getMotion((String) request.get("motionName"));
        ArrayList<String> orderNames = (ArrayList<String>) request.get("orderNames");
        ArrayList<Order> orders = motion.getOrders();
        orders.clear();
        for (String orderName : orderNames) {
            Order order = BeanFactory.getOrder(orderName);
            if (orders.contains(order)) {
                continue;
            } else {
                motion.addOrder(order);
            }
        }
        response.put("stateCode", "success");
    }
}