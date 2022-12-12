
# For Java 11,
FROM adoptopenjdk/openjdk11:alpine-jre
LABEL MAINTAINER="andrearru@hotmail.com"

COPY --chown=1001:0 target/*.jar /application/

WORKDIR /application
USER 1001
ENTRYPOINT ["java","-jar","user-management.jar"]