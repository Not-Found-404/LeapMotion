package com.qtu404.scoket;

import com.qtu404.tool.LogPrint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketClient {

    private final String serverLocation = "192.168.2.149";//接收端地址

    private final int serverPort = 8001;//接收端端口

    private static boolean socketConnect = true;

    public static void setSocketConnect(boolean socketConnect) {
        SocketClient.socketConnect = socketConnect;
    }

    public String execute(String mess) {

        if (!socketConnect) {
            LogPrint.getInstance().printLog(mess + "\n");
            return null;
        }
        LogPrint.getInstance().printLog("connect:" + mess + "\n");

        String info = null;
        try {
            Socket socket = new Socket(serverLocation, serverPort);
            //获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
            pw.write(mess);
            pw.flush();
            socket.shutdownOutput();//关闭输出流

            InputStream is = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            ;
            is.close();
            in.close();
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static void main(String[] args) {
        new SocketClient().execute("closeFan");
    }
}