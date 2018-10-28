package com.qtu404.factorys;

import com.qtu404.gui.controller.Controller;
import com.qtu404.leapmotion.motion.Motion;
import com.qtu404.leapmotion.order.Order;

import java.awt.Container;

public class BeanFactory {
    public static Motion getMotion(String motionType) throws ClassNotFoundException {
        return MotionFactory.getMotion(motionType);
    }

    public static Order getOrder(String orderName) throws ClassNotFoundException {
        return OrderFactory.getOrder(orderName);
    }

    public static Container getContainer(String containerName) {
        return GUIFactory.getCompent(containerName);
    }

    public static Controller getController() {
        return Controller.getInstance();
    }
}
