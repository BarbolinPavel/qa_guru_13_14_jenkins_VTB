package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;
import pages.components.SelectComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    public CalenderComponent calenderComponent = new CalenderComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    public SelectComponent selectComponent = new SelectComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitInput =  $("#submit"),
            practiceFormCheck = $(".practice-form-wrapper"),
            exampleModalCheck = $("#example-modal-sizes-title-lg");

    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        practiceFormCheck.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGenter(String value){
        genterWrapperInput.$(Selectors.byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year){
        dateOfBirthInput.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value){
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value){
        hobbiesInput.$(Selectors.byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUploadPicture(String value){
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value){
        stateInput.click();
        selectComponent.setStateSity(value);

        return this;
    }

    public RegistrationFormPage setCity(String value){
        cityInput.click();
        selectComponent.setStateSity(value);

        return this;
    }

    public RegistrationFormPage setSubmit(){
        submitInput.click();

        return this;
    }

    public RegistrationFormPage openTable(){
        exampleModalCheck.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}