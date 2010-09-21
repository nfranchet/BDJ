package com.aeonconsulting.bdj.dto;

import java.nio.charset.Charset;

import com.aeonconsulting.bdj.model.ObjectType;

public class ListeObjectsDTO {

	private Integer idBel;
	private String nom;
	private Integer nombre;
	private String langue;
	public Integer getIdBel() {
		return idBel;
	}
	public void setIdBel(Integer idBel) {
		this.idBel = idBel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getNombre() {
		return nombre;
	}
	public void setNombre(Integer nbAlbum) {
		this.nombre = nbAlbum;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	/**
	 * Parser pour
	 * @param ligne
	 */
	public void from(String ligne, ObjectType type) {
		// Une ligne typique 	
		// 17120|A 18 ans sous les balles au Vercors|1|Français
		String[] values = ligne.split("\\|");
		switch (type) {
			case BD:
			case PARABD:
				idBel = DTOHelper.getInteger(values[0]);
				nombre = DTOHelper.getInteger(values[2]);
				langue = values[3];
				nom = values[1];
				break;
			case REVUES:
				idBel = 0;
				nombre = 0;
				nom = values[1];
				langue = "";
				
		}
	}
	
	public String toJson() {
		StringBuffer jsonBuffer = new StringBuffer("{");
		if (nom != null) {
			jsonBuffer.append("'idBel': '").append(idBel).append("',");
			String nomStr=new String(Charset.forName("UTF8").encode(nom.trim()).array()).trim();
			jsonBuffer.append("'nom': '").append(nomStr.replaceAll("'", "\\\\'")).append("',");
			jsonBuffer.append("'nbAlbum': '").append(nombre).append("',");
			String langueStr=new String(Charset.forName("UTF8").encode(langue.trim()).array()).trim();
			jsonBuffer.append("'langue': '").append(langueStr).append("'");
			
		}
		jsonBuffer.append("}");
		return jsonBuffer.toString();
	}
}
