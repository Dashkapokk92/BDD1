package datagenerator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lombok.Value;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;

public class DataGen {
    private DataGen() {
    }

    @Value
    public static class UserAuth {
        String login;
        String password;
        String verificationCode;
    }

    @Value
    public static class Card {
        String cardId;
        String secretCardId;
    }

    public static UserAuth getUserHardCode() {
        return new UserAuth("vasya", "qwerty123", "12345");
    }

    public static Card getFirstCard() {
        return new Card("5559 0000 0000 0001", "**** **** **** 0001");
    }

    public static Card getSecondCard() {
        return new Card("5559 0000 0000 0002", "**** **** **** 0002");
    }
}
