package com.qtu404.leapmotion.motiontrack;


import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Vector;

import java.util.ArrayList;

public class Judge {
    private Frame presentFrame = null;
    private Frame lastFrame = null;
    ArrayList<Frame> frames = null;

    public Judge(ArrayList<Frame> frames) {
        this.frames = frames;
    }

    public Judge() {

    }

    public Frame getPresentFrame() {
        return this.frames.get(0);
    }

    public Frame getLastFrame() {
        return this.frames.get(Config.maxCache - 3);
    }

    public static boolean isToRight(Vector v1, Vector v2) {
        return (v1.getX() - v2.getX()) >= Config.minDistance;
    }

    public static boolean isToLeft(Vector v1, Vector v2) {
        return (v1.getX() - v2.getX()) <= -Config.minDistance;
    }

    public static boolean isToUp(Vector v1, Vector v2) {
        return (v1.getZ() - v2.getZ()) <= -Config.minDistance;
    }

    public static boolean isToDown(Vector v1, Vector v2) {
        return (v1.getZ() - v2.getZ()) >= Config.minDistance;
    }

    public static boolean isToHight(Vector v1, Vector v2) {
        return (v1.getY() - v2.getY()) >= Config.minDistance;
    }

    public static boolean isTolow(Vector v1, Vector v2) {
        return (v1.getY() - v2.getY()) <= -Config.minDistance;
    }

    public static boolean isDirectRight(Vector v1, Vector v2) {
        return (isToUp(v1, v2) || isToDown(v1, v2)) ? false : isToRight(v1, v2);
    }

    public static boolean isDirectLeft(Vector v1, Vector v2) {
        return (isToUp(v1, v2) || isToDown(v1, v2)) ? false : isToLeft(v1, v2);
    }

    public static boolean isDirectUp(Vector v1, Vector v2) {
        return (isToRight(v1, v2) || isToLeft(v1, v2)) ? false : isToUp(v1, v2);
    }

    public static boolean isDirectDown(Vector v1, Vector v2) {
        return (isToRight(v1, v2) || isToLeft(v1, v2)) ? false : isToDown(v1, v2);
    }
}
