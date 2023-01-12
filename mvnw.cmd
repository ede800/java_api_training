@echo off

set MVN_VERSION=3.8.0
set MVN_URL=https://downloads.apache.org/maven/maven-3/%MVN_VERSION%/binaries/apache-maven-%MVN_VERSION%-bin.zip

echo Downloading Maven %MVN_VERSION%
bitsadmin.exe /transfer "maven_dl" %MVN_URL% %cd%\apache-maven-%MVN_VERSION%-bin.zip

echo Unpacking Maven %MVN_VERSION%
7z x -y apache-maven-%MVN_VERSION%-bin.zip

echo Running Maven command: %*
%cd%\apache-maven-%MVN_VERSION%\bin\mvn.cmd %*

