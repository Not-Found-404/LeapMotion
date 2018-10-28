package com.qtu404.gui.action;

import com.qtu404.gui.action.Action;

import java.util.HashMap;

public class AbstractAction implements Action {
    protected HashMap<String, Object> request = null;
    protected HashMap<String, Object> response = new HashMap<>();

    public HashMap<String, Object> getRequest() {
        return request;
    }

    public void setRequest(HashMap<String, Object> request) {
        this.request = request;
    }

    public HashMap<String, Object> getResponse() {
        return response;
    }

    public void setResponse(HashMap<String, Object> response) {
        this.response = response;
    }

    @Override
    public HashMap<String, Object> executeAction() throws ClassNotFoundException {
        if (request == null) {
            request = new HashMap<>(0);
        }
        HashMap<String, Object> result = new HashMap<>();
        execute();
        result = (HashMap<String, Object>) response.clone();
        request = null;
        response.clear();
        return result;
    }

    public void execute() throws ClassNotFoundException {

    }
}
