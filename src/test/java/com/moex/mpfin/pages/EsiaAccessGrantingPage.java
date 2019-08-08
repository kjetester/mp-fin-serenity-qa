package com.moex.mpfin.pages;

import net.serenitybdd.core.annotations.findby.*;
import net.serenitybdd.core.pages.*;

public class EsiaAccessGrantingPage  extends PageObject {

	@FindBy(xpath = "//span[contains(text(), 'Войти через Госуслуги')]/..")
	public WebElementFacade submitButton;
}
