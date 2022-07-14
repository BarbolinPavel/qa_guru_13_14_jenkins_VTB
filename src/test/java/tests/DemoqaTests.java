package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DemoqaTests extends TestBase {

    @Test
    @Tag("test")
    @DisplayName("Successful Tests")
    void successfulTests() {
        String name = "Ivan";
        String surname = "Ivanov";
        String email = "Ivanov1258@gmail.com";
        String gender = "Male";
        String mobile = "6666666666";
        String subjects = "Maths";
        String hobbies = "Music";
        String address = "Moscow, Petrovka, 38";
        String state = "Rajasthan";
        String city = "Jaipur";

        step("Открываем страницу формы регистрации", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем форму регистрации", () -> {
            registrationFormPage.setFirstName(name)
                    .setLastName(surname)
                    .setUserEmail(email)
                    .setGenter(gender)
                    .setUserNumber(mobile)
                    .setDateOfBirth("01", "June", "2000")
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setUploadPicture("image.jpg")
                    .setCurrentAddress(address)
                    .setState(state)
                    .setCity(city)
                    .setSubmit()
                    .openTable();
        });

        step("Проверяем результат заполнения формы", () -> {
            registrationFormPage.checkResult("Student Name", name + " " + surname)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", mobile)
                    .checkResult("Date of Birth", "01 June,2000")
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", "image.jpg")
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }
}