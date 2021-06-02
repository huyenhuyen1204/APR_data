#!/bin/sh
echo "Copy data"
# copy a data
for var in "$@"
do
cp  -R ../data/oasis-data/judging/submissions/compressed/"$var" data_test
unzip data_test/"$var"/*.zip -d data_test/"$var"
cp ../data/oasis-data/judging/testcases/56/junittest/MyTest.java data_test/"$var"/MyTest.java
cp  -R ../data/lib/*.jar data_test/"$var"
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
cd data_test/"$var"
javac -cp "junit-4.12.jar;oasis-junit-1.0.jar;hamcrest-core-1.3.jar;." *.java

 MyTest
pwd
cd ../..
done