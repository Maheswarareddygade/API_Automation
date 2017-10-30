package com.digisight.platform.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetTextFileData  extends BaseApiTest{
	
	/**
	 * @author Mahesh Reddy
	 *
	 */
	
	static BaseApiTest baseApiTest =new BaseApiTest();
	public static void main(String[] args) {
		GetTextFileData.getTextdata("Message2");
		System.out.println("Tets :"+baseApiTest.readGetPropValue("testingEnv"));
	}
	
	public static String getTextdata(String fileName){
	BufferedReader br = null;
	String responceBody = "" ;
	String path = System.getProperty("user.dir");
	File fXmlFile = new File(path + "\\src\\test\\resources\\" + fileName+".txt");
		try {
	
			String sCurrentLine;
			System.out.println("Path :"+fXmlFile.getAbsolutePath());
			br = new BufferedReader(new FileReader(fXmlFile));
	
			while ((sCurrentLine = br.readLine()) != null) {
				
				responceBody = responceBody.concat(sCurrentLine);
				}
			System.out.println("Responce text :"+responceBody);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return responceBody;
	}

}

