FROM openjdk:11
COPY target/YouBookingBackend-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar","YouBookingBackend-0.0.1-SNAPSHOT.jar"]