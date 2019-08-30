FROM tomcat:9.0.22-jdk8-openjdk
MAINTAINER Nagaraju Ravula
COPY --from=build /target/StudentManagementApplication-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps

