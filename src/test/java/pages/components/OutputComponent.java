package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OutputComponent {
    private final SelenideElement output = $("#output");

    public void checkResult(String key, String value) {
        output.$("#" + key).shouldHave(text(value));

    }
}
