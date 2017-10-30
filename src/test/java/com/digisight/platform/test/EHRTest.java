package com.digisight.platform.test;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.digisight.platform.dp.UserServiceDP;
import com.digisight.platform.helper.UserprofileHelper;
import com.digisight.platform.userInfo.AccessToken;
import com.digisight.platform.utility.BaseApiTest;
import com.digisight.platform.utility.Headers;
import com.digisight.platform.utility.StatusCodes;
import com.digisight.platform.utility.UiLogger;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

public class EHRTest extends BaseApiTest{

	/**
	 * @author Mahesh Reddy
	 * Created Date: 23-10-07
	 *
	 */  

	BaseApiTest baseTest;
	Headers headers;
	Gson gson;
	HashMap<String, Object> headerMap;
	private static UiLogger logger = UiLogger.getLogger(EHRTest.class);
    public static String autToken;
	@BeforeClass
	public void testSetUp() {
		
		baseTest = new BaseApiTest();
		headers = new Headers();
		gson = new Gson();
		headerMap = new HashMap<String, Object>();
		
	}

	@Test(priority =1, groups = { "Smoke", "Sanity" }, dataProvider = "ehrInfo", dataProviderClass = UserServiceDP.class)
	public void ehrTest(String url, String uname,String pwd,String authType,String email)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.ehiContentType);
		headerMap.put("Accept", Headers.ehiContentType);
		
		String payload=UserprofileHelper.ehr(uname, pwd);
		System.out.println("UserprofileHelper payload ::"+payload);
		
		String response = baseTest.httpRequestPost(url, payload, "json", headerMap, Integer.parseInt(StatusCodes.creationStatusCode));
		logger.info("User Service Responce ::"+response);   
		
		AccessToken accessToken = gson.fromJson(response, AccessToken.class);
		logger.info("User Service accessToken ::"+accessToken.getAccess_token());
		logger.info("User Service Token_type ::"+accessToken.getToken_type());
		autToken=accessToken.getToken_type().concat(" ").concat(accessToken.getAccess_token());
		
		Assert.assertEquals(accessToken.getToken_type(), authType,"Auth type should be same.");
		logger.info("Ehr AutToken ::"+autToken);   
		
		
		
	}
}
