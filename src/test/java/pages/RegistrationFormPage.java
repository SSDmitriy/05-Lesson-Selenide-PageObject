package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

//all the elements
//    SelenideElement firstNameInput = $("#firstName"),
//            lastNameInput = $("#lastName"),
//            userEmail = $("#userEmail"),
//            gender = $("#genterWrapper"),
//            mobile = $("#userNumber");

    //methods should to be public for use in another classes
    //for example in StudentRegistrationFormTest
    public void inputFirstName(String s) {
        $("#firstName").val(s);
    }

    public void inputLastName(String s) {
        $("#lastName").val(s);
    }

    public void inputUserEmail(String s) {
        $("#userEmail").val(s);
    }

    public void specifyGender(String s) {
        $("#genterWrapper").$(byText(s)).click();
    }

    public void inputMobile(String s) {
        $("#userNumber").val(s);
    }

    public void inputSubject(String s) {
        $("#subjectsInput").val(s).pressEnter();
    }

    public void specifyHobbies(String s1, String s2) {
        $("#hobbiesWrapper").$(byText(s1)).click();
        $("#hobbiesWrapper").$(byText(s2)).click();
    }

    // s - for filename without path
    public void uploadFile(String s) {
        $("#uploadPicture").uploadFromClasspath("img/" + s);
        //alt. method $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + picture));
    }

    public void inputAddres(String s) {
        $("#currentAddress").val(s);
    }

    public void selectState(String s) {
        //State !!!need scrollTo
        $("#state").scrollTo().click();
        $("#state").$(byText(s)).click();
    }

    public void selectCity(String s) {
        $("#city").click();
        $("#city").$(byText(s)).click();
    }

    public void pressSubmit() {
        $("#submit").click();
    }

}
