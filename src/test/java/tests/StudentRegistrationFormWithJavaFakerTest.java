package tests;

import com.github.javafaker.Faker;
import components.CalendarComponent;
import org.junit.jupiter.api.Test;
import pages.AssertPage;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//main class with TEST DATA, TEST STEPS and ASSERTIONS
//before test steps creating three PAGE OBJECTS:
// -for fields
// -for CALENDAR component
// -for Assertions
public class StudentRegistrationFormWithJavaFakerTest extends TestBase {

    Faker faker = new Faker();

    //----------
    //Test data
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Other",
            mobile = faker.number().digits(10),
            dayOfBirth = "28",
            monthOfBirth = "August",
            yearOfBirth = "1980",
            //dayOfWeek = "Thursday",
            subject = "Chemistry",
            hobby1 = "Sports",
            hobby2 = "Reading",
            picture = "JPGsample.jpg",
            currentAddres = faker.address().fullAddress(),
            state = "Haryana",
            city = "Panipat";
    //table-tittle for checking after submit
    String title = "Thanks for submitting the form";

    //create PAGE OBJECTS
    //for fields
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    //for CALENDAR component
    CalendarComponent calendarComponent = new CalendarComponent();
    //for Assertions
    AssertPage assertPage = new AssertPage();

    @Test
    void sucsessfulRegistrationTest() {

        //----------
        //Arrange
        //open site
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //----------
        //Act
        //fill pers info
        registrationFormPage.inputFirstName(firstName);
        registrationFormPage.inputLastName(lastName);
        registrationFormPage.inputUserEmail(email);

        //specify
        registrationFormPage.specifyGender(gender);

        //mobile
        registrationFormPage.inputMobile(mobile);

        //peek dob (August 28th 1980 Thursday)
        calendarComponent.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);

        //subj
        registrationFormPage.inputSubject(subject);

        //specify hobby
        registrationFormPage.specifyHobbies(hobby1, hobby2);

        //chose file
        registrationFormPage.uploadFile(picture);

        //address
        registrationFormPage.inputAddres(currentAddres);

        //select State
        registrationFormPage.selectState(state);

        //select City
        registrationFormPage.selectCity(city);

        //Submit
        registrationFormPage.pressSubmit();

        //----------
        //Assertions
        assertPage.checkTitle(title);
        assertPage.checkStudentName(firstName, lastName);
        assertPage.checkStudentEmail(email);
        assertPage.checkGender(gender);
        assertPage.checkMobile(mobile);
        assertPage.checkDob(dayOfBirth, monthOfBirth, yearOfBirth);
        assertPage.checkSubject(subject);
        assertPage.checkHobbies(hobby1, hobby2);
        assertPage.checkFileName(picture);
        assertPage.checkCurrentAddres(currentAddres);
        assertPage.checkStateAndCity(state, city);
    }
}
