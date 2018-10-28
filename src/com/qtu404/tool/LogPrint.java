package com.qtu404.tool;

import javax.swing.*;

public class LogPrint {

    private static LogPrint singleton = new LogPrint();

    public static LogPrint getInstance() {
        return singleton;
    }

    private JTextArea console = null;

    private LogPrint() {
    }

    public void setConsole(JTextArea console) {
        this.console = console;
    }

    public void printLog(String mess) {
        if (console != null) {
            console.append(mess);
            int length = console.getText().length();
            console.setCaretPosition(length);
        }
        System.out.print(mess);
    }
}
