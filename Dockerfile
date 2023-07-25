FROM jenkins/jenkins:lts-jdk17
USER jenkins
RUN apt-get update
RUN curl -sSL https://get.docker.com/ | sh

# AS <NAME> to name this stage as maven
FROM maven:3.9.3 AS maven
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
EXPOSE 8010
EXPOSE 3306
WORKDIR /usr/src/app
COPY . /usr/src/app



# Compile and package the application to an executable JAR
RUN mvn clean package -X -DskipTests
RUN echo "running in root"
RUN ls 
RUN echo "running in /usr/src/app"
RUN ls /usr/src/app 
RUN echo "running in /usr/src/app/target"
RUN ls /usr/src/app/target

# For Java 17, 
FROM openjdk:17-alpine
ARG JAR_FILE=MS_ACCESOS-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
# Copy the foodbox-service-rest-0.0.1-SNAPSHOT.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java", "-jar", "MS_ACCESOS"]
