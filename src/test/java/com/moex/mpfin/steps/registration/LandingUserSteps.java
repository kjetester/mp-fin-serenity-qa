package com.moex.mpfin.steps.registration;

import com.moex.mpfin.pages.RegistrationPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LandingUserSteps {

	RegistrationPage registrationPage;

	@Step
	public void is_on_the_registration_page() {
		registrationPage.open("default");
	}

	@Step
	public void navigates_using_deeplink() {
		registrationPage.open("add-product",
			PageObject.withParameters("1", "1", "1", "120", "5000"));
		registrationPage.submitButton.waitUntilPresent();
	}

	@Step
	public void should_be_redirected_to_the_welcome_page_with_registration_tab_opened() {
		assertThat(registrationPage.getDriver().getCurrentUrl(), containsString("registration"));
//TODO: assertThat(registrationPage.getTitle(), containsString("Регистрация"));
		assertThat("FIO field is not clickable", registrationPage.fioField.isClickable());
	}
}