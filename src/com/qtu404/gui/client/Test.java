package com.qtu404.gui.client;

import com.qtu404.factorys.BeanFactory;
import com.qtu404.gui.controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

        Controller controller = BeanFactory.getController();
        HashMap<String, Object> request = new HashMap<>();

        ArrayList<String> orderNames = new ArrayList<>();
        orderNames.add("开门");
        orderNames.add("关门");

        request.put("motionName", "左手左挥");
        request.put("orderNames", orderNames);

        HashMap<String, Object> response = controller.executeAction("setOrder", request);
        System.out.println(response.get("stateCode"));

    }
}
