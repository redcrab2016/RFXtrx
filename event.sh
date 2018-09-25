#!/bin/bash
echo "----------------" >> /home/famille/Projects/RfxCom/event.log
env | grep RFXCOM_ | sort -r >>  /home/famille/Projects/RfxCom/event.log
 #echo "Hello $1" >> /home/famille/Projects/RfxCom/event.log
