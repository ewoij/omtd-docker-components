FROM alpine

# python 3.6
RUN apk add --no-cache python3

# java
RUN apk add --no-cache openjdk8

# bash
RUN apk add --no-cache bash

# copy scripts
ADD docker/usr/local/sbin/* /usr/local/sbin/
ADD target/*-standalone.jar /usr/local/
