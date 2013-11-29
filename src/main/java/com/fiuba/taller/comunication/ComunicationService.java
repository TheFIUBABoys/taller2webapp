package com.fiuba.taller.comunication;

import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;

import javax.ws.rs.CookieParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.AxisFault;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import wtp.LoginAPIHelperStub;


@Path("/securityservice")
@Produces(MediaType.APPLICATION_JSON)
public class ComunicationService {
	
	private Document getDoc(String xml) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document doc = dBuilder.parse(is);
		doc.getDocumentElement().normalize();
		
		return doc;
	} 
	
	private Node getNode(Document doc, String nodeName){
		
		return doc.getElementsByTagName(nodeName).item(0);
	}
	
	private String getFirstElementValue(Node node, String eName){
		
		Element elem = (Element) node;
		
		return elem.getElementsByTagName("success").item(0).getTextContent();
	}
	
	
	
	public Response createSection(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		ComunicationResponse response = new ComunicationResponse();

		LoginAPIHelperStub api = new LoginAPIHelperStub();  
		LoginAPIHelperStub.IsTokenValid comunicationRequest = new LoginAPIHelperStub.IsTokenValid();
		LoginAPIHelperStub.IsTokenValidResponse wsResponse = new LoginAPIHelperStub.IsTokenValidResponse();

		comunicationRequest.setAuthToken(authToken);

		// Hacer el request
		wsResponse = api.isTokenValid(comunicationRequest);

		// Parsear el response
		Document doc = getDoc(wsResponse.get_return());
		Node node = getNode(doc, "response");

		String success = getFirstElementValue( node, "success");

		if (success == "1"){

			return Response.ok()
					.build();

		}else{
			response.setSuccess(false);
			response.setReason(getFirstElementValue(node, "reason"));
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}
	
}