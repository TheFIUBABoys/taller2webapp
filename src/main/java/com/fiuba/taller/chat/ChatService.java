package com.fiuba.taller.chat;

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
public class ChatService {
	
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
	
	
	@POST
	@Path("createchat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createChat(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CreateChatResponse response = new CreateChatResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
		
	}
	
	
	@GET
	@Path("updatechat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateChat(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		UpdateChatResponse response = new UpdateChatResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("gethistorychat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getHistoryChat(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		GetHistoryResponse response = new GetHistoryResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
	@GET
	@Path("getmembers")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMembers(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		GetMembersResponse response = new GetMembersResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("sendmessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendMessage(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		SendMessageResponse response = new SendMessageResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
}