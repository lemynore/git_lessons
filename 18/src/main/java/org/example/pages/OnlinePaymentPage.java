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
    private By communicationServicesOption = By.xpath("//span[contains(text(), 'Услуги связи')]");
    private By phoneNumberField = By.id("phone_number");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");

    // Локаторы для проверки в тестах
    private By communicationServiceField = By.id("communication_service");
    private By homeInternetField = By.id("home_internet");
    private By installmentPlanField = By.id("installment_plan");
    private By debtField = By.id("debt");

    private By amountField = By.id("amount");
    private By displayedPhoneNumber = By.id("displayed_phone_number");
    private By cardNumberField = By.id("card_number");
    private By cardExpiryField = By.id("card_expiry");
    private By cardCvcField = By.id("card_cvc");
    private By paymentIcons = By.className("payment-icons");



    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCommunicationServicePlaceholder() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(communicationServiceField));
        return field.getAttribute("placeholder");
    }
    public String getHomeInternetPlaceholder() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(homeInternetField));
        return field.getAttribute("placeholder");
    }
    public String getInstallmentPlanPlaceholder() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(installmentPlanField));
        return field.getAttribute("placeholder");
    }

    public String getDebtPlaceholder() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(debtField));
        return field.getAttribute("placeholder");
    }



    public void selectCommunicationServicesOption() {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOption));
        option.click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField));
        phoneField.sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();
    }



    public void verifyPaymentDetails() {
        WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        assertTrue(amount.getText().contains("сумма"), "Сумма не отображается корректно");

        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(displayedPhoneNumber));
        assertTrue(phone.getText().contains("297777777"), "Номер телефона не отображается корректно");

        WebElement cardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField));
        assertTrue(cardNumber.getAttribute("placeholder").contains("Введите номер карты"), "Поле 'Номер карты' не содержит корректную надпись");

        WebElement cardExpiry = wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryField));
        assertTrue(cardExpiry.getAttribute("placeholder").contains("Введите срок действия карты"), "Поле 'Срок действия карты' не содержит корректную надпись");

        WebElement cardCvc = wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcField));
        assertTrue(cardCvc.getAttribute("placeholder").contains("Введите CVC-код"), "Поле 'CVC-код' не содержит корректную надпись");

        WebElement icons = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIcons));
        assertTrue(icons.isDisplayed(), "Иконки платежных систем не отображаются");
    }
}
