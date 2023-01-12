#!/bin/sh

MVN_VERSION=3.8.0
MVN_URL=https://downloads.apache.org/maven/maven-3/$MVN_VERSION/binaries/apache-maven-$MVN_VERSION-bin.tar.gz

echo "Downloading Maven $MVN_VERSION"
curl -s $MVN_URL | tar -xz

echo "Running Maven command: $@"
./apache-maven-$MVN_VERSION/bin/mvn "$@"



