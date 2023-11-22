@echo off
call mvn clean package
call docker build -t com.mycompany/Proyect1 .
call docker rm -f Proyect1
call docker run -d -p 9080:9080 -p 9443:9443 --name Proyect1 com.mycompany/Proyect1