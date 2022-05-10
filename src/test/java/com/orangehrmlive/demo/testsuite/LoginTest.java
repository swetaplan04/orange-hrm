package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully(){
        loginPage.enterUser("Admin");
        loginPage.enterPassowrd("admin123");
        loginPage.clickOnLoginBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.verifyWelcomeText().substring(1,7),"WelCome","");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.enterUser("Admin");
        loginPage.enterPassowrd("admin123");
        loginPage.clickOnLoginBtn();
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(homePage.verifyLogo(),"Logo");

    }
    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully(){
        loginPage.enterUser("Admin");
        loginPage.enterPassowrd("admin123");
        loginPage.clickOnLoginBtn();
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(loginPage.verifyLogin(),"Login Panel","");



    }
}