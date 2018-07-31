FROM java:8
ADD target/spring-boot-rest-api-postgresql-0.0.1-SNAPSHOT.jar spring-boot-rest-api-postgresql-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-rest-api-postgresql-0.0.1-SNAPSHOT.jar"]
