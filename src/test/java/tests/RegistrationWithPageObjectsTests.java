package tests;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Успешная регистрация с заполнением всех полей")
    void successfulRegistrationTest() {
        registrationPage.openPage("/automation-practice-form")
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


        registrationPage.getModalDialogAppear()
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResult("Student Name", "Mike Mikov")
                        .checkResult("Student Email", "mikemikov@testmail.ru")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "7999546342")
                        .checkResult("Date of Birth", "17 October,2024")
                        .checkResult("Subjects", "Maths, English")
                        .checkResult("Hobbies", "Sports, Reading, Music")
                        .checkResult("Picture", "pngwing.png")
                        .checkResult("Address", "Some address 1")
                        .checkResult("State and City", "NCR Delhi")
                        .setCloseBtn();
    }

    @Test
    @DisplayName("Неуспешная регистрация")
    void negativeRegistrationTest() {
        registrationPage.openPage("/automation-practice-form")
                        .setSubmit();
    }

    @Test
    @DisplayName("Успешная регистрация с заполнением основных полей")
    void minDataRegistrationTest() {
        registrationPage.openPage("/automation-practice-form")
                        .setFirstName("Mike")
                        .setLastName("Mikov")
                        .setGender("Male")
                        .setUserNumber("79995463423")
                        .setSubmit();

        registrationPage.getModalDialogAppear()
                .checkModalTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Mike Mikov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7999546342")
                .setCloseBtn();
    }
}
