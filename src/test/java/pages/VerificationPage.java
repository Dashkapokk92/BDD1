package pages;


import datagenerator.DataGen;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {
    @FindBy(css = "input[name='code']")
    private SelenideElement codeField;
    @FindBy(css = "button[data-test-id='action-verify']")
    private SelenideElement buttonSubmitCode;

    public VerificationPage() {
        //codeField.shouldBe(visible, Duration.ofSeconds(20));
    }

    public DashboardPage validVerify(DataGen.UserAuth user) {
        codeField.setValue(user.getVerificationCode());
        buttonSubmitCode.click();
        return page(DashboardPage.class);
    }
}
