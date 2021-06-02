#!/bin/sh
echo "Copy data"
# copy a data
for var in "$@"
do
echo "===========$var==========="
echo "[1] copy source"
cp  -R ../data/oasis-data/judging/submissions/compressed/"$var" data_test
echo "[2] unzip"
unzip -j data_test/"$var"/*.zip -d data_test/"$var"
echo "[3] copy MyTest"
cp ../data/oasis-data/judging/testcases/57/junittest/MyTest.java data_test/"$var"/MyTest.java
cp  -R ../data/lib/*.jar data_test/"$var"
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
cd data_test/"$var"
javac -cp "junit-4.12.jar; hamcrest-core-1.3.jar;." *.java
java -cp  "junit-4.12.jar; hamcrest-core-1.3.jar;." MyTest
cd ../..
done