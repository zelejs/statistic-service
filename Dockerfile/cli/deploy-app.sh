#!/bin/sh
## default binding port for statistic
## 3264

cli=$(readlink -f $0)
cli=${cli%/*}
cli=${cli%/*}

appdir=$cli/app-openjre8

## clone app-openjre8
if [ ! -d $appdir ];then
   git clone jfeat@112.74.26.228:/home/jfeat/git/dockerfile/app-openjre8.git
fi

## build image first
cd $appdir

bash cli/docker-build.sh


