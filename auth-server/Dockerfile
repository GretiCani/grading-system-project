FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} auth-server.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","auth-server.jar"]
