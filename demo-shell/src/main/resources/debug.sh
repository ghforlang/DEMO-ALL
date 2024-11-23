#!/bin/bash

#sh脚本调试,
# 启用shell脚本的跟踪调试功能;-x选项的脚本可以打印出所执行的每一行命令以及当前状态
#bash -x demo.sh
#代码层面新增调试点
for i in {1..6};
do
  # 调试开始点
 set -x
 echo $i
 set +x
 # 调试结束点
done

# 通过定义 _DEBUG环境变量来启用或禁止调试及生成特定形式的信息
function DEBUG() {
    [ "$_DEBUG" == "on" ] && $@ ||:
}
#使用的时候如下
for i in {1...10}
do
  DEBUG echo "I is $i"
done
#或者使用 _DEBUG=on ./demo.sh；命令中 : 告诉bash什么也不要做

# #!/bin/bash改成 #!/bin/bash -xv，这样一来，不用任何其他选项就可以启用调试功能了。
#调试显示行号,设置环境变量值,PS4='$LINENO: '
#调试日志输出到文件
sh -x testScript.sh 2> debugout.txt
