package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Mike");
        $("#userEmail").setValue("mike@mail.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Mike"));
        $("#output #email").shouldHave(text("mike@mail.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 2"));
    }
}
