package com.qtu404.leapmotion.motion.impl;

import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;
import com.qtu404.leapmotion.motiontrack.Judge;
import com.qtu404.leapmotion.motion.HandMotion;
import com.qtu404.leapmotion.motion.Motion;

public class RightHandLeft extends HandMotion {
    private RightHandLeft() {
        super.setHandSignal("rightHand ←:\t");
    }

    private static RightHandLeft rightHandLeft = new RightHandLeft();

    public static Motion getInstance() {
        return rightHandLeft;
    }

    @Override
    public boolean judge(Judge judge) {
        boolean flag = false;
        Frame presentFrame = judge.getPresentFrame();
        Frame lastFrame = judge.getLastFrame();

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

                flag = Judge.isDirectLeft(presentPosition, lastPosition);
            }
        }

        return flag;
    }
}
