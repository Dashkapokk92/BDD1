package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
public class TransferPage {
    @FindBy(css = "input[type='text']")
    private SelenideElement amountField;
    @FindBy(css = "input[type='tel']")
    private SelenideElement fromField;
    @FindBy(css = "button[data-test-id='action-transfer']")
    private SelenideElement submitButton;

    public DashboardPage transferMoney(String amount, String id) {
        amountField.setValue(amount);
        fromField.setValue(id);
        submitButton.click();
        return page(DashboardPage.class);
    }
}
