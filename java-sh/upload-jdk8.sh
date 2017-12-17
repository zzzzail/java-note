#!/bin/bash

echo "上传文件中......"

scp -r ./jdk-8u144-linux-x64.tar.gz zail@47.94.229.49:/home/zail

echo "上传完成"
say "upload success!"