package com.moex.mpfin.steps;

import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;

import com.moex.mpfin.steps.registration.LandingUserSteps;

public class LandingStepdefs {

	@Steps
	LandingUserSteps user;

	@When("the User browsing the Web with deepLink")
	public void givenTheUserBrowsingTheWebWithDeeplink() {
		user.navigates_using_deeplink();
	}

	@Then("he should see the registration page")
	public void heShouldSeeTheRegistrationPage() {
		user.should_be_redirected_to_the_welcome_page_with_registration_tab_opened();
	}


}
