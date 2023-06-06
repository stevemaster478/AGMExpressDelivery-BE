FROM yannoff/maven:3-openjdk-19 as maven-builder
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean install -P local -Denv=local -DskipTests package


FROM openjdk:21-ea-15-jdk
WORKDIR /app
COPY --from=maven-builder /app/target/AGMExpress-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
