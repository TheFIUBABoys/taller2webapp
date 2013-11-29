package com.fiuba.taller.communication.news.requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Form;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forum-request")
public class NewsSearchByWords {

	private String username;
	private Integer id_ambito;
	private Integer id_cartelera;
	private List<String> words;
	
    public NewsSearchByWords(){}
	
    public NewsSearchByWords(String username,Integer id_ambito)
    {
        super();
        this.setUsername(username);
        this.setId_ambito(id_ambito);
    }

    private String toReadable(String keyValSeparator, String propSeparator) {
        String result = "";
        String k = keyValSeparator;
        String p = propSeparator;

        result += "username" + k + username + p;
        result += "id_ambito" + k + id_ambito + p;
        result += "id_cartelera" + k + id_cartelera + p;
        result += "words" + k + words + p;

        return result;
    }

    @Override
    public String toString(){
        return toReadable("=", "&");
    }

    public String toJSON(){
        return "{" + toReadable(": ", ", ") + "}";
    }

    public Form toForm(){
        Form dataAsForm = new Form();

        dataAsForm.param("username", username);
        dataAsForm.param("id_ambito", Integer.toString(id_ambito));
        dataAsForm.param("id_cartelera", Integer.toString(id_cartelera));
        // FALTA HACER ESTO PARA LA LISTA
        
        return dataAsForm;
    }

    public Map<String, String> toMap(){
        Map<String, String> dataAsMap = new HashMap<String, String>();

        dataAsMap.put("username", username);
        dataAsMap.put("id_ambito", Integer.toString(id_ambito));
        dataAsMap.put("id_cartelera", Integer.toString(id_cartelera));
        // FALTA HACER ESTO PARA LA LISTA
        
        return dataAsMap;
    }
    
	/**
	 * @return the username
	 */
    @XmlElement(name = "username")
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the id_ambito
	 */
	@XmlElement(name = "id_ambito")
	public Integer getId_ambito() {
		return id_ambito;
	}

	/**
	 * @param id_ambito the id_ambito to set
	 */
	public void setId_ambito(Integer id_ambito) {
		this.id_ambito = id_ambito;
	}

	/**
	 * @return the id_cartelera
	 */
	@XmlElement(name = "id_cartelera")
	public Integer getId_cartelera() {
		return id_cartelera;
	}

	/**
	 * @param id_cartelera the id_cartelera to set
	 */
	public void setId_cartelera(Integer id_cartelera) {
		this.id_cartelera = id_cartelera;
	}

	/**
	 * @return the words
	 */
	@XmlElement(name = "words")
	public List<String> getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(List<String> words) {
		this.words = words;
	}


    
	
}
