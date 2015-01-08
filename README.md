# microservices-rabbitmq-example

Project to demonstrate how two microservice apps (in this case they are both spring boot) can communicate via rabbitmq.

### Pre-requisite
Rabbitmq server installed and running on default port with default credentials

### To run
```
./gradlew accounts:bootRun
./gradlew authorization:bootRun
curl -X GET http://localhost:8081/accounts
```
