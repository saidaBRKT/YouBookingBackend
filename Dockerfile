FROM openjdk:11
WORKDIR app/
COPY target/YouBookingBackend-0.0.1-SNAPSHOT.jar app/
ENTRYPOINT ["java", "-jar","app/YouBookingBackend-0.0.1-SNAPSHOT.jar"]