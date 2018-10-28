package com.qtu404.factorys;


import com.qtu404.leapmotion.order.Order;
import com.qtu404.leapmotion.order.impl.*;

public class OrderFactory {
    public static Order getOrder(String orderName) throws ClassNotFoundException {
        Order reslut = null;
        switch (orderName) {
            case "开门":
                reslut = OpenDoor.getInstance();
                break;
            case "关门":
                reslut = CloseDoor.getInstance();
                break;
            case "开灯":
                reslut = LightUp.getInstance();
                break;
            case "关灯":
                reslut = LightOff.getInstance();
                break;
            case "关电风扇":
                reslut = ShutElectricFan.getInstance();
                break;
            case "开电风扇":
                reslut = OpenElectricFan.getInstance();
                break;
            case "关闭窗帘":
                reslut = CloseCurtain.getInstance();
                break;
            case "拉开窗帘":
                reslut = OpenCurtain.getInstance();
                break;
            default:
                throw new ClassNotFoundException("没有 \"" + orderName + "\"这个命令");
        }
        return reslut;
    }
}
