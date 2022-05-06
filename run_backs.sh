#!/bin/bash

compile_server=$(javac -cp "lib/*" -encoding utf8 src/back/*.java src/back/conjugaison/*.java src/back/conjugaison/utils/*.java src/back/conjugaison/cor/*.java src/back/conjugaison/conjugations/*.java src/back/conjugaison/conjugate/*.java src/back/conjugaison/conjugate/groups/*.java src/back/conjugaison/conjugate/groups/_3rdgroup/*.java src/back/conjugaison/conjugate/groups/_3rdgroup/auxiliaries/*.java -d backCompiled)
if [ -n $compile_server]
then
    java -cp "lib/*:backCompiled" back.StartServer
else
    echo "Failed to compile server"
fi
