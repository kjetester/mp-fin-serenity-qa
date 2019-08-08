package com.moex.mpfin.steps;

import com.moex.mpfin.steps.registration.NewUserRegistrationSteps;
import cucumber.api.java.en.*;
import io.restassured.*;
import net.thucydides.core.annotations.Steps;

public class NewUserRegistrationStepdefs {

	@Steps
	NewUserRegistrationSteps user;

	@When("^user registers at the Marketplace as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userRegistersAtTheMarketplaceAs(String surname,
	                                            String name,
	                                            String patronymic,
	                                            String emailAddress,
	                                            String phoneNumber) throws InterruptedException {
		if (patronymic.equals("")) {
			patronymic = null;
			user.set_do_not_have_patronymic_into(true);
		}
		user.enters_full_name(surname, name, patronymic);
		user.enters_email(emailAddress);
		user.enters_phone(phoneNumber);
		user.requests_sms_with_otp();
		user.enters_otp("0000");
		user.set_agreement_into(true);
		user.submits_form();
	}

	@And("^user with \"([^\"]*)\" is absent at IDP$")
	public void userWithEmailIsAbsentAtIDP(String emailAddress) {
		RestAssured.get(
			"https://sso.beta.moex.com/auth/realms/marketplace/userService/users/"
			+ emailAddress + "/delete");
	}

	@Then("^he should see the ESIA access granting page$")
	public void heShouldSeeTheESIAAccessGrantingPage() {
		user.should_be_redirected_to_the_ESIA_access_granting_page();
	}

	@Then("^user should be registered at the IDP as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" with \"([^\"]*)\" and \"" +
		"([^\"]*)\"$")
	public void accountWithCorrectDataShouldBeCreatedInIDPWithAndAndPhoneNumber(String surname,
	                                                                            String name,
	                                                                            String patronymic,
	                                                                            String emailAddress,
	                                                                            String phoneNumber) {
		user.should_be_registered_in_idp_as(surname, name, patronymic, emailAddress, phoneNumber);
	}
}
