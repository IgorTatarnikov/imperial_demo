FROM eclipse-temurin:17-jdk-alpine
VOLUME /imperial_demo
ADD target/*.jar imperial_demo.jar
ENTRYPOINT ["java", "-jar","/imperial_demo.jar"]
EXPOSE 8080