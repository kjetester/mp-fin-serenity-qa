package com.moex.mpfin.pages;

import net.thucydides.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import javax.security.auth.*;
import java.util.List;

import static com.moex.mpfin.utils.JavaScriptExecutor.jsClick;

@NamedUrls({
	@NamedUrl(name = "", url = "/registration"),
	@NamedUrl(name = "add-product", url = "/add-product?productId={1}&optionId={2}&durationType={3}&durationValue={4}&amount={5}")
})
public class RegistrationPage extends PageObject {

	@FindBy(css = "[data-qa*=registration-tab]")
	private WebElementFacade registrationTab;

	@FindBy(css = "input[name='fio']")
	public WebElementFacade fioField;

	@FindBy(xpath = "//input[@name='hasPatronymic']/..")
	private WebElementFacade hasPatronymic;

	@FindBy(css = "input[name='Электронная почта']")
	private WebElementFacade emailAddressField;

	@FindBy(css = "input[name='phone']")
	private WebElementFacade phoneNumberField;

	@FindBy(css = "[type = 'button']")
	private WebElementFacade requestSmsButton;

	@FindBy(css = "input[name='codeInput']")
	private WebElementFacade otpField;

	@FindBy(xpath = "//*[@name = 'isUserAgreementAccepted']/..")
	private WebElementFacade agreementCheckbox;

	@FindBy(css = "[type*=submit]")
	public WebElementFacade submitButton;

	public void setFioTo(String fullName) {
		if ("".equals(fullName)) {
			fioField.clear();
		} else {
			fioField.sendKeys(fullName);
		}
	}

	public void setDoesNotHahavePatronymic(boolean isSelected) {
		setCheckbox(hasPatronymic, isSelected);
	}

	public void setEmailTo(String emailAddress) {
		if ("".equals(emailAddress)) emailAddressField.clear();
		else jsClick(emailAddressField).sendKeys(emailAddress);
	}

	public void setPhoneTo(String value) {
		if ("".equals(value)) phoneNumberField.clear();
		else jsClick(phoneNumberField).sendKeys(value);
	}

	public void requestSMS() {
		requestSmsButton.waitUntilClickable().click();
	}

	public void setOtpTo(String otp) {
		otpField.waitUntilClickable();
		jsClick(otpField).sendKeys(otp);
	}

	public void setAgreementTo(Boolean isSelected) {
		setCheckbox(agreementCheckbox, isSelected);
	}

	public void submitForm() {
		submitButton.click();
	}
}