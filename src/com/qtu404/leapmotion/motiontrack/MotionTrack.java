package com.qtu404.leapmotion.motiontrack;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.qtu404.leapmotion.motion.Motion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MotionTrack {
    private MotionTrack() {
    }

    private static MotionTrack singleton = new MotionTrack();

    public static MotionTrack getInstance() {
        return singleton;
    }

    ArrayList<Motion> motions = new ArrayList<>(0);

    int emptyAmount = 0;//连续没有收到手势数据的帧 的数量

    Map<String, String> motionOrderLock = new HashMap<>(0);//手势命令锁， 同一只手只能产生一个命令 防止多次产生命令

    ArrayList<Frame> frames = new ArrayList<>(0);

    private boolean isStop = true;

    public void addMotion(Motion motion) {
        motions.add(motion);
    }

    public void removeMotion(Motion motion) {
        motions.remove(motion);
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    void doJudge(Judge judge) {
        Frame presentFrame = judge.getPresentFrame();
        for (Hand hand : presentFrame.hands()) {
            int handId = hand.id();
            if (motionOrderLock.get(String.valueOf(handId)) == null) {
                motionOrderLock.put(String.valueOf(handId), "");

                for (Motion motion : motions) {
                    if (motion.judge(judge)) {
                        motion.doOrder();
                    }
                }
            }
        }
    }

    public void excute(Controller controller) {
        while (true) {
            if (isStop) {
                System.out.print("");
                continue;
            }
            try {
                Thread.sleep(Config.catchCycle);
            } catch (Exception e) {
            }

            Frame frame = controller.frame();
            HandList hands = frame.hands();
            if (hands.isEmpty()) {//当前没有收到手势
                emptyAmount++;//空帧次数累加
                if (emptyAmount >= Config.maxEmpty) {//连续收到两个以上的空帧
                    frames.clear();
                }
            } else {//当前收到手势
                emptyAmount = 0;//重置空帧次数
                frames.add(0, frame);//添加到队头

                if (frames.size() >= Config.maxCache + 1) {//去掉超过的
                    frames.remove(Config.maxCache);
                }

                if (frames.size() == Config.maxCache - 2) {//判断最近8个的帧的信息
                    Judge judge = new Judge(frames);
                    doJudge(judge);
                }
            }

        }

    }
}
