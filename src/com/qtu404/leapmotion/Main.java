package com.qtu404.leapmotion;

import com.leapmotion.leap.Controller;
import com.qtu404.factorys.BeanFactory;
import com.qtu404.leapmotion.motiontrack.MotionTrack;
import com.qtu404.leapmotion.motion.Motion;
import com.qtu404.scoket.SocketClient;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        MotionTrack motionTrack = MotionTrack.getInstance();

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

        motionTrack.addMotion(leftHandLeft);//1
        motionTrack.addMotion(leftHandRight);//2
        motionTrack.addMotion(leftHandUp);//3
        motionTrack.addMotion(leftHandDown);//5
        motionTrack.addMotion(rightHandUp);//4
        motionTrack.addMotion(rightHandLeft);//6
        motionTrack.addMotion(rightHandRight);//7
        motionTrack.addMotion(rightHandDown);//8

        SocketClient.setSocketConnect(false);//连接
        motionTrack.excute(new Controller());
        motionTrack.setStop(false);
        System.out.println("Begin to tracking motion");
    }
}
