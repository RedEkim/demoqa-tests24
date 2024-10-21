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

        //open("/text-box");
        //$("#userName").setValue("Mike");
        textBoxPage.openTextPoxPage()
                    .setUserName("Mike Mikov")
                    .setEmailInput("mike@mail.com")
                    .setCurrentAddressArea("Some street 1")
                    .setPermanentAddressArea("Another street 2")
                    .sbmBtnClick();
        //$("#userEmail").setValue("mike@mail.com");
        //$("#currentAddress").setValue("Some street 1");
//        $("#permanentAddress").setValue("Another street 2");
//        $("#submit").click();

        $("#output #name").shouldHave(text("Mike"));
        $("#output #email").shouldHave(text("mike@mail.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 2"));
    }
}
