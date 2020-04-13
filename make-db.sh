#!/usr/bin/env bash

INIT_SQL_DIR="src/main/resources/sql-script/.initialization"
IMAGE_NAME="universitydatabse"

#Remove previous image if it exist
if [[ "$(docker images -q -a ${IMAGE_NAME} 2> /dev/null)" != "" ]]; then
  docker image rm ${IMAGE_NAME} 
fi

# Checks file integrity. And uses Dockerfile from the root of the project to create/replase image
if [ -d ${INIT_SQL_DIR} ]; then
  docker build -t ${IMAGE_NAME} .
  docker tag universitydatabse tabarkevych/universitydatabse
  docker push tabarkevych/universitydatabse
else
  echo "build docker image is impossible, directory ${INIT_SQL_DIR} with configuration files is missing"
fi