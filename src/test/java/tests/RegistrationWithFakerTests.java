package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.getRandomGender;
import static utils.RandomUtils.getRandomPhoneRu;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String email = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
    String gender = getRandomGender();
    String phoneNumberRu = getRandomPhoneRu();

    @Test
    @DisplayName("Успешная регистрация с заполнением всех полей")
    void successfulRegistrationTest() {
        registrationPage.openPage("/automation-practice-form")
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setGender(gender)
                        .setUserNumber(phoneNumberRu)
                        .setDateOfBirth("24", "October", "2024")
                        .setSubject("Math")
                        .setSubject("English")
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
                        .checkResult("Student Email", email)
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", phoneNumberRu)
                        .checkResult("Date of Birth", "24 October,2024")
                        .checkResult("Subjects", "Maths, English")
                        .checkResult("Hobbies", "Sports, Reading, Music")
                        .checkResult("Picture", "pngwing.png")
                        .checkResult("Address", streetAddress)
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
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setGender(gender)
                        .setUserNumber(phoneNumberRu)
                        .setSubmit();

        registrationPage.getModalDialogAppear()
                .checkModalTitle("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumberRu)
                .setCloseBtn();
    }
}
