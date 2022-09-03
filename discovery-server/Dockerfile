FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} eureka-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","eureka-service.jar"]
#,"-Dspring.profiles.active=docker"