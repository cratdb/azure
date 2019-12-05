make:
	javac -cp ./lib/azure-storage-8.4.0.jar *.java
run:
	java -cp ".:lib/*" Producer queue.ini 250o
kill:
	kill -9 $(ps -ef | awk '/[j]ava/ {print $2}')
