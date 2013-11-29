package com.fiuba.taller.communication;

public class CreateSectionData {
	private String section_name;
	private int id_ambito,id_foro;
	
	public String getSection_name() {
		return section_name;
	}
	
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	
	public int getId_ambito() {
		return id_ambito;
	}
	
	public void setId_ambito(int id_ambito) {
		this.id_ambito = id_ambito;
	}
	
	public int getId_foro() {
		return id_foro;
	}
	
	public void setId_foro(int id_foro) {
		this.id_foro = id_foro;
	}
	
	public int createSection() {
		return 0;
	}
}
