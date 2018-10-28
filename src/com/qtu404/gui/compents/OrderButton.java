package com.qtu404.gui.compents;

import com.qtu404.factorys.GUIFactory;

import javax.swing.JCheckBox;

public class OrderButton extends JCheckBox {
    private String orderName;

    public OrderButton(String orderName) {
        super(orderName, false);
        this.orderName = orderName;
        this.setFont(GUIFactory.getMyFont());
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
