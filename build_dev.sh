#!/bin/bash
mvn clean package -DskipTests
cp yudao-server/target/yudao-server.jar /Users/consul/work/app
