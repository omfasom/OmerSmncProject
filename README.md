
# UP42 Test Automation Framework README.md

**Prerequisites**

1) Access to Git repository
2) Java (jdk) : http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3) Maven : https://maven.apache.org/download.cgi
4) IntelliJ (or any other IDE) : https://www.jetbrains.com/idea/download/

**Installation Details of IntelliJ:**

1) IntelliJ installation Guide ( Windows) : https://www.youtube.com/watch?v=m2BYGocvows
2) IntelliJ installation Guide ( Mac) : https://www.youtube.com/watch?v=4ej49_eEOcM



**Steps to get the Test Automation Framework Template:**

1) Clone the project from https://github.com/omfasom/OmerSmncProject
2) Launch and open the project 'OmrSmncProject' in IntelliJ editor


**Install Lombok Plugin:**

1) Help > Find Action >Search for "Plugins"
2) Search for "lombok" in the plugins popup
3) Click search in repository(In case it is not listed)
4) Search and select "Lombok Plugin" in the results
5) Click Install and click accept in the popup
6) Click Restart IntelliJ and click OK


**Create maven run configuration:**

1) Click run -> Edit configuration
2) Create/add configuration
3) Name the configuration
4) Click apply and save it
5) Repeat above steps to create another maven configuration with command line as 'clean install site -DsuiteFile=api_regression.xml'

