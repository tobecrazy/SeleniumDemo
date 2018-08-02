FROM tobecrazy/ubuntu-young:latest
MAINTAINER Young <dbyl@dbyl.cn>

# Configure the main working directory
ENV APP_HOME /opt/tomcat8
WORKDIR $APP_HOME
RUN echo $APP_HOME
RUN /bin/rm -f /etc/localtime
RUN /bin/ln -s /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
EXPOSE 8080
CMD /etc/init.d/tomcat8 run
CMD tail -f $APP_HOME/logs/catalina.out
