#!/bin/bash

mysqldump -h127.0.0.1 -uroot -proot!@# t1 | gzip > mysql-backup.sql.gz
node ./upload-file

# mysqldump -h127.0.0.1 -uroot -pMyheart,,123!@# test | gzip > mysql-backup.sql.gz
