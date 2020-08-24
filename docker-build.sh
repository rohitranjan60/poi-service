#!/bin/bash
set -ex

VERSION=`cat pom.xml | grep "<version>.*</version>" | head -1 |awk -F'[><]' '{print $3}'`
IMAGE_NAME="poi-service"
echo "Version : $VERSION"

#Run Docker Build
docker build \
    --build-arg VERSION=$VERSION \
    -t $IMAGE_NAME:$VERSION .
