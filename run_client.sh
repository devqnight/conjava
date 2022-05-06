compile_shop=$(javac -cp "lib/flatlaf-2.0.2.jar" -encoding utf8 src/front/*.java src/front/utils/*.java src/front/conjugation/*.java src/front/connection/*.java src/front/window/*.java -d frontCompiled)
if [ -n $compile_shop]
then
    start_client=$(java -cp "lib/*:frontCompiled" front.StartClient)
    if [ ! -n $start_client ]
    then
        echo "Failed to connect to shop"
    fi
else
    echo "Failed to compile client"
fi
