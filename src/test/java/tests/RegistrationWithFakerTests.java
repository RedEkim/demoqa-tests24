package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en"));
    RandomUtils randomUtils = new RandomUtils();

    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String email = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
    String language = faker.programmingLanguage().name();

    @Test
    @DisplayName("Успешная регистрация с заполнением всех полей")
    void successfulRegistrationTest() {
        registrationPage.openPage("/automation-practice-form")
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setGender(randomUtils.getRandomGender())
                        .setUserNumber(randomUtils.getRandomPhoneRu())
                        .setDateOfBirth("17", "October", "2024")
                        .setSubject("Math")
                        .setSubject(language)
                        .setHobbie("Sports")
                        .setHobbie("Reading")
                        .setHobbie("Music")
                        .setPicture("src/test/java/resources/img/pngwing.png")
                        .setAddress(streetAddress)
                        .setStateAndCity("NCR", "Delhi")
                        .setSubmit();


        registrationPage.getModalDialogAppear()
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResult("Student Name", firstName + " " + lastName)
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
