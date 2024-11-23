#!/bin/bash
# 执行方式
# 1 bash xxx.sh
# 2 给文件赋权 chmod 775 xxx.sh,变为可执行脚本, 然后使用 ./xxx.sh 执行
# 3 ~ 表示主目录，通常是 /home/user
# 4 $ cmd1 ; cmd2 等价于 $cmd1  $cmd2
# 5 打印彩色文本 (：重置=0，黑色=30，红色=31，绿色=32，黄色=33，蓝色=34，洋红=35，青色=36，白色=37。) echo -e "\e[1;31m this is red text\e[0m";
# 6 设置文本背景 echo -e "\e[1;42m Green Background \e[0m"
# 7 可以使用 env命令查看当前所有的环境变量;要查看其他进程的环境变量，可以使用如下命令（管道命令tr,将空白字符替换为换行符）： #cat /proc/$PID/environ | tr '\0' '\n';
# 8 查看进程id，例如，查看java进程id，pgrep java
# 9 export命令声明了将由子进程所继承的一个或多个变量。这些变量被export后，当前shell脚本所执行的任何应用程序都会获得这个变量
# 10 内置变量使用；(1) 获取字符串长度  ${#var} (2)查看当前使用的shell $$SHELL ，或者$0 ;(3)环境变量UID中保存的是用户ID,root用户id为0。它可以用于检查当前脚本是以root用户还是以普通用户的身份运行的。
# 11 数学运算 let/[]/(())





echo hello world;
#echo -e "\e[1;31m this is red text\e[0m";
#echo -e "\e[1;42m Green Background \e[0m";

fruit=apple
count=4
echo "we have $count ${fruit}s"

length="fagafdagafsd"
echo ${#length}

echo $SHELL
echo $0

#echo $UID

if [ $UID -ne 0 ]; then
 echo "not root 用户，请使用root用户登录"
else
 echo "root用户登录"
fi

#数学运算,整形值
no1=3
no2=4
let result=no1+no2
result2=$[no1+no2]
result3=$((no1+no2))
echo $result
echo $result2
echo $result3

#数学运算，高级工具bc
echo "4 * 0.5" | bc
no=50
echo "$no * 2.0" | bc
#两位有效数字
echo "scale=2;22/7" | bc
#进制转换
nox=100
echo "obase=2;$nox" | bc
echo "obase=8;$nox" | bc
echo "obase=16;$nox" | bc
echo "obase=10;$nox" | bc
echo "sqrt(169)" | bc
