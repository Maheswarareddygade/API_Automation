package com.digisight.platform.dp;
import java.io.File;
import org.testng.annotations.DataProvider;
import com.digisight.platform.utility.BaseApiTest;
import com.digisight.platform.utility.EndpontsJson;
import com.google.gson.Gson;

public class UserServiceDP {
	
	/**
	 * @author Mahesh Reddy
	 * Created Date: 23-10-07
	 *
	 */  
	
	static File currentDirFile = new File("");
	static BaseApiTest baseTest = new BaseApiTest();
	static Gson gson = new Gson();
	static String helper = currentDirFile.getAbsolutePath();
	static String path=helper.concat(File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Env"+File.separator+""+baseTest.readGetPropValue("testingEnv")+""+File.separator+"endpoints.json");
	static EndpontsJson jsonRes = gson.fromJson(baseTest.getEnvironment(path), EndpontsJson.class);
	static String xmlPath=helper.concat(File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator);
	
	
	@DataProvider
	public static Object[][] authorization() {
         
		String[] authorization = { jsonRes.getEndpoints().getUserApi().concat("gw/api/oauth/token"),"Bearer","password", "automation@digisight.net","Test1234","1.8.1"};
		Object[][] dataSet = new Object[][] { authorization };
		return dataSet;
	}
	
	
	@DataProvider
	public static Object[][] userInfo() {
         
		String[] userInfo = { jsonRes.getEndpoints().getUserApi().concat("gw/paxos/getUser"),"","automation", "manchester","automation@digisight.net","665","India","153","153","1525","10788","153","automation@digisight.net"};
		Object[][] dataSet = new Object[][] { userInfo };
		return dataSet;
	}

	
	@DataProvider
	public static Object[][] filterLacation() {
         
		String[] lacation = { jsonRes.getEndpoints().getUserApi().concat("gw/api/filterLocations"),"0","BANGALORE","667"};
		Object[][] dataSet = new Object[][] { lacation };
		return dataSet;
	}

	@DataProvider
	public static Object[][] ehrInfo() {
        
		String[] ehrInfo = { jsonRes.getEndpoints().getEhrApi().concat("/Integration/Authenticate"),"qa@digisight.net","Password@1","Bearer",""};
		Object[][] dataSet = new Object[][] { ehrInfo };
		return dataSet;
	}
	
	
	@DataProvider
	public static Object[][] createEncounter() {
        
		String[] ehrInfo = { jsonRes.getEndpoints().getUserApi().concat("gw/paxos/")};
		Object[][] dataSet = new Object[][] { ehrInfo };
		return dataSet;
	}
	
	
	@DataProvider
	public static Object[][] locationList() {
        
		String[] ehrInfo = { jsonRes.getEndpoints().getUserApi().concat("gw/api/locations"),"665","153","India"};
		Object[][] dataSet = new Object[][] { ehrInfo };
		return dataSet;
	}
	
	
	@DataProvider
	public static Object[][] patientList() {
        
		String[] ehrInfo = { jsonRes.getEndpoints().getUserApi().concat("gw/paxos/")};
		Object[][] dataSet = new Object[][] { ehrInfo };
		return dataSet;
	}
	
	
	@DataProvider
	public static Object[][] practicesList() {
        
		String[] ehrInfo = { jsonRes.getEndpoints().getUserApi().concat("gw/api/practices")};
		Object[][] dataSet = new Object[][] { ehrInfo };
		return dataSet;
	}
	
	@DataProvider
	public static Object[][] physiciansList() {
        
		String[] ehrInfo = { jsonRes.getEndpoints().getUserApi().concat("gw/api/physicians")};
		Object[][] dataSet = new Object[][] { ehrInfo };
		return dataSet;
	}
}
