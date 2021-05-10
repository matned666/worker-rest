# Workers rest

Simple test web app including 1 module for worker rest<br>
It is run with `docker-compose up`<br>
Wat does it do:
- simple crud manipulation of the worker entity and team creation
----------------------------

# Run with Docker or assign datasource to application.properties file

Dockerfile and docker-compose.yml<br>
entrypoint.sh includes maven jar files generation.<br>
otherwise:<br>
`mvn clean install -Dmaven.test.skip=true`<br>
`docker-compose up`

needed properties to run without docker:

`spring.datasource.username={username}
spring.datasource.password={password}
spring.datasource.url=jdbc:mysql://localhost:3306/{databaseName}?serverTimezone=Europe/Warsaw
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`

# Architecture

worker rest 
postgresql db

--------------------------------
# Authentication!

no security included

--------------------------------------
# Requirements

- docker, docker-compose
- maven
--------------------------
# Usage
POST to `host:8080/worker`<br>
with json body (required) (as example):<br>
`{`<br>
`"name":"John Smith",`<br>
`"salary":2000,`<br>
`"employmentDate":"05-03-2017",` <br>
`}`<br>

POST to `host:8080/team`<br>
with json body (required) (as example):<br>
`{`<br>
`"name":"Human Resources",`<br>
`}`<br>

GET to `host:8080/team` or `host:8080/worker` shows list of written records

GET to `host:8080/team/{id}` or `host:8080/worker/{id}` shows single record with the given id

POST to `host:8080/team/{id}` or `host:8080/worker/{id}` with required body edits single record with the given id

DELETE to `host:8080/team/{id}` or `host:8080/worker/{id}` deletes single record with the given id

GET to `host:8080/team/worker/{id}` or `host:8080/worker/team/{id}` shows all worker's / team's teams/ members records according to the given id

GET to `host:8080/team/worker/{id}` shows all worker's / team's teams/ members records according to the given id

GET to `host:8080/team/worker/{teamId}/{workerId}` adds member to a team

DELETE to `host:8080/team/worker/{teamId}/{workerId}` removes member from a team (keeping the worker active)

------------------------------
#Tests

There are a few tests showing that I can do them, but due to a lack of time I couldn't make them all.

--------------------------

# Made by:

Mateusz N.