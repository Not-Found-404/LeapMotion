package com.qtu404.leapmotion.motion.impl;

import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;
import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.leapmotion.motion.HandMotion;

public class LeftHandUp extends HandMotion {
    private LeftHandUp() {
        super.setHandSignal("leftHand ↑:\t");
    }

    private static LeftHandUp singleton = new LeftHandUp();

    public static LeftHandUp getInstance() {
        return singleton;
    }

    @Override
    public boolean judge(Judge judge) {
        boolean flag = false;
        Frame presentFrame = judge.getPresentFrame();
        Frame lastFrame = judge.getLastFrame();

        for (Hand hand : presentFrame.hands()) {
            if (!hand.isLeft()) {
                continue;
            }
            int handId = hand.id();
            Hand sameHand = lastFrame.hand(handId);

            if (sameHand == null) {
                continue;
            } else {
                Vector presentPosition = hand.palmPosition();
                Vector lastPosition = sameHand.palmPosition();

                flag = Judge.isDirectUp(presentPosition, lastPosition);
            }
        }
        return flag;
    }
}
