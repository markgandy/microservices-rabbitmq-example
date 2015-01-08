# microservices-rabbitmq-example

Project to demonstrate how two microservice apps (in this case they are both spring boot) can communicate via rabbitmq using direct reply-to.

### Pre-requisite
Rabbitmq server installed and running on default port with default credentials

### To run
```
./gradlew accounts:bootRun
./gradlew authorization:bootRun
curl -X GET http://localhost:8081/accounts
```

### So what?
AMQP messaging is generally used for async event driven architecture (pub/sub).  As we move towards having lots of microservices that need to talk to each other that is generally a good approach.  But there is still the scenario where one microservice needs to get data from another, and wait for the response before doing something with that data.

This project shows how easy it is to use rabbitmq for more traditional request/response type flow that would normally be done over http.

### Why not just use http?
* rabbitmq is faster
* http requires service dsicovery and load balancing (but these are not required with message broker)
