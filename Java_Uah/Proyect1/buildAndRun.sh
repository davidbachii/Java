#!/bin/sh
mvn clean package && docker build -t com.mycompany/Proyect1 .
docker rm -f Proyect1 || true && docker run -d -p 9080:9080 -p 9443:9443 --name Proyect1 com.mycompany/Proyect1