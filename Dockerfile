
FROM java:8
MAINTAINER Nagaraju Ravula
WORKDIR /
ADD ~/repo/target/StudentManagementApplication-0.0.1-SNAPSHOT.war StudentManagementApplication-0.0.1-SNAPSHOT.war
EXPOSE 8081
CMD ["java", "-jar", "StudentManagementApplication-0.0.1-SNAPSHOT.war"]



