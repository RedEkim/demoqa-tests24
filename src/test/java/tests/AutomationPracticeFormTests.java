package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Mikov");
        $("#userEmail").setValue(("mike@mail.com"));

        // radio buttons
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("12345678910");

        // Calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1970");
        $("[class=\"react-datepicker__day react-datepicker__day--001\"]").shouldHave(text("1")).click();

        // Subject
        $("#subjectsInput").setValue("en");
        $("#react-select-2-option-0").click();



        // checkboxes
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();

        // upload picture
        $("#uploadPicture").uploadFile(new File("src/test/java/data/pngwing.png"));

        // address
        $("#currentAddress").setValue("Some Street 1");

        // dropdown state city
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        // button submit
        $("button[type=submit]").click();
    }
}
