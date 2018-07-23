#!/bin/sh
cd Exam1
mvn clean install
cd ..

cd docker/mysql/
docker build -t mysql:v1 .

cd ..
cd ..
docker build -f docker/java/Dockerfile -t java:v1 .






