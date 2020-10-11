##### How to build the application
1) Execute command:
mvn clean install
2) Wait till maven generates WordInFilesAnalyzer.jar in WordInFilesAnalyzer/target/ directory

##### How to use the application
To execute application use command below:

java -jar WordInFilesAnalyzer-1.0.jar <optional path>

To change keyword of target files extension you should modify application property file values and rebuild the application:

keyword.value=mama

file.extension=.txt

1) The firs possible option is to run application with path parameter

Example:
java -jar target/WordInFilesAnalyzer-1.0.jar C:/Users

2) You can run the application without parameter 

Example:
java -jar target/WordInFilesAnalyzer-1.0.jar

When you see the message "Please enter the target path:", the path should be entered:

Example:
C:/Users/tmp

##### Features
###### Input
1) analyze files in directory, including nested directories
- the path can be taken from argument/property/input stream
2) handle txt file only
- can be defined in properties
3) ability to find multiply words "mama"
- can be defined in properties

###### Output
1) total count of the keyword
2) count of files which contain the keyword
3) the list of entries [fileName] - [word count], including 0 counts