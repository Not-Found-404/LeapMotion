package com.qtu404.leapmotion.motion.impl;

import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;
import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.leapmotion.motion.HandMotion;

public class RightHandRight extends HandMotion {
    private RightHandRight() {
        super.setHandSignal("rightHand →:\t");
    }

    private static RightHandRight singleton = new RightHandRight();
    public static RightHandRight getInstance() {
        return singleton;
    }

    @Override
    public boolean judge(Judge judge) {
        Frame presentFrame = judge.getPresentFrame();
        Frame lastFrame = judge.getLastFrame();
        boolean flag = false;

        for (Hand hand : presentFrame.hands()) {
            if (hand.isLeft()) {
                continue;
            }
            int handId = hand.id();
            Hand sameHand = lastFrame.hand(handId);

            if (sameHand == null) {
                continue;
            } else {
                Vector lastPosition = sameHand.palmPosition();
                Vector presentPosition = hand.palmPosition();

                flag = Judge.isDirectRight(presentPosition, lastPosition);
            }
        }
        return flag;
    }
}
