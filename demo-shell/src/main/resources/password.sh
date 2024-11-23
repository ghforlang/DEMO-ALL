#!/bin/bash
#Filename: password
echo -e "enter password :"
#读取密码前禁止回显
stty -echo
read password

# 允许回显
#stty echo
#read password
#echo Password read