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

import com.fiuba.taller.chat.requests.ChatRequest;
import com.fiuba.taller.chat.requests.CreateChatRequest;
import com.fiuba.taller.chat.requests.HistoryMessageRequest;
import com.fiuba.taller.chat.requests.SendMessageRequest;
import com.fiuba.taller.chat.requests.UpdateChatRequest;
import com.fiuba.taller.communication.CommunicationResponse;
import com.fiuba.taller.security.SecurityResponse;

import wtp.LoginAPIHelperStub;
import wtp.MessagerStub;
import wtp.MessagerStub.GetHistoryChatResponse;


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
	
	private Response buildError(String service) {
        SecurityResponse response = new SecurityResponse();

        response.setSuccess(false);
        response.setReason("El servicio de " + service + " no está disponible.");

        return Response.status(509).entity(response).build();
	}
	
	@POST
	@Path("createchat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createChat(@CookieParam("authToken") String authToken, CreateChatRequest request) throws ParserConfigurationException, SAXException, IOException {
		//Init 
		CreateChatResponse response = new CreateChatResponse();
		
		MessagerStub api = new MessagerStub();
		MessagerStub.CreateChat chatRequest = new MessagerStub.CreateChat();
		MessagerStub.CreateChatResponse wsResponse = new MessagerStub.CreateChatResponse();
		
		// Armo la WSRequest
		chatRequest.setScopeId(request.getId_ambito());
		chatRequest.setMember(request.getUsername()); 
		
		// Hacer el request
        try {
		    wsResponse = api.createChat(chatRequest);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("crear chat");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
		
	}
	
	
	@GET
	@Path("updatechat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateChat(@CookieParam("authToken") String authToken, UpdateChatRequest request) throws ParserConfigurationException, SAXException, IOException {
		CreateChatResponse response = new CreateChatResponse();
		
		MessagerStub api = new MessagerStub();
		MessagerStub.UpdateChat chatRequest = new MessagerStub.UpdateChat();
		MessagerStub.UpdateChatResponse wsResponse = new MessagerStub.UpdateChatResponse();
		
		// Armo la WSRequest
		chatRequest.setChatId(request.getId_chat());
		chatRequest.setIdMiembro(request.getId_miembro());
		chatRequest.setLastCallTimestamp(request.getLastCallTimestamp());
		
		// Hacer el request
        try {
		    wsResponse = api.updateChat(chatRequest);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("updateChat");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@GET
	@Path("gethistorychat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getHistoryChat(@CookieParam("authToken") String authToken, HistoryMessageRequest request) throws ParserConfigurationException, SAXException, IOException {
		CreateChatResponse response = new CreateChatResponse();
		
		MessagerStub api = new MessagerStub();
		MessagerStub.GetHistoryChat chatRequest = new MessagerStub.GetHistoryChat();
		MessagerStub.GetHistoryChatResponse wsResponse = new MessagerStub.GetHistoryChatResponse();
		
		// Armo la WSRequest
		chatRequest.setChatId(request.getId_chat());
		chatRequest.setIdMiembro(request.getId_member());
		
		// Hacer el request
        try {
		    wsResponse = api.getHistoryChat(chatRequest);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("getHistoryChat");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
	@GET
	@Path("getmembers")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMembers(@CookieParam("authToken") String authToken, ChatRequest request) throws ParserConfigurationException, SAXException, IOException {
		CreateChatResponse response = new CreateChatResponse();
		
		MessagerStub api = new MessagerStub();
		MessagerStub.GetMembers chatRequest = new MessagerStub.GetMembers();
		MessagerStub.GetMembersResponse wsResponse = new MessagerStub.GetMembersResponse();
		
		// Armo la WSRequest
		chatRequest.setChatId(request.getId_chat());
		
		// Hacer el request
        try {
		    wsResponse = api.getMembers(chatRequest);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("getMembers");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("sendmessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendMessage(@CookieParam("authToken") String authToken, SendMessageRequest request) throws ParserConfigurationException, SAXException, IOException {
		CreateChatResponse response = new CreateChatResponse();
		
		MessagerStub api = new MessagerStub();
		MessagerStub.SendMessage chatRequest = new MessagerStub.SendMessage();
		MessagerStub.SendMessageResponse wsResponse = new MessagerStub.SendMessageResponse();
		
		// Armo la WSRequest
		chatRequest.setChatId(request.getId_chat());
		chatRequest.setMember(request.getMember());
		chatRequest.setMessage(request.getMessage());
		
		// Hacer el request
        try {
		    wsResponse = api.sendMessage(chatRequest);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("sendMessage");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logOut(@CookieParam("authToken") String authToken, HistoryMessageRequest request) throws ParserConfigurationException, SAXException, IOException {
		CreateChatResponse response = new CreateChatResponse();
		
		MessagerStub api = new MessagerStub();
		MessagerStub.Logout chatRequest = new MessagerStub.Logout();
		MessagerStub.LogoutResponse wsResponse = new MessagerStub.LogoutResponse();
		
		// Armo la WSRequest
		chatRequest.setChatId(request.getId_chat());
		chatRequest.setIdMiembro(request.getId_member());
		
		// Hacer el request
        try {
		    wsResponse = api.logout(chatRequest);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("logOut");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
}