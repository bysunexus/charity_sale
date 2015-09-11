FROM ubuntu:12.04

MAINTAINER kakotor@gmail.com

# install java
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV TOMCAT_VERSION 8.0.26

# download install tomcat
RUN wget --quiet --no-cookies http://archive.apache.org/dist/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -O /tmp/catalina.tar.gz
RUN tar xzf /tmp/catalina.tar.gz -C /opt
RUN mv /opt/apache-tomcat-${TOMCAT_VERSION} /opt/tomcat
RUN rm /tmp/catalina.tar.gz
RUN rm -rf /opt/tomcat/webapps/*

ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin

RUN apt-get update
RUN apt-get install -y maven

RUN ["mvn", "package -Ptest -Dmaven.test.skip=true -DskipTests=true"]

RUN cp target/charity_sale.war /opt/tomcat/webapps/ROOT.war
RUN rm -rf target

EXPOSE 8080
CMD ["bash"]
CMD ["/opt/tomcat/bin/catalina.sh", "run"]