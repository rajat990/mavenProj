FROM ubuntu:latest
RUN apt-get update
CMD Hello World!
ENTRYPOINT echo "Hello World!"
