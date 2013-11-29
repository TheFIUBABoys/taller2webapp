package com.fiuba.taller.communication.news;

import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import com.fiuba.taller.communication.CommunicationResponse;

import wtp.LoginAPIHelperStub;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class NewsService {
	
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
	
	
	@GET
	@Path("searchnewsbywords")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchNewsByWords(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
		
	}
	
	
	@GET
	@Path("searchnewsbyuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchNewsByUser(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
	@GET
	@Path("news")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getNews(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("createnew")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNew(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("editnew")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editNew(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("deletenew")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteNew(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
}