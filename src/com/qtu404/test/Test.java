package com.qtu404.test;


public class Test {
    public static void main(String[] args) {
        System.out.print("asd\n");
        System.out.print("asd");
    }
}

class changer {
    public static native int SystemParametersInfo(int uiAction, int uiParam, String pvParam, int fWinIni);

    static {
        System.loadLibrary("user32");
    }

    public int Change(String path) {
        return SystemParametersInfo(20, 0, path, 0);
    }

}