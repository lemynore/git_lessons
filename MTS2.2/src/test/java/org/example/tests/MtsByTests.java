package org.example.tests;

import org.example.pages.OnlinePaymentPage;
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
    private OnlinePaymentPage paymentPage;
    private OnlinePaymentPage onlinePaymentPage;


    @BeforeEach
    public void setUp() {
        // Настройка WebDriverManager для ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Явное ожидание
        driver.get("https://www.mts.by/");
        handleCookies();
        paymentPage = new OnlinePaymentPage(driver); // Инициализация Page Object
        onlinePaymentPage = new OnlinePaymentPage(driver);
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
        try {
            // Проверка надписей в незаполненных полях для каждого варианта оплаты услуг
            assertTrue(onlinePaymentPage.getCommunicationServicePlaceholder().contains("Введите номер телефона"), "Поле 'Услуги связи' не содержит корректную надпись");
            assertTrue(onlinePaymentPage.getHomeInternetPlaceholder().contains("Введите лицевой счет"), "Поле 'Домашний интернет' не содержит корректную надпись");
            assertTrue(onlinePaymentPage.getInstallmentPlanPlaceholder().contains("Введите номер договора"), "Поле 'Рассрочка' не содержит корректную надпись");
            assertTrue(onlinePaymentPage.getDebtPlaceholder().contains("Введите номер счета"), "Поле 'Задолженность' не содержит корректную надпись");

            System.out.println("Проверка надписей в незаполненных полях каждого варианта оплаты услуг выполнена успешно.");
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Одно из полей для проверки надписи не найдено вовремя.");
            e.printStackTrace();
        }
    }


    @Test
    public void testCommunicationServicePayment() {
        try {
            // Используем методы Page Object для взаимодействия с элементами страницы
            paymentPage.selectCommunicationServicesOption();
            paymentPage.enterPhoneNumber("297777777");
            System.out.println("Номер телефона введен: 297777777");

            paymentPage.clickContinueButton();
            System.out.println("Кнопка 'Продолжить' нажата");

            // Используем метод Page Object для проверки деталей оплаты
            paymentPage.verifyPaymentDetails();

            System.out.println("Проверка оплаты 'Услуги связи' выполнена успешно.");
        } catch (TimeoutException e) {
            System.err.println("TimeoutException: Один из элементов для проверки корректности отображения не найден вовремя.");
            e.printStackTrace();
        }
    }
}
