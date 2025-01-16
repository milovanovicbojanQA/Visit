package com.visit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.LocalDate;
import java.util.List;

public class VisitPage {
    private WebDriver driver;

    public VisitPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www2.destinationgotland.se/en/accommodation");
    }

    public void selectDate() {
        // Klikni na polje za datum da bi otvorio padajući meni
        WebElement datePicker = driver.findElement(By.cssSelector(VisitPageLocators.DATE_PICKER));
        datePicker.click();

        // Izračunaj sutrašnji dan u mesecu
        int tomorrowDay = LocalDate.now().plusDays(1).getDayOfMonth();

        // Pronađi datum sa odgovarajućim brojem dana
        WebElement tomorrowOption = driver.findElement(By.xpath("//a[text()='" + tomorrowDay + "']"));

        // Klikni na sutrašnji datum
        tomorrowOption.click();
    }

    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.cssSelector(VisitPageLocators.SEARCH_BUTTON));

        // Skroluj do dugmeta 'Search' koristeći JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);

        // Klikni na dugme 'Search'
        searchButton.click();
    }

    public void bookFirstVisit() {
        // Inicijalizuj WebDriverWait sa maksimalnim vremenom čekanja od 10 sekundi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Pronađi sve dugmadi sa istim selektorom
        List<WebElement> bookButtons = driver.findElements(By.cssSelector(VisitPageLocators.BOOK_BUTTONS));

        // Proveri da li postoji barem jedno dugme
        if (!bookButtons.isEmpty()) {
            WebElement firstButton = bookButtons.get(0);

            // Čekaj dok dugme ne postane klikabilno (ili dok ne istekne maksimalno vreme
            // čekanja)
            wait.until(ExpectedConditions.elementToBeClickable(firstButton));

            // Klikni na prvo dugme
            firstButton.click();
        } else {
            System.out.println("Nema dostupnih dugmadi za bukiranje.");
        }
    }
}
