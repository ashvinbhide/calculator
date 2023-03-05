# Getting Started

To run the project download source code and open in any IDE of your preference.
It's a spring boot gradle project

copy application.properties and logback.xml file to the same folder where jar is copied.

To run as jar:
java -jar -Dlogging.config=logback.xml calculator-0.0.1-SNAPSHOT.jar


To pass input file and output file name , pass as command line argument or provide the paths in application.properties.

command line params will take preference over application.properties
