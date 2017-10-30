package com.digisight.platform.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.google.common.net.MediaType;
import com.google.gson.stream.JsonReader;

public class BaseApiTest {
	
	/**
	 * @author Mahesh Reddy
	 * Created Date: 24-10-07
	 * 
	 * 
	 * @modified by 
	 */ 
	
	
	private static UiLogger _logger = UiLogger.getLogger(BaseApiTest.class);
	String responseMessage;
	String jsonResponse = null;

	
	public Map<String, String> getSensorValue(String key,String value) {
	    Map<String,String> sensorValues = new HashMap<String,String>();
	    sensorValues.put(key,value);
	    return sensorValues;
	}
	
	/**
	 * @param url
	 * @param payload
	 * @param requestFormate
	 * @return Response
	 * @throws IOException
	 *             Method is used to get the Response of post request.
	 */
	public String httpRequestPost(String url, String payload, String requestFormate, HashMap<String, Object> headerMap,
			int statusCode) {
		
		_logger.info("------------POST CALL EXECUTION STARTED-----------------------\n");
		HttpPost request = null;
		try {
			HttpClient getHttpClient = HttpClientBuilder.create().build();
			request = new HttpPost(url);
			_logger.info("API URL  :" + url);
			StringEntity input = new StringEntity(payload);
			input.setContentType(requestFormate);
			request.setEntity(input);
			_logger.info("Request body :" + input);
			Iterator<String> keySetIterator = headerMap.keySet().iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				request.setHeader((String) key.toString(), headerMap.get(key).toString());
				_logger.info("API Hedder Key :" + key.toString() + " Value :" + headerMap.get(key));
			}

			_logger.info("Post method execution...::"+url);
			HttpResponse response = getHttpClient.execute(request);
			_logger.info("Response of  ::" + response );
			_logger.info(response.toString());
			Assert.assertEquals(response.getStatusLine().getStatusCode(), statusCode, "API not executed successfully.");
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			while ((responseMessage = br.readLine()) != null) {
				_logger.info(responseMessage);
				jsonResponse = responseMessage;
			}
		} catch (Exception e) {
			_logger.info("Fail to execute post request  :" + e.getMessage());
		}

