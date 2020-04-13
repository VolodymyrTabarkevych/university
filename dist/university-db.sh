#!/usr/bin/env bash

DEV_DB_IMAGE="tabarkevych/universitydatabse"
CONTAINER_NAME="universitydatabase"
PORT=${1:-5432}

# Drop previous container if it's exit
if [ $(docker inspect --format="{{ .State.Running }}" ${CONTAINER_NAME} 2>/dev/null) ]; then
  echo "Please be informed that previous version of container will be dropped"
  docker rm -v -f ${CONTAINER_NAME} || true
fi

#Checking if docker image of db is exist. If true create container
if [[ "$(docker images -q ${DEV_DB_IMAGE} 2>/dev/null)" != "" ]]; then
  docker run --name=${CONTAINER_NAME} -e POSTGRES_PASSWORD=1111 -d -p ${PORT}:5432 ${DEV_DB_IMAGE}
else
  echo "Error! Docker image does not exist. Please run 'sql-jdbc-school-db.sh' in first place"
fi