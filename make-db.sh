#!/bin/env bash
INIT_SQL_DIR="src/main/resources/sql-script/.initialization"
IMAGE_NAME="university-database"
IMAGE_NAME_DOCKERHUB="tabarkevych/university-database"

#Remove previous image if it exist
if [[ "$(docker images -q -a ${IMAGE_NAME} 2> /dev/null)" != "" ]]; then
  docker image rm ${IMAGE_NAME} 
fi

# Checks file integrity. And uses Dockerfile from the root of the project to create/replase image
if [ -d ${INIT_SQL_DIR} ]; then
  docker build -t ${IMAGE_NAME} .
  docker tag ${IMAGE_NAME} ${IMAGE_NAME_DOCKERHUB}
  docker push ${IMAGE_NAME_DOCKERHUB}
else
  echo "build docker image is impossible, directory ${INIT_SQL_DIR} with configuration files is missing"
fi