		finally {
			request.releaseConnection();
			_logger.info("Release post conncetion.");
		}
		_logger.info("API Response :" + jsonResponse);
		_logger.info("------------POST CALL EXECUTION ENDED-----------------------\n");
		return jsonResponse;
	}
	
	
	/**
	 * @param url
	 * @param payload
	 * @param requestFormate
	 * @return Response
	 * @throws IOException
	 *             Method is used to get the Response of post request.
	 */
	public String httpRequestPost(String url, String payload, String requestFormate, HashMap<String, Object> headerMap,String statusCode) {
		HttpPost request = null;
		_logger.info("------------POST CALL EXECUTION STARTED-----------------------\n");
		try {
			HttpClient getHttpClient = HttpClientBuilder.create().build();
			request = new HttpPost(url);
			_logger.info("API URL  :" + url);
			StringEntity input = new StringEntity(payload);
			input.setContentType(requestFormate);
			request.setEntity(input);
			_logger.info("Request body :" + input);
			Iterator<String> keySetIterator = headerMap.keySet().iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				request.setHeader((String) key.toString(), headerMap.get(key).toString());
				_logger.info("API Hedder Key :" + key.toString() + " Value :" + headerMap.get(key));
			}

			_logger.info("Post method execution...::"+url);
			HttpResponse response = getHttpClient.execute(request);
			_logger.info("Response of  ::" + response);
			_logger.info(response.toString());
			Assert.assertEquals(response.getStatusLine().getStatusCode(), Integer.parseInt(statusCode), "API not executed successfully.");
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			while ((responseMessage = br.readLine()) != null) {
				_logger.info(responseMessage);
				jsonResponse =jsonResponse.concat(responseMessage);
			}
		} catch (Exception e) {
			_logger.info("Fail to execute post request  :" + e.getMessage());
		}

		finally {
			request.releaseConnection();
			_logger.info("Release post conncetion.");
		}
		_logger.info("API Response :" + jsonResponse);
		
		_logger.info("------------POST CALL EXECUTION ENDED-----------------------\n");
		return jsonResponse;
	}


	/**
	 * @param url
	 * @param payload
	 * @param requestFormate
	 * @return Response
	 * @throws IOException
	 *             Method is used to get the Response of post request.
	 */
	public String httpRequestGet(String url, HashMap<String, Object> headerMap, int statusCode) {

		_logger.info("------------GET CALL EXECUTION STARTED-----------------------\n");
		HttpGet getRequest = null;
		try {
			HttpClient putHttpClient = HttpClientBuilder.create().build();
			getRequest = new HttpGet(url);
			_logger.info("API URL  :" + url);
			Iterator<String> keySetIterator = headerMap.keySet().iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				getRequest.addHeader(key.toString(), headerMap.get(key).toString());
				_logger.info("API Hedder Key :" + key.toString() + " Value :" + headerMap.get(key));
			}
			_logger.info(" Get method execution....::"+url);
			HttpResponse response = putHttpClient.execute(getRequest);
			Assert.assertEquals(response.getStatusLine().getStatusCode(), statusCode, "API not executed successfully.");

			_logger.info("Response of  ::" + response);
			_logger.info(response.toString());

			if (response.getEntity() == null) {
				Assert.assertTrue(false, "Get method failed :" + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			while ((responseMessage = br.readLine()) != null) {
				_logger.info(responseMessage);
				jsonResponse = responseMessage;
			}
		} catch (Exception e) {
			_logger.info("Fail to execute get request  :" + e.getMessage());
		} finally {
			_logger.info("Release get conncetion.");
			getRequest.releaseConnection();
		}
		_logger.info("API Response :" + jsonResponse);
		_logger.info("------------GET CALL EXECUTION ENDED-----------------------\n");
		return jsonResponse;
	}
	
	
	/**
	 * @param url
	 * @param payload
	 * @param requestFormate
	 * @return Response
	 * @throws IOException
	 *             Method is used to get the Response of post request.
	 */
	public String httpRequestDelete(String url, String requestFormate, HashMap<String, Object> headerMap,int statusCode) {
		HttpDelete deleteRequest = null;
		_logger.info("------------DELETE CALL EXECUTION STARTED-----------------------\n");
		try {
			HttpClient deleteHttpClient = HttpClientBuilder.create().build();
			deleteRequest = new HttpDelete(url);
			_logger.info("API URL                     :" + url);
			Iterator<String> keySetIterator = headerMap.keySet().iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				deleteRequest.addHeader(key.toString(), headerMap.get(key).toString());
				_logger.info("API Hedder Key :" + key.toString() + " Value :" + headerMap.get(key));
			}

			_logger.info("Delete method execution....::"+url);
			HttpResponse response = deleteHttpClient.execute(deleteRequest);
			_logger.info("Response of  ::" + response);
			_logger.info(response.toString());
			if (response.getEntity() == null) {
				Assert.assertTrue(false, "Get method failed :" + response.getStatusLine().getStatusCode());
			}
			Assert.assertEquals(response.getStatusLine().getStatusCode(), statusCode, "API not executed successfully.");
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			while ((responseMessage = br.readLine()) != null) {
				_logger.info(responseMessage);
				jsonResponse = responseMessage.concat(responseMessage);
			}
		} catch (Exception e) {
			_logger.info("Fail to execute delete request  :" + e.getMessage());
		} finally {
			deleteRequest.releaseConnection();
			_logger.info("Release post conncetion.");
		}
		_logger.info("API Response :" + jsonResponse);
		_logger.info("------------DELETE CALL EXECUTION ENDED-----------------------\n");
		return jsonResponse;
	}

	/**
	 * @param url
	 * @param payload
	 * @param requestFormate
	 * @return Response
	 * @throws IOException
	 *             method is used to get the Response of post request.
	 */
	public String httpRequestPut(String url, String payload, String requestFormate, HashMap<String, Object> headerMap,
			int statusCode) {
		HttpPut putRequest = null;
		_logger.info("------------PUT CALL EXECUTION STARTED-----------------------\n");
		try {
			HttpClient putHttpClient = HttpClientBuilder.create().build();
			putRequest = new HttpPut(url);
			_logger.info("API URL  :" + url);
			StringEntity input = new StringEntity(payload);
			input.setContentType(requestFormate);
			putRequest.setEntity(input);
			_logger.info("Request body :" + input);
			Iterator<String> keySetIterator = headerMap.keySet().iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				putRequest.addHeader(key.toString(), headerMap.get(key).toString());
				_logger.info("API Hedder Key :" + key.toString() + " Value :" + headerMap.get(key));
			}

			_logger.info("Put Method execution.....:"+url);
			HttpResponse response = putHttpClient.execute(putRequest);
			if (response.getEntity() == null) {
				Assert.assertTrue(false, "Put method failed :" + response.getStatusLine().getStatusCode());
			}
			_logger.info("Response of  ::" + response);
			_logger.info(response.toString());
			Assert.assertEquals(response.getStatusLine().getStatusCode(), statusCode, "API not executed successfully.");
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			while ((responseMessage = br.readLine()) != null) {
				_logger.info(responseMessage);
				jsonResponse = responseMessage.concat(responseMessage);
			}
		} catch (Exception e) {
			_logger.info("Fail to execute put request  :" + e.getMessage());
		} finally {
			putRequest.releaseConnection();
			_logger.info("Release post conncetion.");
		}

		_logger.info("API Response :" + jsonResponse);
		_logger.info("------------PUT CALL EXECUTION ENDED-----------------------\n");
		return jsonResponse;
	}

	/**
	 * @param response
	 * @return Json reader Method is used to return a json reader.
	 */
	public JsonReader getJsonReader(String response) {
		JsonReader reader = new JsonReader(new StringReader(response));
		reader.setLenient(true);
		return reader;

	}

	/**
	 * @param source
	 * @param node
	 * @param tagName
	 * @param attribute
	 * @param index
	 * @return NamedNodeMap
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public NamedNodeMap getAttributeValues(String sourec, String tagName) throws IOException {
		NamedNodeMap namedNodeMap = null;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(sourec));
			Document document = db.parse(is);
			NodeList nodeList = document.getElementsByTagName("Field");
			for (int x = 0, size = nodeList.getLength(); x < size; x++) {
				nodeList.item(x).getAttributes();
			}
		} catch (Exception e) {
			_logger.info("Unable to get the values");
			return namedNodeMap;
		}
		return namedNodeMap;

	}

	/**
	 * @param source
	 * @param node
	 * @param tagName
	 * @param attribute
	 * @param index
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public String getAttributeName(String source, String node, String tagName, String attribute, int index)
			throws ParserConfigurationException, SAXException, IOException {
		String xmlRecords = source;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlRecords));

			Document doc = db.parse(is);
			NodeList nodes = doc.getElementsByTagName(node);

			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				NodeList name = element.getElementsByTagName(tagName);
				Element line = (Element) name.item(index);
				_logger.info("Name: " + line.getAttribute(attribute));
			}
			return xmlRecords;
		} catch (Exception e) {
			_logger.info("Fail get attribute name: " + e.getMessage());
			return xmlRecords;
		}

	}

	/**
	 * @param source
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public Document creatDoc(String source) throws SAXException, IOException, ParserConfigurationException {
		Document doc = null;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(source));
			doc = db.parse(is);
			return doc;
		} catch (Exception e) {
			_logger.info("Fail to create doc : " + e.getMessage());
			return doc;
		}
	}

	/**
	 * @param document
	 * @param tagname
	 * @param attributeName
	 * @return
	 */
	public String matchingCount(Document document, String tagname, String attributeName) {
		NodeList nodeList = document.getElementsByTagName(tagname);
		String xval = null;
		for (int x = 0, size = nodeList.getLength(); x < size; x++) {
			xval = nodeList.item(x).getAttributes().getNamedItem(attributeName).getNodeValue();
		}
		return xval;
	}

	/**
	 * @return MediaType Method is used to set the request body type. Method is
	 *         used to send header to request.
	 */
	public MediaType getXMLHeader() {
		MediaType mediaType = MediaType.parse("application/xml");
		return mediaType;

	}

	/**
	 * @return String Method is used to set the request body type.
	 */
	public String getJSONHedder() {
		String mediaType = MediaType.parse("application/json").toString();
		_logger.info("Adding JSON Header");
		return mediaType;

	}
	
	public String getEnvironment() {
		return jsonResponse;
	}

	
	/**
	 * @param jsonFile
	 * @return Request body
	 */
	public String getEnvironment(String path) {
		BufferedReader br = null;
		String requestBody = "";
		File envFile = new File(path);
		_logger.info("Get endpoints from endpoints json file..");
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(envFile));
			while ((sCurrentLine = br.readLine()) != null) {
				requestBody = requestBody.concat(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return requestBody;

	}
	
	/**
	 * @param jsonFile
	 * @return Request body
	 */
	public String getPayloads(String jsonFile) {
		BufferedReader br = null;
		String requestBody = "";
		String path = System.getProperty("user.dir");
		File fXmlFile = new File(path + File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+""+jsonFile);
		_logger.info("Get endpoints from endpoints json file..");
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fXmlFile));
			while ((sCurrentLine = br.readLine()) != null) {
				requestBody = requestBody.concat(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return requestBody;

	}
	
	
	/**
	 * @param jsonFile
	 * @return Request body
	 */
	public String getJsonBody(String jsonFile) {
		BufferedReader br = null;
		String requestBody = "";
		String path = System.getProperty("user.dir");
		File fXmlFile = new File(path + File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Payloads"+File.separator+""+jsonFile+".json");
		_logger.info("Get endpoints from endpoints json file..");
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fXmlFile));
			while ((sCurrentLine = br.readLine()) != null) {
				requestBody = requestBody.concat(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return requestBody;

	}


	/**
	 * @param xmlFileName
	 * @return String of xml Method used send xml request
	 */
	public String getRequestXml(String path) {
		String requestxml = null;
		try {
			
			File fXmlFile = new File(path);
			_logger.info("Servic path :" + path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			requestxml = writer.toString();
			return requestxml;

		} catch (Exception e) {
			_logger.info("Get xml reading failed.");
		}
		return requestxml;

	}
	
	
	public String readGetPropValue(String envTest){

		Properties prop = new Properties();
		InputStream input = null;
		String path = System.getProperty("user.dir");
		File fXmlFile = new File(path + File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testSettings.properties");
		_logger.info("Get endpoints from endpoints test.properties file..");
		String value=null;
		try {

			input = new FileInputStream(fXmlFile);
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			value=prop.getProperty(envTest);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return value;
	}

}

