# DistributedSystem1
Distributed Systems project part 1 (grpc)
G00349377 Distributed systems project 2019
API: https://app.swaggerhub.com/apis/jakecw97/DistSystemsPro/1.0.0
References:
https://www.dropwizard.io/en/stable/getting-started.html
https://learnonline.gmit.ie/course/view.php?id=614
https://www.youtube.com/watch?v=UonVxuAOznc

How to run:
1.Downlaod the jars to desired location
2.Open two command prompts
3.In both, navigate to the directory containing the jar files.
4.In the first CMD run the code: java -jar grpcPassService.jar
5. Wait a coupld of moments for server to launch
6. In the second CMD run the code: java -jar userApp.jar server userApiServiceConfig.yml
---ALTERNATIVE---
1.Open the project file in your Jave IDE of choice
2.Setup adn run grpcServer.java as a java application
3.Wait for server to launch
4.Setup and run UserApiServiceApp.java as a java application, make sure to add: " server userApiServiceConfig.yml " to the program arguments
---Running---
Once the app is running launch postman and begin testing on localhost:9000

---Known Issues---
Signup post method returns an error
JAR file for part 2 does not function as intended.
