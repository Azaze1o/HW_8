package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import demoqa.pages.RegistrationFormPage;
import demoqa.testData.Variables;

public class DemoTestObj {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void simpleTest(){
        registrationFormPage
                .openPage()
                .setFirstName(Variables.firstName)
                .setLastName(Variables.lastName)
                .setEmail(Variables.email)
                .setGenderWrapper(Variables.gender)
                .setPhoneNumber(Variables.number)
                .setAddress(Variables.address)
                .setBirthdate(Variables.year,Variables.month,Variables.day)
                .setHobbies(Variables.hobbies)
                .uploadPicture(Variables.picturePath)
                .setSubjects(Variables.subjects)
                .setState(Variables.state)
                .setCity(Variables.city)
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name", Variables.firstName + " " + Variables.lastName)
                .checkResult("Student Email", Variables.email)
                .checkResult("Gender", Variables.gender)
                .checkResult("Mobile", Variables.number)
                .checkResult("Date of Birth",Variables.birthDay)
                .checkResult("Subjects", Variables.subjects)
                .checkResult("Hobbies", Variables.hobbies)
                .checkResult("Address", Variables.address)
                .checkResult("Picture", Variables.picture)
                .checkResult("State and City", Variables.state+" "+ Variables.city);

    }
}
