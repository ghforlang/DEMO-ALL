#!/bin/bash

token_request_url="http://192.168.1.46:2000/user_token"
register_order_request_url="http://192.168.1.46:2000/register_order"

search_token="curl -H "Content-Type:application/json" -H "username:hrs_order" -H "password:2d75b141a26d0060c8cc6876db5be5a7" -X POST "$token_request_url""
search_token=$($search_token)
#打开可调试查看
echo $search_token
token_result=`echo $search_token | sed 's/,/\n/g' | grep "token" | sed 's/:/\n/g' | sed 's/}/\n/g' | sed 's/]/\n/g'| sed '1d' | sed 's/"//g' | sed '1d'`
echo $token_result

register_order_result="curl -H "Content-Type:application/json" -X POST -d '{"create_time_range":"2022-10-15T00:00:00Z\|*","token":"$token_result","start":"0","rows":"10"}' "$register_order_request_url""
register_order_result=$($register_order_result)
echo $register_order_result
register_order_message=`echo $register_order_result | sed 's/,/\n/g' | grep "message" | sed 's/:/\n/g' | sed '1d'`
echo "$register_order_message"
alarm_result="curl -H "Content-Type:application/json"  -X POST -d '{"msgtype":"text","text":{"content":"$register_order_message"}}' "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=5deb8878-c7d5-48ee-a108-7e6352e5c766""
echo $($alarm_result)

exit 0