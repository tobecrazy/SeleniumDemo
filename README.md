# SeleniumDemo
Selenium automation test framework
[![Build Status](https://www.travis-ci.org/tobecrazy/SeleniumDemo.svg?branch=master)](https://www.travis-ci.org/tobecrazy/SeleniumDemo) 

最近有打算用python重写一下，感兴趣的朋友可以fork
首先需要安装python，之后安装selenium lib
pip install -U selenium


Use Selenium 3.x  + testng + Jenkins + Maven 

Use Page object model

Use log4j

如何使用：
1. 安装maven配置环境变量
2. git clone  https://github.com/tobecrazy/SeleniumDemo.git
3. mvn test
也可以直接使用jenkins，触发mvn test

使用interface 处理不同版本的页面，
使用java反射机制实现页面跳转
使用java 注解实现不同类反射初始化
使用单例模式实现初始化唯一driver对象
已废弃Ant
引入Spring

2018/8/19
引入docker，使用Selenium docker

2017/6/21
添加python版selenium Demo
说明：最近在搞爬虫，采用python scrappy框架，因此顺便搞一下python版本的selenium
并将原有方法重新使用python封装一遍。
喜欢使用python的朋友也可以参考。
目录为：PythonSelnium 
2018/6/4
优化HTML Report
![Alt text](https://github.com/tobecrazy/SeleniumDemo/blob/master/Report.gif  "HTML Report") 
将会添加爬虫相关内容。持续更新！！！！
2018/07/21
推荐使用selenium docker， 可以直接使用docker image 构建Grid。
配置的VNC端口5901 for chrome, 5902 for firefox.

Roadmap
1. 使用Builder设计模式(Done)
2. 优化测试报告 (in-progress)
3. 使用容器，抽象出单独的截图服务
4. Refactor 页面元素加载功能
5. 加入预判环境功能，通过http response code判断环境
6. Selenium UI自动化优化测试脚本心得整理
7. 加入图像对比，实现处理拖拽验证码
8. 使用Jacoco 做code coverage
![Alt text](https://github.com/tobecrazy/SeleniumDemo/blob/master/code%20coverage.png "Snapshot")

![Alt text](https://github.com/tobecrazy/Demo/blob/master/jenkins.png  "Snapshot")
![Alt text](https://github.com/tobecrazy/SeleniumDemo/blob/master/Jenkins%20code%20coverage%20.png  "Snapshot")
9.使用Sonar 扫描代码code

![Alt text](https://github.com/tobecrazy/SeleniumDemo/blob/master/sonar.png  "Snapshot")
10.使用findbugs
![Alt text](https://github.com/tobecrazy/Demo/blob/master/findbugs.png  "Snapshot") 

微信公共账号：

![Alt text](https://github.com/tobecrazy/Demo/blob/master/weixin.gif  "weixin")

