# Automation

## Getting Started


This project is a Maven project, using Junit and using page object pattern for Selenium tests. 


Contained within the project is a HelloWorldTest. This should give you some insight into how we would like your tests to be structured. It will be beneficial giving the test `helloWorldTest()` a run to ensure that everything is set-up and working within your local development environment.

* `automation-task/src/main/java/com/connect_group/pages/helloworld/SignUpPage.java` - PageObject for the Sign Up Page.
* `automation-task/src/main/java/com/connect_group/pages/helloworld/ReceiptPage.java` - PageObject for the Receipt Page.
* `automation-task/src/main/java/com/connect_group/tests/helloworld/HelloWorldTest.java` - Test class for the HelloWorldTest.
  Finance Calculator Automation – README
  📌 Overview

This project implements a test automation framework using Java, Selenium WebDriver, and JUnit to validate the functionality of the Land Rover Finance Calculator page.

The automation simulates real user interactions and verifies that the application behaves correctly through assertions and validations.

🔗 Application Under Test:
https://www.landrover.co.uk/offers-and-finance/finance-calculator.html

🧰 Technology Stack
Java – Programming language
Selenium WebDriver – Browser automation
JUnit – Test execution and assertions

🎯 Scope of Automation

This automation covers:

Page Navigation
   Launch browser and navigate to the finance calculator page
   Validate successful page load
Filtering Functionality
   Apply filters based on available criteria (e.g., budget, vehicle type)
   Verify that filtering updates results correctly
Model Selection
   Select a vehicle model from the filtered results
   Validate that the correct model is selected and displayed
Assertions & Validations
   Verify:
   Page elements are present and interactable
   Filters behave as expected
   Selected model details are accurate
   Finance values update correctly
