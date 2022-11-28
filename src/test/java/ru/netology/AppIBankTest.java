package ru.netology;

import datagenerator.DataGen;
import pages.DashboardPage;
import pages.LoginPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppIBankTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldOpenTransferPage() {
        int amountToTransfer = 1000;
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authUser = DataGen.getUserHardCode();
        var verificationPge = loginPage.validLogin(authUser);
        var page = verificationPge.validVerify(authUser);
        int startValueCardOne = new DashboardPage().getCardBalance(DataGen.getFirstCard().getSecretCardId());
        int startValueCardTwo = new DashboardPage().getCardBalance(DataGen.getSecondCard().getSecretCardId());
        var moneyTransfer = page.upToMoneyOnThisCard(DataGen.getFirstCard().getSecretCardId());
        var enterAmount = moneyTransfer.transferMoney(String.valueOf(amountToTransfer), DataGen.getSecondCard().getCardId());
        $(withText("Ваши карты")).shouldBe(visible);
        int expectedCardOne = startValueCardOne + amountToTransfer;
        int expectedCardTwo = startValueCardTwo - amountToTransfer;
        assertEquals(expectedCardOne, new DashboardPage().getCardBalance(DataGen.getFirstCard().getSecretCardId()));
        assertEquals(expectedCardTwo, new DashboardPage().getCardBalance(DataGen.getSecondCard().getSecretCardId()));
    }

    @Test
    public void shouldGiveErrorWhenTransMoreThanAccountBalance() {
        int amountToTransfer = 10000;
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authUser = DataGen.getUserHardCode();
        var verificationPge = loginPage.validLogin(authUser);
        var page = verificationPge.validVerify(authUser);
        int startValueCardOne = new DashboardPage().getCardBalance(DataGen.getFirstCard().getSecretCardId());
        int startValueCardTwo = new DashboardPage().getCardBalance(DataGen.getSecondCard().getSecretCardId());
        var moneyTransfer = page.upToMoneyOnThisCard(DataGen.getFirstCard().getSecretCardId());
        var enterAmount = moneyTransfer.transferMoney(String.valueOf(amountToTransfer), DataGen.getSecondCard().getCardId());
        $(withText("Ваши карты")).shouldBe(visible);
        int expectedCardOne = startValueCardOne + amountToTransfer;
        int expectedCardTwo = startValueCardTwo - amountToTransfer;
        assertEquals(expectedCardOne, new DashboardPage().getCardBalance(DataGen.getFirstCard().getSecretCardId()));
        assertEquals(expectedCardTwo, new DashboardPage().getCardBalance(DataGen.getSecondCard().getSecretCardId()));
    }
}
