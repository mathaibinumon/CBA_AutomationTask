# Code Challenge

### WEB Automation

##Run Instructions
1) Project is created as Maven Project, Selenium 3.12.0, TestNG 6.14.2
2) Run the project as TestNG Suite using suite.xml 
3) Chrome Browser should be updated to v 91 or later

##config.properties
1)Project is configured to run with chrome driver only 
2)Default timeout is given as 20 seconds (configurable)

##Input file path
/src/test/resources/testdata_provider.xlsx 

##Report file path
/test-output/ExtentReports/SmokeTest_AutomationReport.html

##known issues

1) Selenium should not be run as administrator, to avoid chrome driver crash with latest update

