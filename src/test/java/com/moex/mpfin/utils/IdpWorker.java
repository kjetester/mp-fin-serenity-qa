package com.moex.mpfin.utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.core.Serenity;

public class IdpWorker {

	private static final String BASE_IDP_URL = "https://sso.beta.moex.com";
	private static final String READ_USER_RESOURCE = "/auth/realms/marketplace/userService/users/";
	private static final Header AUTH_BASIC = new Header("Authorization", "Basic bXBfYWRtaW46UlQ2P34xV1E=");
	private static String moexUserId;

	public static void setMoexUserId(String moexUserId) {
		IdpWorker.moexUserId = moexUserId;
	}

	private static JsonPath getUserData() {
			return RestAssured
				.given().header(AUTH_BASIC)
				.get(BASE_IDP_URL + READ_USER_RESOURCE + moexUserId).jsonPath();
	}

	public static String getIdpResponse() {
		return getUserData().prettyPrint();
	}

	public static Object getUserAttribute(String attributeName) {
		return getUserData().get(attributeName);
	}
}
