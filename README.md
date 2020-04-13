### Task 11 - DAO layer
Create Spring JDBC based DAO for your application.

1. make.sh    # Builds the project (clears dist/ dir and repopulates it with JAR and etc.) except the db image
2. make-db.sh # Builds Docker image of database and pushes it to Docker registry (hub.docker.com if not specified otherwise)
3. dist/:
    1. university.sh
    2. university-SNAPHOST-1.0.jar
    3. university-db.sh # Runs docker image, must be executed before the `university.sh`
    4. README.md # Readme file with how-to-run for the end-user / admin who will install/deploy univeristy app on the production server
4. README.md  # Readme for a developer, about opening the project in the IDE, what tools/versions required to build it, etc.```

### Make executable jar files

In project directory run one of "make" sctipts, depending on your operating system(make.sh for Mac or Linux, make.bat from Windows).
Make script will save jar file in directory `./dist`

### Run project
If you have already created "university" database with user "manager" on localhost 5432 you can simply run "university" script. 
If not you need to run "make-db" script(to create docker image) and then run "university-db" sctipt to run docker image.
