package com.qtu404.leapmotion.motion.impl;

import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;
import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.leapmotion.motion.HandMotion;
import com.qtu404.leapmotion.motion.Motion;

public class LeftHandLeft extends HandMotion {
    private LeftHandLeft() {
        super.setHandSignal("leftHand ←:\t");
    }

    private static LeftHandLeft singleton = new LeftHandLeft();

    public static Motion getInstance() {
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
                Vector lastPosition = sameHand.palmPosition();
                Vector presentPosition = hand.palmPosition();

                flag = Judge.isDirectLeft(presentPosition, lastPosition);
            }
        }

        return flag;
    }

}
