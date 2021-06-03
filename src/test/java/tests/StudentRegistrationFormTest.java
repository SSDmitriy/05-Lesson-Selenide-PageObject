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
            monthOfBirth = "june",
            yearOfBirth = "1980",
            //dayOfWeek = "1980",
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

//        sleep(3000);

        //Assert
    }
}
