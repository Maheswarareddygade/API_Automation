package com.digisight.platform.test;

import org.testng.annotations.Test;

import com.digisight.platform.dp.UserServiceDP;
import com.digisight.platform.helper.UserprofileHelper;
import com.digisight.platform.userInfo.AccessToken;
import com.digisight.platform.userInfo.EncounterList;
import com.digisight.platform.userInfo.FilterLocationList;
import com.digisight.platform.userInfo.LocationList;
import com.digisight.platform.userInfo.Physician;
import com.digisight.platform.userInfo.Physicians;
import com.digisight.platform.userInfo.PracticeLocations;
import com.digisight.platform.userInfo.Practices;
import com.digisight.platform.userInfo.PracticesList;
import com.digisight.platform.userInfo.UserInfo;
import com.digisight.platform.utility.BaseApiTest;
import com.digisight.platform.utility.Headers;
import com.digisight.platform.utility.StatusCodes;
import com.digisight.platform.utility.UiLogger;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class UserServiceTest extends BaseApiTest {
	
	
	/**
	 * @author Mahesh Reddy
	 * Created Date: 23-10-07
	 *
	 */  

	BaseApiTest baseTest;
	Headers headers;
	Gson gson;
	HashMap<String, Object> headerMap;
	private static UiLogger logger = UiLogger.getLogger(UserServiceTest.class);
    public static String autToken;
    public static final String digiSight="DIGISIGHT.NET";
    int patient = 0;
    
	@BeforeClass
	public void testSetUp() {
		
		baseTest = new BaseApiTest();
		headers = new Headers();
		gson = new Gson();
		headerMap = new HashMap<String, Object>();
	}

	@Test(priority =1, groups = { "Smoke", "Sanity" }, dataProvider = "authorization", dataProviderClass = UserServiceDP.class,description=" Method is used to test authorization service ")
	public void getAuthorizationServiceTest(String url, String tokenType,String password,String email,String pwd,String appVersion)
			throws JsonGenerationException, JsonMappingException, IOException {

		System.out.println("EHR Payload :"+UserprofileHelper.ehrPaload());
		headerMap.put("Content-Type", Headers.contentType);
		String payload=UserprofileHelper.authorization(password,  email,  pwd, appVersion);
		System.out.println("UserprofileHelper payload ::"+payload);
		String response = baseTest.httpRequestPost(url, payload, "json", headerMap, Integer.parseInt(StatusCodes.creationStatusCode));
		logger.info("User Service Responce ::"+response);   
		
		AccessToken accessToken = gson.fromJson(response, AccessToken.class);
		logger.info("User Service accessToken ::"+accessToken.getAccessToken());
		autToken=accessToken.getTokenType().concat(" ").concat(accessToken.getAccessToken());
		
		Assert.assertEquals(accessToken.getTokenType(), tokenType,"Token Type Should be same .");
		
		
	}
	
	
	
	
	
	@Test(priority =2,dependsOnMethods = { "getAuthorizationServiceTest" },groups = { "Smoke", "Sanity" },dataProvider = "userInfo", dataProviderClass = UserServiceDP.class,description=" Method is used to test user info service. ")
	public void getUserInfoServiceTest(String url, String appid,String firstName,String city,String email,String plId,String plName,String plPracticeId,String practicesid,String physicianId,String physicianUserId, String physicianPracticeId,String physicianEmail)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		String response = baseTest.httpRequestGet(url, headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		logger.info("User Service Responce ::"+response);
		
		UserInfo userInfo = gson.fromJson(response, UserInfo.class);
		
		Assert.assertEquals(userInfo.getAppId(), appid,  "App ID should be same. ");
		Assert.assertEquals(userInfo.getFirstName(), firstName, " FirstName should be same");
		Assert.assertEquals(userInfo.getCity(), city," City should be same. ");
		Assert.assertEquals(userInfo.getEmail(), email," Email should be same. ");
		
		PracticeLocations[]	practiceLocations=userInfo.getPracticeLocations();

		Assert.assertEquals(practiceLocations[0].getId(), plId," Practice locations id should be same.");
		Assert.assertEquals(practiceLocations[0].getName(), plName,"PracticeLocations name should be same.");
		Assert.assertEquals(practiceLocations[0].getPracticeId(),plPracticeId,"Practice Locations practiceId should be same. ");
		
		
		Practices[]  practices=userInfo.getPractices();
		Assert.assertEquals(practices[0].getId(), practicesid,"Practices id should be same");
		
		Physician  physician=userInfo.getPhysician();
		
		Assert.assertEquals(physician.getId(), physicianId,"Physician id should be same.");
		Assert.assertEquals(physician.getUserId(), physicianUserId,"Physician user id should be same.");
		Assert.assertEquals(physician.getPracticeId(), physicianPracticeId,"Physician practice id should be same.");
		Assert.assertEquals(physician.getEmail(), physicianEmail," Physician email should be same. ");
		
	}
	
	
	
	@Test(priority =3,groups = { "Smoke", "Sanity" }, dataProvider = "filterLacation", dataProviderClass = UserServiceDP.class,description=" Method is used to test filter locations list service.")
	public void filterLocationslistServiceTest(String url, String encounterCount,String locationName,String locationId)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		String filterLocationsResponse = baseTest.httpRequestGet(url, headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		logger.info("Responce ::"+filterLocationsResponse);
		
		FilterLocationList[] filterLocationList = gson.fromJson(filterLocationsResponse, FilterLocationList[].class);
		
		logger.info("Filter Location Size :"+filterLocationList.length);
		Assert.assertEquals(filterLocationList[0].getEncounterCount(), encounterCount,"Encounter count should be same. ");
		Assert.assertEquals(filterLocationList[0].getName(), locationName," Location name should be same.");
		
		String[] locationID=filterLocationList[0].getLocationIds();
		Assert.assertEquals(locationID[0], locationId,"Location id should be same. ");
		
		
	}
	
	
	
	@Test(priority =4,groups = { "Smoke", "Sanity" }, dataProvider = "createEncounter", dataProviderClass = UserServiceDP.class,description=" Method is used to test create encounter & encounter list service.")
	public void encounterListServiceTest(String url)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		Random r = new Random();
		int randamVal= r.nextInt((10000 - 100) + 1) + 100;
		String  randamNumumber = digiSight+randamVal;
		
		String createEncounterQP="encounters.json?first_name="+randamNumumber+"&last_name="+randamNumumber+"&gender=M&date_of_birth=12-12-2009&event_time=2017-04-21T11:46:07+0530&mrn=123456789&practice_location_id=492";
		String encounterListQP="encounters?";
		String encounter = baseTest.httpRequestPost(url.concat(createEncounterQP), "{}", "json", headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		logger.info("Create Encounter Responce ::"+encounter);
		logger.info("Randam Value ::"+randamNumumber);
		
		EncounterList encounterList = gson.fromJson(encounter, EncounterList.class);
		
		Assert.assertEquals(encounterList.getFirst_name(), randamNumumber,"First_name should be same. ");
		Assert.assertEquals(encounterList.getLast_name(), randamNumumber," Last_name should be same. ");
		
		String encounterLsitResponce = baseTest.httpRequestGet(url.concat(encounterListQP), headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		
		logger.info("Encounter List Responce ::"+encounterLsitResponce);
		
		EncounterList[] encounterListred = gson.fromJson(encounterLsitResponce, EncounterList[].class);
		
		logger.info("Encounter List Responce ::"+encounterListred.length);
		
		Assert.assertEquals(encounterListred[0].getFirst_name(), randamNumumber,"First_name should be same. ");
		Assert.assertEquals(encounterListred[0].getLast_name(), randamNumumber," Last_name should be same. ");
		
		
	}
	
	
	@Test(priority =5,groups = { "Smoke", "Sanity" }, dataProvider = "locationList", dataProviderClass = UserServiceDP.class,description=" Method is used to test location list service.")
	public void locationListServiceTest(String url,String id,String practiceId,String name)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		String locationLsitResponce = baseTest.httpRequestGet(url, headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		
		logger.info("location List Responce ::"+locationLsitResponce);
		
		LocationList[] locationList = gson.fromJson(locationLsitResponce, LocationList[].class);
		logger.info("location List Responce ::"+locationList.length);
		
		Assert.assertEquals(locationList[0].getId(), id,"ID should be same. ");
		Assert.assertEquals(locationList[0].getPracticeId(), practiceId," Practice Id should be same. ");
		Assert.assertEquals(locationList[0].getName(), name,"Name should be same. ");
		
	}
	
	
	
	@Test(priority =6,groups = { "Smoke", "Sanity" }, dataProvider = "patientList", dataProviderClass = UserServiceDP.class,description=" Method is used to test patient list service.")
	public void patientListServiceTest(String url)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		Random r = new Random();
		int randamVal= r.nextInt((10000 - 100) + 1) + 100;
		String  randamNumumber = digiSight+randamVal;
		
		String createEncounterQP="encounters.json?first_name="+randamNumumber+"&last_name="+randamNumumber+"&gender=M&date_of_birth=12-12-2009&event_time=2017-04-21T11:46:07+0530&mrn=123456789&practice_location_id=492";
		String patientsListQP="patients";
		String encounter = baseTest.httpRequestPost(url.concat(createEncounterQP), "{}", "json", headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		logger.info("Create Encounter Responce ::"+encounter);
		logger.info("Randam Value ::"+randamNumumber);
		
		EncounterList encounterList = gson.fromJson(encounter, EncounterList.class);
		
		Assert.assertEquals(encounterList.getFirst_name(), randamNumumber,"First_name should be same. ");
		Assert.assertEquals(encounterList.getLast_name(), randamNumumber," Last_name should be same. ");
		
		String patientsLsitResponce = baseTest.httpRequestGet(url.concat(patientsListQP), headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		
		logger.info("Patients List Responce ::"+patientsLsitResponce);
		
		EncounterList[] patientListred = gson.fromJson(patientsLsitResponce, EncounterList[].class);
		
		logger.info("Encounter List Responce ::"+patientListred.length);
		
		for(int i=0;i<patientListred.length;i++) {
			if(patientListred[i].getFirst_name().equals(randamNumumber)) {
				patient=i;
				logger.info("Patient First & Last Name ::"+patientListred[i].getFirst_name()+": "+patientListred[i].getFirst_name());
			}
		}
		Assert.assertEquals(patientListred[patient].getFirst_name(), randamNumumber,"First_name should be same. ");
		Assert.assertEquals(patientListred[patient].getLast_name(), randamNumumber,"Last_name should be same.");
		
		
	}
	
	

	@Test(priority =7,groups = { "Smoke", "Sanity" }, dataProvider = "practicesList", dataProviderClass = UserServiceDP.class,description=" Method is used to test location list service.")
	public void practicesListServiceTest(String url)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		String locationLsitResponce = baseTest.httpRequestGet(url, headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		
		logger.info("location List Responce ::"+locationLsitResponce);
		
		PracticesList[] practicesList = gson.fromJson(locationLsitResponce, PracticesList[].class);
		logger.info("Practices List Responce ::"+practicesList.length);
		
		Assert.assertEquals(practicesList[0].getId(), "153","ID should be same. ");
		Assert.assertEquals(practicesList[0].getCountry(), "United States"," Country should be same. ");
		Assert.assertEquals(practicesList[0].getEmail(), "autmationadmin@digisight.net","Email should be same. ");
		Assert.assertEquals(practicesList[0].getCity(), "manchester","City should be same. ");
		Assert.assertEquals(practicesList[0].getState(), "alska","State should be same. ");
		
	}
	
	
	@Test(priority =8,groups = { "Smoke", "Sanity" }, dataProvider = "physiciansList", dataProviderClass = UserServiceDP.class,description=" Method is used to test location list service.")
	public void physiciansListServiceTest(String url)
			throws JsonGenerationException, JsonMappingException, IOException {

		headerMap.put("Content-Type", Headers.contentType);
		headerMap.put("Accept", Headers.contentType);
		headerMap.put("Authorization", UserServiceTest.autToken);
		
		String locationLsitResponce = baseTest.httpRequestGet(url, headerMap, Integer.parseInt(StatusCodes.successStatusCode));
		
		logger.info("location List Responce ::"+locationLsitResponce);
		
		Physicians[] physiciansList = gson.fromJson(locationLsitResponce, Physicians[].class);
		logger.info("physicians List Responce ::"+physiciansList.length);
		
		Assert.assertEquals(physiciansList[0].getId(), "1525","ID should be same. ");
		Assert.assertEquals(physiciansList[0].getAccountType(), "Physician"," Account Type should be same. ");
		Assert.assertEquals(physiciansList[0].getEmail(), "automation@digisight.net","Email should be same. ");
		Assert.assertEquals(physiciansList[0].getLastName(), "test","Last Name should be same. ");
		Assert.assertEquals(physiciansList[0].getPracticeId(), "153","Practice Id should be same. ");
		
	}
}
