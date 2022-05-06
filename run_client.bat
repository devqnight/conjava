echo compiling client
javac -cp "lib/flatlaf-2.0.2.jar" -encoding utf8 src/front/*.java src/front/utils/*.java src/front/conjugation/*.java src/front/connection/*.java src/front/window/*.java -d frontCompiled

echo launching client
start java -cp "lib/*;frontCompiled" front.StartClient