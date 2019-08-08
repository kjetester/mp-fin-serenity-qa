package com.moex.mpfin;

import cucumber.api.CucumberOptions;
import cucumber.api.java.*;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import java.util.concurrent.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	features= {
		"src/test/resources/features/registration/1Landing.feature",
		"src/test/resources/features/registration/2NewUserRegistration.feature",
		"src/test/resources/features/registration/3RedirectingUserAfterSuccessRegistration.feature",
		"src/test/resources/features/registration/4ExistingUserRegistration.feature"
			})
public class RegistrationTestSuite {}
