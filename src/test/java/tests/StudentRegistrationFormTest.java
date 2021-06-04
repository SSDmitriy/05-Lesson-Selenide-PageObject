package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    //Test data
    String  firstName = "Boba",
            lastName = "Fet",
            email = "fet66@em.com",
            gender = "Other",
            mobile = "9876543210",
            dayOfBirth = "28",
            monthOfBirth = "August",
            yearOfBirth = "1980",
            dayOfWeek = "Thursday",
            subject1 = "Chemistry",
            subject2 = "Accounting",
            hobby1 = "Sports",
            hobby2 = "Reading",
            picture = "testPic.png",
            currentAddres = "Tatuine, MosIsly",
            state = "Haryana",
            city = "Panipat";


    @Test
    void sucsessfulRegistrationTest() {
        //Arrange
        //open site
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //Act
        //fill fields
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);

        //select gender
        $("#genterWrapper").$(byText(gender)).click();

        //Mobile
        $("#userNumber").val(mobile);

        ///dob
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format("[aria-label='Choose %s, %s %sth, %s']",
                dayOfWeek, monthOfBirth, dayOfBirth, yearOfBirth)).click();
//        $(String.format("react-datepicker__day--0%s", dayOfBirth): not() react-datepicker__day--outside-month)
//<div class="react-datepicker__day react-datepicker__day--028 react-datepicker__day--outside-month" tabindex="-1" aria-label="Choose Monday, July 28th, 1980" role="option" aria-disabled="false">28</div>
//<div class="react-datepicker__day react-datepicker__day--028" tabindex="-1" aria-label="Choose Thursday, August 28th, 1980" role="option" aria-disabled="false">28</div>
//        sleep(3000);

        //Assert
    }
}
