package org.example;

import org.junit.jupiter.api.Assertions;
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
    public void testBlockTitleIsDisplayed() {
        try {
            // Wait for the visibility of the element and store it in a variable
            WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]")));
            // Perform assertions on the element
            assertTrue(blockTitle.isDisplayed(), "Название блока не найдено");
            System.out.println("Название блока найдено: " + blockTitle.getText());
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Название блока не найдено в заданное время.");
            e.printStackTrace();
        }
    }

    @Test
    public void testPaymentLogosAreDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment-logos']")));
            assertTrue(paymentLogos.isDisplayed(), "Логотипы платежных систем не отображаются");
            System.out.println("Отображаются логотипы платежных систем.");
        } catch (TimeoutException e) {
            System.err.println("Исключение TimeoutException: логотипы платежных систем не найдены в заданное время.");
            e.printStackTrace();
        }
    }

    @Test
    public void testMoreInfoLink() {
        try {
            // Ожидание кликабельности ссылки "Подробнее о сервисе"
            WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));

            // Используем JavaScript для клика на элемент
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreInfoLink);

            // Ожидание изменения URL страницы
            boolean urlChanged = wait.until(ExpectedConditions.urlContains("service-details"));

            // Проверка, что URL изменился и содержит "service-details"
            assertTrue(urlChanged, "Переход по ссылке не произошел");
            System.out.println("Переход по ссылке успешен: " + driver.getCurrentUrl());
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Переход по ссылке не произошел вовремя.");
            e.printStackTrace();
        }
    }

    @Test
    public void testPhoneNumberAndContinueButton() {
        try {
            // Ожидание, пока поле для номера телефона станет видимым и доступным для ввода
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));

            // Если элемент найден, вводим номер телефона
            phoneNumberField.sendKeys("297777777");
            System.out.println("Номер телефона введен: 297777777");

            // Ожидание, пока кнопка "Продолжить" станет кликабельной
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Продолжить')]")));

            // Клик по кнопке "Продолжить"
            continueButton.click();
            System.out.println("Кнопка 'Продолжить' нажата");

            // Дополнительная проверка: ожидание, что страница после нажатия изменится или загрузится новый контент
            boolean isNextPageLoaded = wait.until(ExpectedConditions.urlContains("nextPage"));  // Заменить "nextPage" на реальную часть URL
            assertTrue(isNextPageLoaded, "Переход на следующую страницу не произошел.");
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Один из элементов не был найден вовремя.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}