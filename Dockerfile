FROM java:11
EXPOSE 8080
ADD /target/cymapp.jar cymapp.jar
ENTRYPOINT ["java", "-jar", "cymapp.jar"]