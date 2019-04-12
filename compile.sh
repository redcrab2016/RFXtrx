#!/bin/bash
set -u
scriptpath=${0%/*}
pushd "$scriptpath" 1>/dev/null 2>&1
scriptpath="`pwd`"
popd 1>/dev/null 2>&1

javac -sourcepath $scriptpath/src/. -d $scriptpath/build/. src/ysm/domo/rfxcom/Service.java
