FROM maven:3.8.5-eclipse-temurin-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean -P Docker
RUN mvn --quiet -f /home/app/pom.xml package -P Docker


FROM openjdk:17
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8042
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]