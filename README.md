# RFXCOM for Java

----------------------------------------------------------------------------                      
Software License Agreement                       
 Copyright 2011-2016, RFXCOM 
 ALL RIGHTS RESERVED. This code is owned by RFXCOM, and is protected under 
 Netherlands Copyright Laws and Treaties and shall be subject to the  
 exclusive jurisdiction of the Netherlands Courts. The information from this 
 file may freely be used to create programs to exclusively interface with 
 RFXCOM products only. Any other use or unauthorized reprint of this material 
 is prohibited. No part of this file may be reproduced or transmitted in 
 any form or by any means, electronic or mechanical, including photocopying, 
 recording, or by any information storage and retrieval system without 
 express written permission from RFXCOM. 
 
 The above copyright notice shall be included in all copies or substantial 
 portions of this Software. 
----------------------------------------------------------------------------- 

This project is targeted to use RFXCOM device from Java environment

The aim is to be able to use RFXCOM devices (as RFXtrx433E devices in a java environment).

 This project is firstly design to be use in Linux Raspberry Pi java context.
 This Project exist because default RFXCOM public provided tools is targeted for Windows(r) environment.
 
 There is no Java native library dependency, the project invokes standard linux command instead (mkfifo, stty ...) to be able to configure and use the serial port, by this way the program is directly runnable everywhere without architecture limitation. Therefore the target is "Only Linux alike system, enabled with USB FTDI serial port device, and a Java JVM available"
 
----------------------------------------------------------------------------                      
## Install and Run on PI or other Linux machine

### Environment
- Java + Javac: Oracle or OpenJDK 1.8
- Kernet module for FTDI USB devices (RFXCOM device seen as **/dev/ttyUSBx**  (with x above or equal to 0)
- User is able to access to **/dev/ttyUSBx** (e.g user has secondary group on 'dialout')

### Get project
Clone this project on a dedicated folder on you Raspberry Pi or Linux Machine
In this project all compiled class are already provided in build folder.

### Configure
if your device is not **/dev/ttyUSB0** then you need to change the file **config.properties**
To enable the listening of particular protocol you've to modify the file **config.properties** , the key **rfxtrx.protocol.enable**

### Compile project
Execute (this project already provide the compiled classes, compilation is needed only if you change the source code)

    ./compile.sh

### Execute project

Direct mode

    ./run.sh

Simple daemonized mode

    nohup ./run.sh 1>trace.log 2>&1


------    
# Use the project

During execution the project has an input and an output
## The Input : Send a message over the air
When the project runs, a named pipe **pipeMsgSend** is created by default at the same location as the **config.properties** file.
To send a message over the air (through RFXCOM device)
just print out the command to **pipeMsgSend**
example, to Switch On a Chacon power plug on House 'I' address 1

    $> echo "chacon_on('I',1)" > pipeMsgSend

The available commands are defined in **extension.js** file
The base command library is defined in file **src/ysm/domo/rfxcom/rfxtrx/protocol/generateMessage.js**

## The Output : Execute something when a message arrive
When an message is recieved for a particular protocol enabled (see key **rfxtrx.protocol.enable** in **config.properties**) then the script **event.sh** is invoked with a set of **RFXCOM_*** environment variables
You may customized the event.sh script with your own purpose or change the keys **rfxtrx.protocol.event.*** in **config.properties** file to execute another shell script or executable


