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

    public void inputUserEmail (String s) {
        $("#userEmail").val(s);
    }

    public void specifyGender (String s) {
        $("#genterWrapper").$(byText(s)).click();
    }

    public void inputMobile (String s) {
        $("#userNumber").val(s);
    }
}
