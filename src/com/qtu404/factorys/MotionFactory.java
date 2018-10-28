package com.qtu404.factorys;

import com.qtu404.leapmotion.motion.Motion;
import com.qtu404.leapmotion.motion.impl.*;

public class MotionFactory {
    public static Motion getMotion(String motionType) throws ClassNotFoundException {
        Motion reslut = null;
        switch (motionType) {
            case "左手右挥":
                reslut = LeftHandRight.getInstance();
                break;
            case "左手左挥":
                reslut = LeftHandLeft.getInstance();
                break;
            case "左手上挥":
                reslut = LeftHandUp.getInstance();
                break;
            case "左手下挥":
                reslut = LeftHandDown.getInstance();
                break;


            case "右手下挥":
                reslut = RightHandDown.getInstance();
                break;
            case "右手右挥":
                reslut = RightHandRight.getInstance();
                break;
            case "右手左挥":
                reslut = RightHandLeft.getInstance();
                break;
            case "右手上挥":
                reslut = RightHandUp.getInstance();
                break;
            default:
                throw new ClassNotFoundException("没有\"" + motionType + "\"这个手势，参数形如 左手左挥");
        }
        return reslut;
    }
}
