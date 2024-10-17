package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
                        .setDateOfBirth("17", "October", "2024");
    }
}
