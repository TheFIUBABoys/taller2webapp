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
import com.fiuba.taller.communication.news.requests.NewsDelete;
import com.fiuba.taller.communication.news.requests.NewsEdit;
import com.fiuba.taller.communication.news.requests.NewsCreate;
import com.fiuba.taller.communication.news.requests.NewsSearchByUser;
import com.fiuba.taller.communication.news.requests.NewsSearchByWords;
import com.fiuba.taller.communication.news.requests.NewsShow;
import com.fiuba.taller.communication.wall.requests.EventsSearchByWords;
import com.fiuba.taller.security.SecurityResponse;

import wtp.LoginAPIHelperStub;
import wtp.ServiceStub;

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
	
	private Response buildError(String service) {
        SecurityResponse response = new SecurityResponse();

        response.setSuccess(false);
        response.setReason("El servicio de " + service + " no está disponible.");

        return Response.status(509).entity(response).build();
	}
	
	
	@GET
	@Path("searchnewsbywords")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchNewsByWords(@CookieParam("authToken") String authToken, NewsSearchByWords request) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		
		ServiceStub api = new ServiceStub();
		ServiceStub.BusquedaNoticiasPorPalabras communicationRequst = new ServiceStub.BusquedaNoticiasPorPalabras();
		ServiceStub.BusquedaNoticiasPorPalabrasResponse wsResponse = new ServiceStub.BusquedaNoticiasPorPalabrasResponse();
		
		// Armo la WSRequest
		communicationRequst.setId_ambito(request.getId_ambito());
		communicationRequst.setId_cartelera(request.getId_cartelera());
		communicationRequst.setId_usuario(request.getUsername());
		communicationRequst.setPalabras(request.getWords());

		// Hacer el request
        try {
		    wsResponse = api.busquedaNoticiasPorPalabras(communicationRequst);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("Busqueda noticias por palabras");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
	@GET
	@Path("searchnewsbyuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchNewsByUser(@CookieParam("authToken") String authToken, NewsSearchByUser request) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		
		ServiceStub api = new ServiceStub();
		ServiceStub.BusquedaNoticiasPorAutor communicationRequst = new ServiceStub.BusquedaNoticiasPorAutor();
		ServiceStub.BusquedaNoticiasPorAutorResponse wsResponse = new ServiceStub.BusquedaNoticiasPorAutorResponse();
		
		// Armo la WSRequest
		communicationRequst.setId_ambito(request.getId_ambito());
		communicationRequst.setId_cartelera(request.getId_cartelera());
		communicationRequst.setId_usuario(request.getUsername());
		communicationRequst.setId_usuario_autor(request.getAuthor());
		
		// Hacer el request
        try {
		    wsResponse = api.busquedaNoticiasPorAutor(communicationRequst);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("Busqueda noticias por autor");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
	@GET
	@Path("news")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getNews(@CookieParam("authToken") String authToken, NewsShow request) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		
		ServiceStub api = new ServiceStub();
		ServiceStub.MostrarNoticia communicationRequst = new ServiceStub.MostrarNoticia();
		ServiceStub.MostrarNoticiaResponse wsResponse = new ServiceStub.MostrarNoticiaResponse();
		
		// Armo la WSRequest
		communicationRequst.setId_ambito(request.getId_ambito());
		communicationRequst.setId_cartelera(request.getId_cartelera());
		communicationRequst.setId_usuario(request.getUsername());
		communicationRequst.setId_noticia(request.getId_noticia());

		// Hacer el request
        try {
		    wsResponse = api.mostrarNoticia(communicationRequst);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("Mostrar noticia");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("createnew")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNew(@CookieParam("authToken") String authToken, NewsCreate request) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		
		ServiceStub api = new ServiceStub();
		ServiceStub.PublicarNoticia communicationRequst = new ServiceStub.PublicarNoticia();
		ServiceStub.PublicarNoticiaResponse wsResponse = new ServiceStub.PublicarNoticiaResponse();
		
		// Armo la WSRequest
		communicationRequst.setContenido(request.getContent());
		communicationRequst.setId_ambito(request.getId_ambito());
		communicationRequst.setId_cartelera(request.getId_cartelera());
		communicationRequst.setId_usuario(request.getUsername());
		communicationRequst.setTitulo(request.getTitle());
		
		// Hacer el request
        try {
		    wsResponse = api.publicarNoticia(communicationRequst);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("Mostrar noticia");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("editnew")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editNew(@CookieParam("authToken") String authToken, NewsEdit request) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		
		ServiceStub api = new ServiceStub();
		ServiceStub.EditarNoticia communicationRequst = new ServiceStub.EditarNoticia();
		ServiceStub.EditarNoticiaResponse wsResponse = new ServiceStub.EditarNoticiaResponse();
		
		// Armo la WSRequest
		communicationRequst.setContenido(request.getContent());
		communicationRequst.setId_ambito(request.getId_ambito());
		communicationRequst.setId_cartelera(request.getId_cartelera());
		communicationRequst.setId_noticia(request.getId_noticia());
		communicationRequst.setId_usuario(request.getUsername());
		communicationRequst.setTitulo(request.getTitle());

		// Hacer el request
        try {
		    wsResponse = api.editarNoticia(communicationRequst);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("editar noticia");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Path("deletenew")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteNew(@CookieParam("authToken") String authToken, NewsDelete request) throws ParserConfigurationException, SAXException, IOException {
		CommunicationResponse response = new CommunicationResponse();
		
		ServiceStub api = new ServiceStub();
		ServiceStub.EliminarNoticia communicationRequst = new ServiceStub.EliminarNoticia();
		ServiceStub.EliminarNoticiaResponse wsResponse = new ServiceStub.EliminarNoticiaResponse();
		
		// Armo la WSRequest
		communicationRequst.setId_ambito(request.getId_ambito());
		communicationRequst.setId_cartelera(request.getId_cartelera());
		communicationRequst.setId_noticia(request.getId_noticia());
		communicationRequst.setId_usuario(request.getUsername());

		// Hacer el request
        try {
		    wsResponse = api.eliminarNoticia(communicationRequst);
        } catch (AxisFault error) {
            System.out.println(error.getReason());
            return buildError("eliminar noticia");
        }
		
		response.setSuccess(true);
		response.setReason("Implementación de prueba, esto se debe implementar");
		return Response.ok().entity(response).build();
	}
	
	
}