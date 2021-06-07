package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest extends TestBase {

    //Test data
    String firstName = "Boba",
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
            picture = "JPGsample.jpg",
            currentAddres = "Tatooine Mos Eisley",
            state = "Haryana",
            city = "Panipat";

    //cherking data
    String title = "Thanks for submitting the form";



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

        ///dob (August 28th 1980 Thursday)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
        //alt.method for peek dob  $(String.format("[aria-label='Choose %s, %s %sth, %s']", dayOfWeek, monthOfBirth, dayOfBirth, yearOfBirth)).click();

        //subj
        $("#subjectsInput").val(subject1).pressEnter();

        //hobby
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();

        //Chose file
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
        //alt. method $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + picture));

        //address
        $("#currentAddress").val(currentAddres);

        //State !!!need scrollTo
        $("#state").scrollTo().click();
        $("#state").$(byText(state)).click();

        //City
        $("#city").click();
        $("#city").$(byText(city)).click();

        //Submit
        $("#submit").click();

        //Assert
        $("#example-modal-sizes-title-lg").shouldHave(text(title));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth +
                                                                                         "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddres));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));


    }
}
