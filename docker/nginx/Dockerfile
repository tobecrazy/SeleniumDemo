FROM latest
MAINTAINER Young <dbyl@dbyl.cn>

# Configure the main working directory
ENV APP_HOME /opt/tomcat8
WORKDIR $APP_HOME
RUN echo $APP_HOME
EXPOSE 8080
CMD /etc/init.d/tomcat8 run
