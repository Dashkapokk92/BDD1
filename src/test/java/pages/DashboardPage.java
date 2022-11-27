package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import datagenerator.DataGen;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public TransferPage upToMoneyOnThisCard(String id) {
        val cssind = cards.findBy(Condition.text(id));
        cssind.$("button[data-test-id='action-deposit']").click();
        return page(TransferPage.class);
    }

    public int getCardBalance(String id) {
        val text = cards.findBy(Condition.text(id)).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
