FROM openjdk:17-alpine
EXPOSE 8080
ADD /target/study-0.0.1-SNAPSHOT.jar study.jar
ENTRYPOINT ["java", "-jar", "study.jar"]