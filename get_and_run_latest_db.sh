#!/usr/bin/env bash
PORT=${5432:-5432}

DEV_DB_IMG="tabarkevych/universitydatabase"
docker pull ${DEV_DB_IMG}
if [ $? -eq 0 ]
then
    docker rm -v -f universitydatabase || true
	docker run -d -p ${PORT}:5432 -e POSTGRES_PASSWORD=1111 -e POSTGRES_USER=manager -e POSTGRES_DB=university --name=universitydatabase ${DEV_DB_IMG}
    echo "Database will come up on port 5432 within a few minutes"
else
	echo "Error! Docker pull failed."
fi