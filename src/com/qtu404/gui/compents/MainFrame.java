package com.qtu404.gui.compents;

import com.qtu404.factorys.GUIFactory;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame singleton = new MainFrame();

    public static MainFrame getInstance() {
        return singleton;
    }

    private Container leftMainPanel = null;
    private Container rightMainPanel = null;

    private MainFrame() throws HeadlessException {
        this.setTitle("智能家居控制系统");
        this.setVisible(true);
        int frameWidht = 854;
        int frameHeight = 683;
        int screenWidth, screenHeight;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(frameWidht, frameHeight);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation((screenWidth - frameWidht) / 2, (screenHeight - frameHeight) / 2);
        this.init();
    }

    private void init() {
        leftMainPanel = GUIFactory.getLeftMainPanel();
        rightMainPanel = GUIFactory.getRightMainPanel();

        leftMainPanel.setBounds(0, 0, 400, 600);
        this.add(leftMainPanel);

        rightMainPanel.setBounds(400, 0, 400, 600);
        this.add(rightMainPanel);
    }
}
