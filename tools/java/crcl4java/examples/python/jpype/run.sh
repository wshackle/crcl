#!/bin/sh

set -x;

export CRCL4JAVA_UTILS_JAR=`ls -1t crcl4java-utils*.jar ../../../crcl4java-utils/target/crcl4java-utils*with-dependencies.jar | head -n 1`;
if test "x${CRCL4JAVA_UTILS_JAR}" = "x" ; then 
    remotejarurl="https://raw.github.com/usnistgov/crcl/mvn-repo/com/github/wshackle/crcl4java-utils/1.4/crcl4java-utils-1.4-jar-with-dependencies.jar";
    echo "Downloading ${remotejarurl}";
    wget "${remotejarurl}"
    export CRCL4JAVA_UTILS_JAR=`ls -1t crcl4java-utils*.jar | head -n 1`
fi

if test "x${JAVA_HOME}" = "x" ; then
    echo "Please install Java and set JAVA_HOME environment variable to the installation dirctory"
    exit 1;
fi

if test "x${JVM_LIB}" = x ; then
    export JVM_LIB=`find "${JAVA_HOME}/" -name libjvm.so | grep -v jawt | head -n 1`;
fi

python crclclient.py

