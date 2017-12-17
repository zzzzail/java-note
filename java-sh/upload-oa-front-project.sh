#! /bin/bash

echo "upload oa-front project start......"

scp -rf ../changshou-oa-front/out/artifacts/changshou_oa_front_war_exploded zail@47.94.229.49:/java_project/apache-tomcat-8.5.23-oa-front/webapps

echo "upload success!"
say  "upload success!"