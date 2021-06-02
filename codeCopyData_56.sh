#!/bin/sh
echo "Copy data"
# copy a data
PATH_SUBMIT=C:\\Users\\Dell\\Desktop\\data\\oasis-data\\judging\\submissions;
PATH_DATA_TEST=C:\\Users\\Dell\\Desktop\\APR_test\\data_test;
PATH_TEST_CASE=C:\\Users\\Dell\\Desktop\\data\\oasis-data\\judging\\testcases;
PATH_LIB=C:\\Users\\Dell\\Desktop\\data\\lib;
for var in "$@"
do
echo "===========$var==========="
echo "[1] copy source"
cp  -R "$PATH_SUBMIT\\compressed\\$var" "$PATH_DATA_TEST"
echo "[2] unzip"
find "$PATH_DATA_TEST\\$var" -name '*.zip' -exec unzip -j -d "$PATH_DATA_TEST\\$var" {} \;
# find "$PATH_DATE_TEST\\$var"\. -name '*.zip' -exec unzip -j {} \;
# unzip -j C:\\Users\\Dell\\Desktop\\APR_test\\data_test\\"$var"\\*.zip -d C:\\Users\\Dell\\Desktop\\APR_test\\data_test\\"$var"
echo "[3] copy MyTest"
cp "$PATH_TEST_CASE\\56\\junittest\\MyTest.java" "$PATH_DATA_TEST\\$var"\\MyTest.java
find "$PATH_LIB" -name '*.jar' -exec cp {}  "$PATH_DATA_TEST\\$var" \;
# cp  -R C:\\Users\\Dell\\Desktop\\data\\lib\\*.jar C:\\Users\\Dell\\Desktop\\APR_test\\data_test\\"$var"
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
cd "$PATH_DATA_TEST\\$var"
javac -cp "junit-4.12.jar;oasis-junit-1.0.jar;hamcrest-core-1.3.jar;." *.java
java -cp  "junit-4.12.jar;oasis-junit-1.0.jar;hamcrest-core-1.3.jar;." MyTest
done
