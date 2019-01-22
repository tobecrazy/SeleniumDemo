FROM jenkins/jenkins:latest
MAINTAINER Young <dbyl@dbyl.cn>
USER root
RUN apt-get update && apt-get install -y maven
RUN apt-get install -y vim
RUN mkdir -p /opt/pip
RUN cd /opt/pip
RUN curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
RUN python get-pip.py
RUN pip install qrcode[pil]
USER jenkins
