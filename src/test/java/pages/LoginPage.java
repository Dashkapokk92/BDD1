package pages;

import datagenerator.DataGen;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(css = "input[name='login']")
    private SelenideElement loginField;
    @FindBy(css = "input[name='password'] ")
    private SelenideElement passwordField;
    @FindBy(css = "button[data-test-id='action-login']")
    private SelenideElement buttonLogin;

    public VerificationPage validLogin(DataGen.UserAuth info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        buttonLogin.click();
        return page(VerificationPage.class);
    }
}
