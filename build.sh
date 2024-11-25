#!/bin/bash
mvn clean package -DskipTests
scp yudao-server/target/yudao-server.jar root@137.220.202.203:/data/app/
