#!/usr/bin/bash

container=$1

if [ ! $container ];then
   echo "Usage: run-it.sh <container>"
   echo " cli - docker exec -it <container> /usr/bin/bash"
   echo ""
   echo "$ docker container ls"
   docker container ls
   exit 0
fi

docker exec -it $container bash

