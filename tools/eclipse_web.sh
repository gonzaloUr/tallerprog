#!/bin/sh
gradle :core:build
mkdir -p tarea2/src/main/webapp/WEB-INF/lib
cp core/build/libs/core.jar tarea2/src/main/webapp/WEB-INF/lib
