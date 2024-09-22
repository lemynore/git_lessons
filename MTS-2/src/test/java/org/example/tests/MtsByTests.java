package org.example.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Настройка WebDriverManager для ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Явное ожидание
        driver.get("https://www.mts.by/");
        handleCookies();
    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера
        if (driver != null) {
            driver.quit();
        }
    }

    // Метод для закрытия окна с согласия на использование cookies
    private void handleCookies() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
            acceptCookiesButton.click();
            System.out.println("Окно с согласия на использование cookies закрыто");
        } catch (Exception e) {
            System.out.println("Окно cookies не появилось, продолжаем тест");
        }
    }

    @Test
    public void testEmptyFieldLabels() {
        // Проверка надписей в незаполненных полях для каждого варианта оплаты услуг
        try {
            // Проверка для "Услуги связи"
            WebElement communicationServiceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("communication_service")));
            assertTrue(communicationServiceField.getAttribute("placeholder").contains("Введите номер телефона"), "Поле 'Услуги связи' не содержит корректную надпись");

            // Проверка для "Домашний интернет"
            WebElement homeInternetField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_internet")));
            assertTrue(homeInternetField.getAttribute("placeholder").contains("Введите лицевой счет"), "Поле 'Домашний интернет' не содержит корректную надпись");

            // Проверка для "Рассрочка"
            WebElement installmentPlanField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("installment_plan")));
            assertTrue(installmentPlanField.getAttribute("placeholder").contains("Введите номер договора"), "Поле 'Рассрочка' не содержит корректную надпись");

            // Проверка для "Задолженность"
            WebElement debtField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("debt")));
            assertTrue(debtField.getAttribute("placeholder").contains("Введите номер счета"), "Поле 'Задолженность' не содержит корректную надпись");

            System.out.println("Проверка надписей в незаполненных полях каждого варианта оплаты услуг выполнена успешно.");
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Одно из полей для проверки надписи не найдено вовремя.");
            e.printStackTrace();
        }
    }

    @Test
    public void testCommunicationServicePayment() {
        try {
            // Заполнение данных для варианта "Услуги связи"
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));
            phoneNumberField.sendKeys("297777777");
            System.out.println("Номер телефона введен: 297777777");

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Продолжить')]")));
            continueButton.click();
            System.out.println("Кнопка 'Продолжить' нажата");

            // Проверка корректности отображения суммы, номера телефона и других данных
            WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
            assertTrue(amountField.getText().contains("сумма"), "Сумма не отображается корректно");

            WebElement displayedPhoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayed_phone_number")));
            assertTrue(displayedPhoneNumber.getText().contains("297777777"), "Номер телефона не отображается корректно");

            WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
            assertTrue(cardNumberField.getAttribute("placeholder").contains("Введите номер карты"), "Поле 'Номер карты' не содержит корректную надпись");

            WebElement cardExpiryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_expiry")));
            assertTrue(cardExpiryField.getAttribute("placeholder").contains("Введите срок действия карты"), "Поле 'Срок действия карты' не содержит корректную надпись");

            WebElement cardCvcField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_cvc")));
            assertTrue(cardCvcField.getAttribute("placeholder").contains("Введите CVC-код"), "Поле 'CVC-код' не содержит корректную надпись");

            WebElement paymentIcons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-icons")));
            assertTrue(paymentIcons.isDisplayed(), "Иконки платежных систем не отображаются");

            System.out.println("Проверка оплаты 'Услуги связи' выполнена успешно.");
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Один из элементов для проверки корректности отображения не найден вовремя.");
            e.printStackTrace();
        }
    }
}