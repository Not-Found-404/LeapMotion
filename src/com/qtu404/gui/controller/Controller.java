package com.qtu404.gui.controller;

import com.qtu404.gui.action.Action;
import com.qtu404.gui.action.impl.SetOrderAction;

import java.util.HashMap;

public class Controller {
    private static Controller singleton = new Controller();

    public static Controller getInstance() {
        return singleton;
    }

    private Controller() {
        actionHashMap = new HashMap<>();
        actionHashMap.put("setOrder", new SetOrderAction());

    }

    private HashMap<String, Action> actionHashMap;

    public HashMap<String, Object> executeAction(String actionName, HashMap<String, Object> request) throws ClassNotFoundException {
        Action action = actionHashMap.get(actionName);
        if (action == null) {
            throw new ClassNotFoundException("code 404: not found action named " + actionName);
        }
        action.setRequest(request);
        return action.executeAction();
    }
}
