package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                        .setFirstName("Mike")
                        .setLastName("Mikov")
                        .setEmail("mikemikov@testmail.ru")
                        .setGender("Male")
                        .setUserNumber("79995463423")
                        .setDateOfBirth("17", "October", "2024")
                        .setSubject("Math")
                        .setSubject("English")
                        .setHobbie("Sports")
                        .setHobbie("Reading")
                        .setHobbie("Music")
                        .setPicture("src/test/java/resources/img/pngwing.png")
                        .setAddress("Some address 1")
                        .setStateAndCity("NCR", "Delhi")
                        .setSubmit();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text("Mike"), text("Mikov"),
          //      text("mikemikov@testmail.ru"), text("79995463423"));
        registrationPage.checkResult("Student Name", "Mike Mikov")
                .checkResult("Student Email", "mikemikov@testmail.ru");
    }
}
