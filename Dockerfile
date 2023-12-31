#
# Build stage
#
FROM maven:3.9.4-eclipse-temurin AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:22
COPY --from=build /target/access-viewer-java-0.0.1-SNAPSHOT.jar access-viewer-java.jar
# ENV PORT=3000
EXPOSE 3000
ENTRYPOINT ["java","-jar","access-viewer-java.jar"]