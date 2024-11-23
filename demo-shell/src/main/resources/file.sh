#!/bin/bash
# 文件重定向与描述符
#0 —— stdin （标准输入）。
#1 —— stdout（标准输出）。
#2 —— stderr（标准错误）
#标准错误重定向到out.txt文件
ls + 2>>out.txt
#多个标准错误、输出重定向到out.txt
cmd 2>out.txt 1>out.txt
#cmd 2>&1 out.txt
#输出文件到temp.txt，覆盖
echo "hello world" > temp.txt
#追加
echo "hello sb" >> temp.txt

#出现在EOF之前的内容都会被写入到log.txt中
cat <<EOF> log.txt
This is a generated file. Do not edit. Changes will be overwritten
EOF

#自定义文件描述符 exec命令创建全新的文件描述符

