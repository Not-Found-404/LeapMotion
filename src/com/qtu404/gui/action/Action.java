package com.qtu404.gui.action;

import java.util.HashMap;

public interface Action {
    public HashMap<String, Object> executeAction() throws ClassNotFoundException;

    public void setRequest(HashMap<String, Object> request);

}
