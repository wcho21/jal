# ubuntu with development packages
FROM ubuntu:24.10 AS dev-base

ARG DEBIAN_FRONTEND=noninteractive
ENV TZ=Etc/UTC
RUN apt-get update && apt-get --yes install git vim gnupg2 curl unzip && apt-get clean

# java runtime
FROM dev-base AS js-base

RUN apt-get update && apt-get --yes install openjdk-21-jdk maven && apt-get clean