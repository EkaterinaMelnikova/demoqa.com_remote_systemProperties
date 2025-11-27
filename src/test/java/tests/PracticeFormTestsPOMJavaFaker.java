package tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;




public class PracticeFormTestsPOMJavaFaker extends TestBase {

    @Tag("demoqa")
    @Test
    void fillPracticeFormTest() {

        practiceFormPage.openPage()
                .setFirstName(testData.userName)
                .setLastName(testData.userlastName)
                .setEmail(testData.userEmail1)
                .setGender(testData.userGender)
                .setPhone(testData.userPhone)
                .setBirthDate(testData.birthDay,testData.birthMonth,testData.birthYear)
                .setSubject(testData.userSubject)
                .setHobbie(testData.userHobbie)
                .setPicture(testData.img)
                .setAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .submit();


        practiceFormPage.verifyResultsModalAppear()
                .verifyResult("Student Name", testData.userName + " " + testData.userlastName)
                .verifyResult("Student Email", testData.userEmail1)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userPhone)
                .verifyResult("Date of Birth", testData.birthDate);


    }
}
