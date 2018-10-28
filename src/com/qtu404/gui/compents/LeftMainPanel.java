package com.qtu404.gui.compents;


import com.qtu404.factorys.BeanFactory;
import com.qtu404.factorys.GUIFactory;
import com.qtu404.gui.controller.Controller;
import com.qtu404.leapmotion.motion.Motion;
import com.qtu404.leapmotion.motiontrack.MotionTrack;
import com.qtu404.leapmotion.order.Order;
import com.qtu404.tool.LogPrint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class LeftMainPanel extends JPanel {
    private static LeftMainPanel singleton = new LeftMainPanel();

    public static LeftMainPanel getInstance() {
        return singleton;
    }

    private String presentMotionName = null;

    private JPanel orderPanel;

    private JButton saveConfig;

    private JButton star;
    private JButton stop;

    ArrayList<MotionButton> motionButtons = new ArrayList<>(8);
    ArrayList<OrderButton> OrderButtons = new ArrayList<>(8);

    private LeftMainPanel() {
        super();
        this.setBackground(new Color(239, 237, 237));
        this.setLayout(null);
        init();
    }

    private void init() {
        star = new JButton("开始");
        star.setBounds(20, 5, 170, 40);
        star.setFont(GUIFactory.getMyFont());
        this.add(star);

        stop = new JButton("停止");
        stop.setBounds(210, 5, 170, 40);
        stop.setFont(GUIFactory.getMyFont());
        this.add(stop);

        int y = 60;
        for (String hand : Hand.hands) {
            for (String vecotr : Hand.vectors) {
                MotionButton motionButton = new MotionButton();
                motionButton.setHand(hand);
                motionButton.setVector(vecotr);
                motionButton.setText(hand + "向" + vecotr + "动");
                motionButton.setBounds(10, y, 140, 50);
                y += 68;
                motionButtons.add(motionButton);
                this.add(motionButton);
            }
        }


        orderPanel = new JPanel();
        orderPanel.setLayout(null);
        orderPanel.setBounds(160, 50, 240, 550);
        this.add(orderPanel);

        saveConfig = new JButton("保存");
        saveConfig.setFont(GUIFactory.getMyFont());
        saveConfig.setBounds(20, 485, 200, 50);
        orderPanel.add(saveConfig);

        int orderIndexY = 25;
        for (String order : Hand.orders) {
            OrderButton orderButton = new OrderButton(order);
            orderButton.setBounds(50, orderIndexY, 150, 40);
            OrderButtons.add(orderButton);
            orderPanel.add(orderButton);
            orderIndexY += 55;
        }

        //选择手势
        for (MotionButton motionButton : motionButtons) {
            motionButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    String motionName = motionButton.getMotionName();
                    presentMotionName = motionName;
                    Motion motion = null;
                    try {
                        motion = BeanFactory.getMotion(motionName);
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }

                    ArrayList<Order> orders = motion.getOrders();

                    for (OrderButton orderButton : OrderButtons) {
                        orderButton.setSelected(false);
                        String orderName = orderButton.getOrderName();
                        Order order = null;
                        try {
                            order = BeanFactory.getOrder(orderName);
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        if (orders.contains(order)) {
                            orderButton.setSelected(true);
                        }
                    }
                }
            });
        }//设置手势选择

        star.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MotionTrack motionTrack = MotionTrack.getInstance();
                LogPrint.getInstance().printLog("开始跟踪手势...\n");
                motionTrack.setStop(false);
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MotionTrack motionTrack = MotionTrack.getInstance();
                LogPrint.getInstance().printLog("暂停跟踪手势...\n");
                motionTrack.setStop(true);
            }
        });

        //设置保存按钮
        saveConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, Object> request = new HashMap<>();
                ArrayList<String> orderNames = new ArrayList<>();
                request.put("motionName", presentMotionName);
                for (OrderButton orderButton : OrderButtons) {
                    if (orderButton.isSelected()) {
                        orderNames.add(orderButton.getOrderName());
                    }
                }
                request.put("orderNames", orderNames);
                Controller controller = Controller.getInstance();
                try {
                    controller.executeAction("setOrder", request);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
