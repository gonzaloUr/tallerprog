#!/bin/sh
gradle :core:build
cp core/build/libs/core.jar tarea2/src/main/webapp/WEB-INF/lib
