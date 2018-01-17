# Ubuntu base image
FROM ubuntu
MAINTAINER Arjun Sahasranam

#copy oracle jdk
COPY /jdk1.8.0_131 /home/jdk1.8.0_131

# set path
ENV JAVA_HOME /home/jdk1.8.0_131

ENV PATH $PATH:$JAVA_HOME/bin

ENV PROFILE $PROFILE

RUN mkdir cp-user-service

COPY cp-user-service/target/cp-user-service.jar cp-user-service/

ADD cp-user-service/start.sh /home/

RUN chmod +x /home/start.sh

EXPOSE 8090

CMD ["sh", "-c", "/home/start.sh -Dspring.profiles.active=$PROFILE cp-user-service/cp-user-service.jar"]

