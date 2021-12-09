FROM openjdk:8-jdk-alpine


ADD target/*.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-cp","/app.jar", "net.kubepia.app.App"]