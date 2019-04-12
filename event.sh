#!/bin/bash
set -u
scriptpath=${0%/*}
pushd "$scriptpath" 1>/dev/null 2>&1
scriptpath="`pwd`"
popd 1>/dev/null 2>&1

TARGETPATH="$scriptpath/event.log"
echo "----------------" >> $TARGETPATH
date +"%Y-%m-%d %H:%M:%S">> $TARGETPATH
env | grep RFXCOM_ | sort -r >>  $TARGETPATH
 #echo "Hello $1" >> /home/famille/Projects/RfxCom/event.log
