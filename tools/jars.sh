#!/bin/sh
mkdir -p 'tarea2/src/main/webapp/WEB-INF/lib'
wget 'https://repo1.maven.org/maven2/com/toedter/jcalendar/1.4/jcalendar-1.4.jar'
wget 'https://repo1.maven.org/maven2/org/mockito/mockito-core/3.12.4/mockito-core-3.12.4.jar'
wget 'https://repo1.maven.org/maven2/javax/servlet/jstl/1.2/jstl-1.2.jar' -P 'tarea2/src/main/webapp/WEB-INF/lib'
