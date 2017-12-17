#!/bin/bash

curl -sSL http://git.oschina.net/sauler/shell/raw/master/tomcat/tomcat8-download.sh | bash -s ${TOMCAT_MAJOR_VERSION}

tar zxf apache-tomcat-*.tar.gz
