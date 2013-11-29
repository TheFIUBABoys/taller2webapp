package com.fiuba.taller.communication.forum;

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
public class ForumService {
	
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
	@Path("createsection")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSection(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
		
	}
	
	
	@POST
	@Path("editsection")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editSection(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("deletesection")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSection(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
	@POST
	@Path("createsubforum")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSubforum(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("editsubforum")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editSubforum(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("movesubforum")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response moveSubforum(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("deletesubforum")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSubforum(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("createthread")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createThread(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("editthread")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editThread(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("deletethread")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteThread(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("stickthread")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response stickThread(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("unstickthread")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response unstickThread(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("createmessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMessage(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("editmessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editMessage(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("deletemessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMessage(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("forumindex")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getForumIndex(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("subforumindex")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSubforumIndex(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("threadindex")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getThreadIndex(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("message")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMessage(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("searchmessagebyword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchMessageByWords(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("searchmessagebyuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchMessageByUser(@CookieParam("authToken") String authToken) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
}