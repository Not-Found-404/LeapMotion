## 总体思路
### 系统组成
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


### 理论依据
+ 计算网络中的socket 
    + https://en.wikipedia.org/wiki/Network_socket

+ 树莓派
    + https://www.raspberrypi.org/

+ leapmotion
    + https://developer.leapmotion.com/documentation/

### 主要技术
+ python驱动硬件

+ java编程分析手势

+ socket在不同进程之间进行通信


## 启动教程
### 启动PC的client端
+ 打开我放在基地办公室的电脑，密码不知道私我


+ 将leapmotion传感器与电脑的usb接口连接，leapmotion在我柜子的第一层

+ 检查电脑上leapmotion的驱动是否正常
    + 打开电脑右下角的隐藏菜单栏，双击名为'Leap Motion 控制面板'的图标
        + 图标绿色即为正常
        + 红色则有异常，多半是leapmotion表面有污渍
        + 黑色则是未启动，说明leapmotion没有与电脑的usb连接
    + 若是驱动没有正常启动，alt+空格 呼出输入框，键入 ‘leap’，选择 'Leap Motion 控制面板'

+ 打开电脑之后，alt+空格 呼出输入框。键入 ‘idea’，打开IDEA，接着打开其中名为leapmotion的项目

+ 运行 `com.qtu404.gui.client.Client`，若是程序界面出现空白或者透明，则将程序窗口最小化，再打开即可。点击开始键，则可以开始进行手势命令。

### 启动树莓派的Service端
+ 我已经将树莓派里python的service端启动了，不出意外，现在树莓派应该是一直开着的，鼠标和显示器被我拔了，但是你们什么都不用管。若是树莓派意外关闭，需要按照以下步骤启动

+ 将树莓派开机，

### 安卓端启动
+ 打开电脑，alt+空格 呼出输入框，键入‘and’，选择AndroidStudio，选择其中的项目，怎么通过AndroidStudio给手机安装程序，自行google，不赘述

+ 打开程序，选择对应的指令

### 注意事项
+ 所有终端必须连接办公室的WIFI!!!

+ Java端的socket以特定的IP地址发送命令，次IP地址，必须与树莓派所被分配的IP地址一致

+ 电池盒没有打开，使用电灯和风扇命令时，需要注意