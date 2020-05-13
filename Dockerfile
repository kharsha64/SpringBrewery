FROM openjdk:11-jdk
VOLUME /tmp
ADD target/spring-brewery-0.0.1-SNAPSHOT.jar beerapp.jar
ENTRYPOINT ["java", "-jar", "/beerapp.jar"]