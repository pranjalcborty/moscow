FROM gradle as builder
COPY app/src /usr/app/src
COPY app/build.gradle /usr/app
WORKDIR /usr/app
RUN gradle clean build

FROM openjdk:17-alpine
COPY --from=builder /usr/app/build/libs/app.jar /usr/app/app.jar
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]

#FROM openjdk:latest
#VOLUME /tmp
#COPY app/build/libs/app.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]