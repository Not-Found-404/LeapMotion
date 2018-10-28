package com.qtu404.factorys;

import com.qtu404.gui.compents.LeftMainPanel;
import com.qtu404.gui.compents.MainFrame;
import com.qtu404.gui.compents.RightMainPanel;

import java.awt.*;

public class GUIFactory {
    public static Container getCompent(String compentName) {
        Container container = null;


        return container;
    }

    public static Container getLeftMainPanel() {
        return LeftMainPanel.getInstance();
    }

    public static Container getRightMainPanel() {
        return RightMainPanel.getInstance();
    }

    public static Container getMainFrame() {
        return MainFrame.getInstance();
    }

    public static Font myFont = new Font("华文细黑", Font.PLAIN, 18);

    public static Font getMyFont() {
        return myFont;
    }

}
