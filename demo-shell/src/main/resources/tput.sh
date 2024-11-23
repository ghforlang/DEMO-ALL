#!/bin/bash
#终端处理工具，tput,stty

#获取终端行列数
tput cols
tput lines
#打印当前终端名
tput longname
#光标移动到坐标(100,100)处
tput cup 100 100
#设置终端背景色,n=0~7
tput setb n
#设置终端前景色,n=0~7
tput setf n
#文本样式为粗体
tput bold
#设置下划线起止
tput smul
tput rmul
#删除从当前光标位置到行尾的所有内容
tput ed

#date 命令
date
date +%s
#时间转换为纪元时,mac不好使
date  --date "Wed mar 15 08:09:16 EDT 2017" +%s
date --date "Jan 20 2001" +%A
#格式化时间
date "+%d %B %Y"
#设置时间 date -s "格式化的日期字符串"
date -s "格式化的日期字符串"
#系统联网环境下，可以使用ntpdate设置日期和时间
/usr/sbin/ntpdate -s time-b.nist.gov



