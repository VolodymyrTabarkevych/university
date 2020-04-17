###Task 12 - Service Layer
Create a service layer and implement business logic (add/remove entities to other entities and save them to DB, etc). A mentor can provide additional business rules.

You should use Spring IoC.

### Required technologies:
1. Java 1.8 or newer version.
2. Windows, Mac, or Linux.

### How to run the project:
1. Run make.sh to create jar file.
2. Run make-db.sh to create docker image with database(before your run this script be sure that your docker is running).
3. In dist folder run univerisity-db.sh. This script will run docker image with database.
4. In dist folder run univerisity.sh. This script will run the program.