mysql-dump-import:
	mysql -u java-ee-final -pjava-ee-final --host=127.0.0.1 --port=8159 java-ee-final < resources/java-ee-final.sql
mysql-dump-export:
	mysqldump -u java-ee-final -pjava-ee-final java-ee-final --host=127.0.0.1 --port=8159 > resources/java-ee-final.sql
