package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieCheckbox = $("#hobbiesWrapper"),
            pictureLoad = $("#uploadPicture"),
            addressArea = $("#currentAddress"),
            stateField = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityField = $("#city"),
            submitBtn = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            closeBtn = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(String value) {
        open(value);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbieCheckbox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureLoad.uploadFile(new File(value));

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressArea.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateField.click();
        stateCityWrapper.$(byText(state)).click();
        cityField.click();
        stateCityWrapper.$(byText(city)).click();

        return  this;
    }

    public  RegistrationPage setSubmit() {
        submitBtn.click();

        return this;
    }

    public RegistrationPage setCloseBtn() {
        closeBtn.click();

        return this;
    }

    public RegistrationPage getModalDialogAppear() {
        modalDialog.should(appear);

        return this;
    }

    public RegistrationPage checkModalTitle(String value) {
        modalTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
