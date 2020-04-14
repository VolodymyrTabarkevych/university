FROM postgres:alpine
ENV POSTGRES_USER manager
ENV POSTGRES_PASSWORD 1111 
ENV POSTGRES_DB university 
COPY src/main/resources/sql-script/.initialization/init.sql /docker-entrypoint-initdb.d/