package com.fiuba.taller.chat.requests;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Form;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forum-request")
public class UpdateChatRequest {

	private Integer id_chat;
	private Integer id_miembro;
	private Integer lastCallTimestamp;
	
    public UpdateChatRequest(){}
	
    public UpdateChatRequest(Integer id_chat)
    {
        super();
        this.setId_chat(id_chat);
    }

    private String toReadable(String keyValSeparator, String propSeparator) {
        String result = "";
        String k = keyValSeparator;
        String p = propSeparator;

        result += "id_chat" + k + id_chat + p;
        result += "id_miembro" + k + id_miembro + p;
        result += "lastCallTimestamp" + k + lastCallTimestamp + p;
        
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

        dataAsForm.param("id_chat", Integer.toString(id_chat));
        dataAsForm.param("id_miembro", Integer.toString(id_miembro));
        dataAsForm.param("lastCallTimestamp", Integer.toString(lastCallTimestamp));

        return dataAsForm;
    }

    public Map<String, String> toMap(){
        Map<String, String> dataAsMap = new HashMap<String, String>();

        dataAsMap.put("id_chat", Integer.toString(id_chat));
        dataAsMap.put("id_miembro", Integer.toString(id_miembro));
        dataAsMap.put("lastCallTimestamp", Integer.toString(lastCallTimestamp));

        return dataAsMap;
    }

	@XmlElement(name = "id_chat")
	public Integer getId_chat() {
		return id_chat;
	}

	public void setId_chat(Integer id_ambito) {
		this.id_chat = id_ambito;
	}
	
	@XmlElement(name = "lastCallTimestamp")
	public Integer getLastCallTimestamp() {
		return lastCallTimestamp;
	}

	public void setLastCallTimestamp(Integer lastCallTimestamp) {
		this.lastCallTimestamp = lastCallTimestamp;
	}

	/**
	 * @return the id_miembro
	 */
	@XmlElement(name = "id_miembro")
	public Integer getId_miembro() {
		return id_miembro;
	}

	/**
	 * @param id_miembro the id_miembro to set
	 */
	public void setId_miembro(Integer id_miembro) {
		this.id_miembro = id_miembro;
	}
    
	
}
