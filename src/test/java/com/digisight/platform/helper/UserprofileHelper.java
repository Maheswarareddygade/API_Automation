package com.digisight.platform.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.digisight.platform.ehr.Address;
import com.digisight.platform.ehr.Assigner;
import com.digisight.platform.ehr.Coding;
import com.digisight.platform.ehr.EhrPayload;
import com.digisight.platform.ehr.EhrPojo;
import com.digisight.platform.ehr.Identifier;
import com.digisight.platform.ehr.Name;
import com.digisight.platform.ehr.Telecom;
import com.digisight.platform.ehr.Type;
import com.digisight.platform.userInfo.Authorization;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserprofileHelper {

	/**
	 * @author Mahesh Reddy Created Date: 23-10-07
	 *
	 */
	static ObjectMapper mapper = new ObjectMapper();

	public static String authorization(String grantType, String username, String password, String appVersion)
			throws JsonGenerationException, JsonMappingException, IOException {
		Authorization authorization = new Authorization();

		authorization.setGrantType(grantType);
		authorization.setUsername(username);
		authorization.setPassword(password);
		authorization.setAppVersion(appVersion);
		authorization.setAppId("");
		authorization.setAppName("");
		authorization.setClientId("");
		authorization.setDeviceType("");
		authorization.setDeviceOS("");
		authorization.setDeviceName("");

		String authorizationJsonInString = mapper.writeValueAsString(authorization);
		return authorizationJsonInString;
	}

	public static String ehr(String accountName, String accountPassword)
			throws JsonGenerationException, JsonMappingException, IOException {
		EhrPojo ehrPojo = new EhrPojo();

		ehrPojo.setAccountName(accountName);
		ehrPojo.setAccountPassword(accountPassword);

		String authorizationJsonInString = mapper.writeValueAsString(ehrPojo);
		return authorizationJsonInString;
	}
	
	public static String ehrPaload()
			throws JsonGenerationException, JsonMappingException, IOException {
		 
		ArrayList<Name> nameList=new  ArrayList<Name>();
		ArrayList<Telecom> telecomList=new  ArrayList<Telecom>();
		ArrayList<Address> addressList=new  ArrayList<Address>();
		ArrayList<Identifier> identifierList=new  ArrayList<Identifier>();
		ArrayList<Coding> codingList=new  ArrayList<Coding>();
		
		EhrPayload ehrPayload = new EhrPayload();
		
		Name name1=new Name();
		name1.setFamily(Arrays.asList("arun1223"));
		name1.setGiven(Arrays.asList("ehr1299"));
		nameList.add(name1);
		ehrPayload.setName(nameList);
		
		ehrPayload.setResourceType("Patient");
		ehrPayload.setGender("female");
		ehrPayload.setBirthDate("1980-1-3");
		
		Telecom telecom=new Telecom();
		telecom.setSystem("phone");
		telecom.setValue("4084084088");
		telecom.setUse("home");
		telecomList.add(telecom);
		ehrPayload.setTelecom(telecomList);
		
		Address address=new Address();
		address.setUse("home");
		address.setCity("San Francisco");
		address.setCountry("USA");
		address.setState("CA");
		address.setPostalCode("95014");
		addressList.add(address);
		ehrPayload.setAddress(addressList);
		
		Identifier identifier=new Identifier();
		identifier.setUse("usual");
		identifier.setValue("031810467");
		identifier.setSystem("URN:OID:1.2.3.6");
		
		Assigner assigner=new Assigner();
		assigner.setDisplay("Punya EHR Testing");
		identifier.setAssigner(assigner);
		
		Coding coding=new Coding();
		coding.setCode("MR");
		coding.setSystem("http://hl7.org/fhir/v2/0203");
		codingList.add(coding);
		
		Type  type=new Type();
		type.setCoding(codingList);
		identifier.setType(type);
		identifierList.add(identifier);
		ehrPayload.setIdentifier(identifierList);

		String authorizationJsonInString = mapper.writeValueAsString(ehrPayload);
		return authorizationJsonInString;
	}
	
	public static void main(String args) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("EHR Payload :"+UserprofileHelper.ehrPaload());
	}
	

}
