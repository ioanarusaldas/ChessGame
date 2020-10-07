build: Main.java
	javac Main.java
run:
	xboard -fcp "java Main" -debug
clean:
	rm -f *.class
