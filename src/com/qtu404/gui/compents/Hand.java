package com.qtu404.gui.compents;

import java.util.ArrayList;

public class Hand {
    private String handName;

    public static ArrayList<String> hands = new ArrayList<>(2);

    public static ArrayList<String> vectors = new ArrayList<>(4);

    public static ArrayList<String> orders = new ArrayList<>(8);

    static {
        hands.add("左手");
        hands.add("右手");

        vectors.add("上挥");
        vectors.add("下挥");
        vectors.add("左挥");
        vectors.add("右挥");

        orders.add("开门");
        orders.add("关门");
        orders.add("开灯");
        orders.add("关灯");
        orders.add("关电风扇");
        orders.add("开电风扇");
        orders.add("关闭窗帘");
        orders.add("拉开窗帘");
    }
}
