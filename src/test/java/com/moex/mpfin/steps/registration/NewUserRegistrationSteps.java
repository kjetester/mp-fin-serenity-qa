package com.moex.mpfin.steps.registration;

import com.moex.mpfin.pages.EsiaAccessGrantingPage;
import com.moex.mpfin.pages.RegistrationPage;
import com.moex.mpfin.utils.IdpWorker;
import com.moex.mpfin.utils.JavaScriptExecutor;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class NewUserRegistrationSteps {

	RegistrationPage registrationPage;
	EsiaAccessGrantingPage esiaAccessGrantingPage;

	@Step
	public void enters_full_name(String surname, String name, String patronymic) {
		if (patronymic == null) {
			registrationPage.setFioTo(surname + " " + name);
		} else {
			registrationPage.setFioTo(surname + " " + name + " " + patronymic);
		}
	}

	@Step
	public void set_do_not_have_patronymic_into(Boolean isSelected) {
		registrationPage.setDoesNotHahavePatronymic(true);
	}

	@Step
	public void enters_email(String email) {
		registrationPage.setEmailTo(email);
	}

	@Step
	public void enters_phone(String phoneNumber) {
		registrationPage.setPhoneTo(phoneNumber);
	}

	@Step
	public void requests_sms_with_otp() {
		registrationPage.requestSMS();
	}

	@Step
	public void enters_otp(String otpCode) {
		registrationPage.setOtpTo(otpCode);
	}

	@Step
	public void set_agreement_into(Boolean isSelected) {
		registrationPage.setAgreementTo(isSelected);
	}

	@Step
	public void submits_form() throws InterruptedException {
		registrationPage.submitForm();
		Thread.sleep(3000);
	}

	@Step
	public void should_be_redirected_to_the_ESIA_access_granting_page() {
		assertThat(esiaAccessGrantingPage.getDriver().getCurrentUrl(), containsString("registration-2"));
//TODO: assertThat(esiaAccessGrantingPage.getTitle(), containsString("Добаление учётной записи Госуслуг"));
		assertThat("", esiaAccessGrantingPage.submitButton.isClickable());
	}

	public void should_be_registered_in_idp_as(String surname, String name, String patronymic, String emailAddress, String phoneNumber) {
		IdpWorker.setMoexUserId(JavaScriptExecutor.getMoexUserId());
		Serenity.recordReportData().withTitle("User data at the IDP").andContents(IdpWorker.getIdpResponse());
		if (patronymic.equals("")) patronymic = null;
		assertThat(IdpWorker.getUserAttribute("user.lastName"), equalTo(surname));
		assertThat(IdpWorker.getUserAttribute("user.firstName"), equalTo(name));
		assertThat(IdpWorker.getUserAttribute("user.middleName"), equalTo(patronymic));
		assertThat(IdpWorker.getUserAttribute("user.email"), equalTo(emailAddress));
		assertThat(IdpWorker.getUserAttribute("user.phone"), equalTo(phoneNumber));
		assertThat("", (Boolean) IdpWorker.getUserAttribute("user.isUserAgreementAccepted"));
		assertThat("", (Boolean) IdpWorker.getUserAttribute("user.isPlatformRulesAccepted"));
		assertThat(IdpWorker.getUserAttribute("status"), equalTo("OK"));
	}

	public void close_browser() {
		Serenity.getWebdriverManager().clearCurrentDriver();
		Serenity.getWebdriverManager().closeDriver();
	}
}
