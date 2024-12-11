#!/bin/bash
set -ex
mvn clean package -DskipTests
cp yudao-server/target/yudao-server.jar /Users/consul/work/app
docker-compose -f /Users/consul/work/compose/ruoyi.yml down
docker-compose -f /Users/consul/work/compose/ruoyi.yml up -d