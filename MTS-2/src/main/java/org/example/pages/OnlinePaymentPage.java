package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinePaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы элементов
    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]");
    private By paymentOptions = By.cssSelector(".payment-option");
    private By communicationServicesOption = By.xpath("//span[contains(text(), 'Услуги связи')]");
    private By phoneNumberField = By.id("phone_number");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By paymentLogos = By.className("payment-logos");
    private By emptyFields = By.cssSelector("input[placeholder]");

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для проверки видимости заголовка блока
    public void checkBlockTitleIsDisplayed() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        assertTrue(title.isDisplayed(), "Название блока не найдено");
        System.out.println("Название блока найдено: " + title.getText());
    }

    // Метод для проверки наличия логотипов платежных систем
    public void checkPaymentLogosAreDisplayed() {
        WebElement logos = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentLogos));
        assertTrue(logos.isDisplayed(), "Логотипы платежных систем не отображаются");
        System.out.println("Логотипы платежных систем отображаются");
    }

    // Метод для проверки надписей в незаполненных полях
    public void checkEmptyFieldLabels() {
        List<WebElement> emptyFieldElements = driver.findElements(emptyFields);
        for (WebElement field : emptyFieldElements) {
            System.out.println("Надпись в незаполненном поле: " + field.getAttribute("placeholder"));
            assertTrue(!field.getAttribute("placeholder").isEmpty(), "Надпись в незаполненном поле отсутствует");
        }
    }

    // Метод для выбора варианта "Услуги связи"
    public void selectCommunicationServicesOption() {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOption));
        option.click();
    }

    // Метод для ввода номера телефона
    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField));
        phoneField.sendKeys(phoneNumber);
    }

    // Метод для нажатия кнопки "Продолжить"
    public void clickContinueButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();
    }
}
