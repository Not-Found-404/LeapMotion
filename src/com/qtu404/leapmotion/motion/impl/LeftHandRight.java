package com.qtu404.leapmotion.motion.impl;

import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;
import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.leapmotion.motion.HandMotion;
import com.qtu404.leapmotion.motion.Motion;


public class LeftHandRight extends HandMotion {
    private static LeftHandRight singleton = new LeftHandRight();

    public static Motion getInstance() {
        return singleton;
    }

    private LeftHandRight() {
        super.setHandSignal("leftHand →:\t");
    }

    @Override
    public boolean judge(Judge judge) {
        Frame presentFrame = judge.getPresentFrame();
        Frame lastFrame = judge.getLastFrame();
        boolean flag = false;
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

                flag = Judge.isDirectRight(presentPosition, lastPosition);
            }
        }
        return flag;
    }
}
