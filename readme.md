## 总体思路
+ 系统组成
    + leapmotion
        + 一种传感设备，与pc相连接，用于接受手势数据（就是一种类似于键盘的输入输出设备）
    + 一台PC
        + 运行Java来分析手势数据，根据手势数据，识别出不同的的指令，之后使用socket向树莓派发送指令 
    + 树莓派
        + 一个小型的计算机(Linux系统)，可以联网，其上有引脚可以连接硬件
        + 运行一段python程序，当收到pc发来的消息之后，python程序会根据收到的不同命令去启动舵机或者是继继电器
    + 一些硬件
        + 舵机
            + 与树莓派连接，可以转动，来完成开门和窗帘的动作
        + 继电器
            + 与树莓派相连，相当于开关
        + 风扇
            + 与继电器相连，继电器打开的时候可以转动
        + 灯
            +  与继电器相连，继电器打开的时候可以亮
    + ![image](http://www.qtu404.com/imageLib/github/xtkjyl.png)
+ 
## 理论依据
+ 计算网络中的socket 
    + https://en.wikipedia.org/wiki/Network_socket

+ 树莓派
    + https://www.raspberrypi.org/

+ leapmotion
    + https://developer.leapmotion.com/documentation/

## 主要技术
+ python驱动硬件

+ java编程分析手势

+ socket在不同进程之间进行通信

## 实施方案
+ 

## 创新点
+ 

## 关键技术
+ leapmotion
    + https://developer.leapmotion.com/documentation/