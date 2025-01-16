Visit Selenium Test Automation
This project is an automation testing solution for the "Visit" website using Selenium WebDriver and Java. The main goal of the tests is to simulate user interactions on the website, such as selecting a date, searching for accommodations, and booking the first available option.


Project Structure:

VisitPageLocators.java: Contains the CSS selectors and locators used for locating elements on the website.

VisitPage.java: Contains methods that represent actions the user can perform on the website, such as opening the page, selecting a date, clicking the search button, and booking the first available accommodation.

VisitSeleniumTest.java: The main test class where the test scenario is executed, including calling the methods from the VisitPage class.

Requirements:


Java 11 or higher

Selenium WebDriver

ChromeDriver (or other WebDriver depending on the browser of your choice)

Maven (optional for dependency management)



Running the Tests


To execute the tests, simply run the VisitSeleniumTest class. The test will:



Open the Visit website.

Select the date for the next day.

Perform a search for accommodations.

Book the first available accommodation.




Features:

Open page: Opens the accommodation page of the "Visit" website.

Select date: Selects tomorrow's date from the date picker.

Search for accommodations: Clicks on the "Search" button to perform a search for available accommodations.

Book first available accommodation: Clicks on the "Book now" button for the first accommodation in the list.


