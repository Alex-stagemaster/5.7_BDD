package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");


    public VerificationPage validLogin(DataHelper.AuthInfo Info) {
        loginField.setValue(Info.getLogin());
        passwordField.setValue(Info.getPassword());
        loginButton.click();
        Selenide.getFocusedElement().sendKeys(Keys.ENTER);

        return new VerificationPage();
    }

}