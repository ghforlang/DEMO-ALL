#!/bin/bash

#数组声明
arrays=(test1 test2 test3 test4)
echo ${arrays[0]}
index=3
echo ${arrays[$index]}

array[0]=test0
echo ${array[0]}

#列表形式打印所有数组元素
echo ${arrays[*]}

#打印数组长度
echo ${#arrays[*]}

#关联数组
declare fruit_cost
fruit_cost=([apple]='100$' [orange]='20$')
echo "apple cost ${fruit_cost[apple]} "

#数组索引
echo ${!arrays[*]}
echo ${!fruit_cost[*]}

#临时别名
alias install='sudo apt-get install'
#永久别名，每次启动shell都会执行~/.bashrc中的命令
echo 'alias install="sudo apt-get install"' >> ~/.bashrc
#别名删除,两种方式
unalias install
alias install=
#举例，备份文件并删除
alias rm='cp $@ ~/backup && rm $@'