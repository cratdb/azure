make:
	javac -cp ./lib/azure-storage-8.4.0.jar *.java
run:
	java -cp ".:lib/*" Producer queue.ini 250
