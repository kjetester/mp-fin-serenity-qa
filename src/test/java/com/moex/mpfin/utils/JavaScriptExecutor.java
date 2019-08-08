package com.moex.mpfin.utils;

import net.serenitybdd.core.pages.*;
import org.openqa.selenium.*;

import javax.swing.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class JavaScriptExecutor {

	private static JavascriptExecutor js = (JavascriptExecutor) getDriver();

	/**
	 * Click with JavascriptExecutor.
	 * @param element element
	 * @return element
	 */
	public static WebElementFacade jsClick(WebElementFacade element) {
		js.executeScript("arguments[0].click();", element);
		return element;
	}

	public static String getWindowTitle() {
		return js.executeScript("return document.title;").toString();
	}

	public static String getMoexUserId() {
		return js.executeScript("return window.$nuxt.$store.state.registration.payload.moexUserId;").toString();
	}
}
