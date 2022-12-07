FROM adoptopenjdk/openjdk11:alpine-jre
LABEL author="andrearru@hotmail.it"
LABEL desc = "this is user management docker"
WORKDIR /usermanagement
COPY target/*.jar /usermanagement/usermanagement.jar
ENTRYPOINT ["java","-jar","usermanagement.jar"]