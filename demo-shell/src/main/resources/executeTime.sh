#!/bin/bash
#Filename : executeTime.sh
# date 命令可以换成time
start=$(date +%s)
commands;
statements;
end=$(date +%s)
difference=$((end - start))
echo "time taken to execute commands is $difference seconds"