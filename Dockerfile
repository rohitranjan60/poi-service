FROM maven:3.6-openjdk-8 AS build  
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
ARG VERSION
RUN mkdir -p /poi-service
COPY --from=build /usr/src/app/target/poi-service-${VERSION}.jar /poi-service/app.jar

ENTRYPOINT ["java","-jar","/poi-service/app.jar"]