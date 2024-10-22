package pages;

import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.Text;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
                            userEmailInput = $("#userEmail"),
                            currentAddressArea = $("#currentAddress"),
                            permanentAddressArea = $("#permanentAddress"),
                            sbmBtn = $("#submit");

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmailInput(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddressArea(String address) {
        currentAddressArea.setValue(address);

        return this;
    }

    public TextBoxPage setPermanentAddressArea(String PermanentAddress) {
        permanentAddressArea.setValue(PermanentAddress);

        return this;
    }
    public TextBoxPage openTextPoxPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage sbmBtnClick() {
        sbmBtn.click();

        return this;
    }

    public TextBoxPage checkOutput(String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
