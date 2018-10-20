#!/usr/bin/env bash

if [[ ! ${WEBAPPS_DIR} ]];then
   echo "WEBAPPS_DIR environment must be set before start docker image"
   exit 
fi

if [[ ! -d ${WEBAPPS_DIR} ]];then
   echo "$WEBAPPS_DIR not exists. Pls. make it before start docker image"
   exit
fi

binding=$1

if [ ! $binding ];then
  echo "Usage: cli <binding-port>"
  exit
fi


## run image
docker run -v ${WEBAPPS_DIR}:/webapps  -p $binding:8080 -it -d stat/openjre8

