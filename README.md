# sef18group15-decide
Assignment 1 for sef18 course made by Group 15

# Folder Structure

## Compiling

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


# Statement of Contributions

## Lucas Ljungbergs
1. Functions that check  LIC2, LIC5, LIC8, LIC11, LIC14 and corresponding tests.
2. First commit contating the code skeleton (base structure, including all five different class files in the src folder).
3. Assigned most of the tasks to other members of the group (by tagging them in the issues).
4. PUMcompute and FUVcompute functions.
5. Some compiling and running instructions in readme
## Sara Engelhardt
1. Functions that check  LIC1, LIC4, LIC7, LIC10, LIC13 and corresponding tests.
2. FUVcompute  & tests. 
## Olzhas Kadyrakunov
1. Functions that check LIC0, LIC3, LIC6, LIC9, LIC12 and corresponding tests.
2. Statment of contributions.
3. Folder and file structure.
4. Templates for LIC check and test functions.
5. PUMcompute  tests.
