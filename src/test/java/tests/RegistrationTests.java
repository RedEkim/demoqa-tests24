package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    @Test
    void RegistrationWithPageObjectsTests() {
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
        // verify
        $x("//td[contains(text(), 'Student Name')]/../td[2]").shouldHave(text("Mike Mikov"));
        $x("//td[contains(text(), 'Student Email')]/../td[2]").shouldHave(text("mike@mail.com"));
        $x("//td[contains(text(), 'Gender')]/../td[2]").shouldHave(text("Male"));
        $x("//td[contains(text(), 'Mobile')]/../td[2]").shouldHave(text("1234567891"));
        $x("//td[contains(text(), 'Date of Birth')]/../td[2]").shouldHave(text("01 January,1970"));
        $x("//td[contains(text(), 'Subjects')]/../td[2]").shouldHave(text("English"));
        $x("//td[contains(text(), 'Hobbies')]/../td[2]").shouldHave(text("Sports, Music"));
        $x("//td[contains(text(), 'Picture')]/../td[2]").shouldHave(text("pngwing.png"));
        $x("//td[contains(text(), 'Address')]/../td[2]").shouldHave(text("Some Street 1"));
        $x("//td[contains(text(), 'State and City')]/../td[2]").shouldHave(text("Haryana Karnal"));

        //close
        $("button[id=closeLargeModal]").click();
    }
}
