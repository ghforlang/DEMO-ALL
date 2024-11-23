#!/bin/bash

function getIp(){
    /sbin/ifconfig $1 | grep 'inet';
    echo
}
echo getIp echo;