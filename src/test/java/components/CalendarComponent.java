package components;

import static com.codeborne.selenide.Selenide.$;

//public class for peek date in calendar
public class CalendarComponent {

    public void setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
        //alt.method for peek dob  $(String.format("[aria-label='Choose %s, %s %sth, %s']", dayOfWeek, monthOfBirth, dayOfBirth, yearOfBirth)).click();

    }
}
