### Task 11 - DAO layer
Create Spring JDBC based DAO for your application.
Create sctipts: 
1. make.sh    # Builds the project (clears dist/ dir and repopulates it with JAR and etc.) except the db image
2. make-db.sh # Builds Docker image of database and pushes it to Docker registry (hub.docker.com if not specified otherwise)
3. dist/:
    1. university.sh
    2. university-SNAPHOST-1.0.jar
    3. university-db.sh # Runs docker image, must be executed before the `university.sh`
    4. README.md # Readme file with how-to-run for the end-user / admin who will install/deploy univeristy app on the production server
4. README.md  # Readme for a developer, about opening the project in the IDE, what tools/versions required to build it, etc.

### Required technologies:
1. Java 1.8 or newer version.
2. Windows, Mac, or Linux.

### How to run the project:
1. Run make.sh to create jar file.
2. Run make-db.sh to create docker image with database(before your run this script be sure that your docker is running).
3. In dist folder run univerisity-db.sh. This script will run docker image with database.
4. In dist folder run univerisity.sh. This script will run the program.