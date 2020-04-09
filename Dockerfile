From tomcat:9.0.7-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY /target/PruebaSpring-AuthenticationAuthoritation-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]