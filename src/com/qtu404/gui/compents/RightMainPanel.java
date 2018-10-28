package com.qtu404.gui.compents;

import com.qtu404.factorys.GUIFactory;
import com.qtu404.tool.LogPrint;

import javax.swing.*;

public class RightMainPanel extends JPanel {
    private static RightMainPanel singleton = new RightMainPanel();

    public static RightMainPanel getInstance() {
        return singleton;
    }

    private JTextArea consoleJTextArea;
    private JLabel consoleJLabel;
    private JScrollPane js;

    public JTextArea getConsoleJTextArea() {
        return consoleJTextArea;
    }

    private RightMainPanel() {
        super();
        this.setLayout(null);
        init();
    }

    private void init() {
        consoleJTextArea = new JTextArea(20, 20);
        consoleJTextArea.setEditable(false);
        consoleJTextArea.setFont(GUIFactory.getMyFont());
        LogPrint.getInstance().setConsole(consoleJTextArea);
        this.add(consoleJTextArea);

        js = new JScrollPane(consoleJTextArea);
        js.setBounds(1, 50, 398, 549);
        this.add(js);


        consoleJLabel = new JLabel("控制台输出");
        consoleJLabel.setBounds(150, 0, 100, 50);
        consoleJLabel.setFont(GUIFactory.getMyFont());
        this.add(consoleJLabel);
    }
}
