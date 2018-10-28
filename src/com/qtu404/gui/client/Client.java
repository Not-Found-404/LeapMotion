package com.qtu404.gui.client;

import com.leapmotion.leap.Controller;
import com.qtu404.factorys.BeanFactory;
import com.qtu404.factorys.GUIFactory;
import com.qtu404.gui.compents.MainFrame;
import com.qtu404.leapmotion.motion.Motion;
import com.qtu404.leapmotion.motiontrack.MotionTrack;
import com.qtu404.scoket.SocketClient;
import com.qtu404.tool.LogPrint;

import javax.swing.*;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupB  uttonVisble", false);
        } catch (Exception e) {
            //TODO exception
        }

        Motion leftHandLeft = BeanFactory.getMotion("左手左挥");// 1
        leftHandLeft.addOrder(BeanFactory.getOrder("开电风扇"));

        Motion leftHandRight = BeanFactory.getMotion("左手右挥");// 2
        leftHandRight.addOrder(BeanFactory.getOrder("关电风扇"));

        Motion leftHandUp = BeanFactory.getMotion("左手上挥");// 3
        leftHandUp.addOrder(BeanFactory.getOrder("开灯"));

        Motion rightHandUp = BeanFactory.getMotion("右手上挥");// 4
        rightHandUp.addOrder(BeanFactory.getOrder("开门"));

        Motion leftHandDown = BeanFactory.getMotion("左手下挥");// 5
        leftHandDown.addOrder(BeanFactory.getOrder("关灯"));

        Motion rightHandLeft = BeanFactory.getMotion("右手左挥");// 6
        rightHandLeft.addOrder(BeanFactory.getOrder("拉开窗帘"));

        Motion rightHandRight = BeanFactory.getMotion("右手右挥");// 7
        rightHandRight.addOrder(BeanFactory.getOrder("关闭窗帘"));

        Motion rightHandDown = BeanFactory.getMotion("右手下挥");// 8
        rightHandDown.addOrder(BeanFactory.getOrder("关门"));

        MotionTrack motionTrack = MotionTrack.getInstance();
        motionTrack.setStop(true);
        motionTrack.addMotion(leftHandLeft);//1
        motionTrack.addMotion(leftHandRight);//2
        motionTrack.addMotion(leftHandUp);//3
        motionTrack.addMotion(leftHandDown);//5
        motionTrack.addMotion(rightHandUp);//4
        motionTrack.addMotion(rightHandLeft);//6
        motionTrack.addMotion(rightHandRight);//7
        motionTrack.addMotion(rightHandDown);//8

        SocketClient.setSocketConnect(true);//连接
        MainFrame mainFrame = (MainFrame) GUIFactory.getMainFrame();

        Thread back = new Thread() {
            @Override
            public void run() {
                super.run();
                motionTrack.excute(new Controller());
            }
        };

        back.start();

        LogPrint.getInstance().printLog("初始化完成...\n");
    }
}
