FROM maven:3.8.5-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean -P Docker
RUN mvn --quiet -f /home/app/pom.xml package -P Docker


FROM openjdk:11
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8072
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]