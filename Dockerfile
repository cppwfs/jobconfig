FROM java:8
VOLUME /tmp
ADD target/myapp-1.0-SNAPSHOT.jar myapp.jar
ADD src/main/resources/bootstrap.yml bootstrap.yml
ADD cloud.properties cloud.properties
EXPOSE 8080
RUN bash -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Dspring.profiles.active=local","-Dspring.cloud.propertiesFile=cloud.properties","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]
