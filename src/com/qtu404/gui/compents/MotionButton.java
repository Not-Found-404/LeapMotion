package com.qtu404.gui.compents;

import com.qtu404.factorys.GUIFactory;

import javax.swing.*;

public class MotionButton extends JButton {

    private String hand;
    private String vector;

    public String getMotionName() {
        return hand + vector;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public MotionButton() {
        super();
        this.setFont(GUIFactory.getMyFont());
    }
}
