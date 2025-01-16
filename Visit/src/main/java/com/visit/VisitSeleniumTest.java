package com.visit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisitSeleniumTest {
    public static void main(String[] args) {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "/usr/local/Caskroom/chromedriver/128.0.6613.119/chromedriver-mac-x64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            VisitPage visitPage = new VisitPage(driver);

            // Test scenario
            visitPage.openPage();
            visitPage.selectDate();
            visitPage.clickSearch();
            visitPage.bookFirstVisit();

            System.out.println("Test executed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
