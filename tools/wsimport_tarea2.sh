#!/bin/sh

wsimport -classpath tarea1/bin/main/ -p com.entrenamosuy.web.publicar -d tarea2/src/main/java -Xnocompile -keep http://localhost:9128/webservices?wsdl