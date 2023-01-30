FROM openjdk:11
COPY target/YouBooking.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]