# PoV

This is a test automation project done in Java, Selenium and TestNG is used as a framework and Mave as a building tool.
(list of libraries used is in the Maven pom.xml file)

Project Structure

DSL - domain specific language file with interfaces, methods and pages

Interfaces:
I have implemented custom functions used in tests:

Click - which first validates if the element is present before clicking on it
Exists - check if certain element exists (used to validate new pages in tests)
Read - validates if element exists + takes value from attribute
Write - checks if element exists + sends a value in the field

Methods:
All of the methods above have been implemented in the BaseMethods file. 

Pages:
Each page of the website has a separate class with it's locators + custom methods that are used in tests on those pages.

Essentials:
DriverFactory where driver is defined.
Testng file - Base tests file where driver star and teardown have been defined.

TestUtilitie - Added extent reports library for reports that are generated as an HTML file.

Tests:
Classes with tests with each test being in a seperate class. 

TestNG file has to be used to run tests. 

Steps to run a test:
1) Update the testng file with class path of the desired test.
2) Run the test via testng file.
3) HTML report of test run is generated in test-output file. 






