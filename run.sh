#!/bin/bash
set -u
scriptpath=${0%/*}
pushd "$scriptpath" 1>/dev/null 2>&1
scriptpath="`pwd`"
popd 1>/dev/null 2>&1
export RFXCOM_ROOT_PATH="$scriptpath"
java -cp "$scriptpath/build/.:$scriptpath/src/." ysm.domo.rfxcom.Service "$RFXCOM_ROOT_PATH"
