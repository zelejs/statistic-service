#!/usr/bin/env bash
## default binding port for statistic

APP_DOCKER_REPO='jfeat@112.74.26.228:/home/jfeat/git/dockerfile/app-openjre8.git'

## 8264  ############################
BINDING_PORT=8264                  ##
## ##################################

## docker name
DOCKER_NAME='app-stat'
## ## 

docker=$(which docker)
if [ ! $docker ];then
   echo "Not in docker environment."
   echo "Pls. try to send this script to the deployed server and run again"
   exit 
fi


cmd=$1

usage() {
    echo "Type -h --help for help"
    echo "Usage: cli run"
    echo "       cli test"
}
if [ "$cmd"x == "-h"x -o "$cmd"x == "--help"x ];then
    usage
    exit
fi

## for test
if [ $cmd ];then
   if [ "$cmd"x == "run"x -o "$cmd"x == "test"x ];then
      BINDING_PORT='' 
   else
      usage
      exit
   fi 
fi

cli=$(readlink -f $0)
cli=${cli%/*}
#cli=${cli%/*}

appdir=$cli/app-openjre8

## clone app-openjre8
if [ ! -d $appdir ];then
   cd $cli
   git clone $APP_DOCKER_REPO
else
   cd $appdir
   git pull origin master
fi

## build image first
cd $appdir

## build common used image for app
bash cli/docker-build.sh


## run app stat image
if [ ! $cmd ];then
   cmd='run'
fi 
echo "bash cli/docker-run.sh $cmd $DOCKER_NAME $BINDING_PORT"
bash cli/docker-run.sh $cmd $DOCKER_NAME $BINDING_PORT

