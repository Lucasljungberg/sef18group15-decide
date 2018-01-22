# sef18group15-decide
Assignment 1 for sef18 course made by Group 15

# Compiling

A bin folder should be created locally to hold all compiled code.

## Source code
To compile the code, do the following command:  
`javac src/*.java -d bin/`

To run the source code, do the following: 
`java -cp bin <main-file>` so for example `java -cp bin ABMSystem`

## Test code
To compile the tests:  
`javac test/unit/*.java -d bin -cp src`

To run a test:
`java -ea -cp bin <main-test-file>` so for example `java -ea -cp bin PointTest`
