FROM maven:3.8.4 as build

COPY pom.xml /app/pom.xml
COPY src/ /app/src
COPY mvnw /app/mvnw

WORKDIR app

RUN mvn clean install

FROM tomcat:9-jdk11-corretto as installer

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/testeTecnico-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
