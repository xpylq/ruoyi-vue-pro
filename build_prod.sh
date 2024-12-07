#!/bin/bash
mvn clean package -DskipTests
scp -P 9527 yudao-server/target/yudao-server.jar root@137.220.227.153:/data/app/
