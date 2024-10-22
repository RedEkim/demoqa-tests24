package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestsWithPageObjectsTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {

        textBoxPage.openTextPoxPage()
                    .setUserName("Mike Mikov")
                    .setEmailInput("mike@mail.com")
                    .setCurrentAddressArea("Some street 1")
                    .setPermanentAddressArea("Another street 2")
                    .sbmBtnClick();

        textBoxPage.checkOutput("Name:", "Mike Mikov")
                .checkOutput("Email:", "mike@mail.com")
                .checkOutput("Current Address :", "Some street 1")
                .checkOutput("Permananet Address :", "Another street 2");
    }
}
