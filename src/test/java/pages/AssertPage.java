package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//class PAGE OBJECT for checking after filling and submit a form
public class AssertPage {

    public void checkTitle(String tittle) {
        $("#example-modal-sizes-title-lg").shouldHave(text(tittle));
    }

    public void checkStudentName(String firstName, String lastName) {
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
    }

    public void checkStudentEmail(String email) {
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
    }

    public void checkGender(String gender) {
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
    }

    public void checkMobile(String mobile) {
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
    }

    public void checkDob(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " "
                + monthOfBirth + "," + yearOfBirth));
    }

    public void checkSubject(String subject) {
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
    }

    public void checkHobbies(String hobby1, String hobby2) {
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby2));
    }

    public void checkFileName(String picture) {
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
    }

    public void checkCurrentAddres(String currentAddres) {
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddres));
    }

    public void checkStateAndCity(String state, String city) {
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}
