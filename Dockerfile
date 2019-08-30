
FROM tomcat:8.0.20-jre8
MAINTAINER Nagaraju Ravula
COPY /target/StudentManagementApplication-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ 