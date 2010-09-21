package com.aeonconsulting.bdj.dto;

import java.util.Date;

public class RevuesDTO {

	private Integer idBel;
	private String nom;
	private Integer numero;
	private String a;
	private Date dateRevue;
	private String periodicite;
	private String editeur;
	private Integer numoureliure; //1 numero: 0 reliure
	private Double prix;
	private Double cote;
	private String commentaire;
	private String couverture;
	private String planche;
	private String verso;
	private String titre;
	private Integer nbPages;
	
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public Date getDateRevue() {
		return dateRevue;
	}
	public void setDateRevue(Date dateRevue) {
		this.dateRevue = dateRevue;
	}
	public String getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Integer getNumoureliure() {
		return numoureliure;
	}
	public void setNumoureliure(Integer numoureliure) {
		this.numoureliure = numoureliure;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Double getCote() {
		return cote;
	}
	public void setCote(Double cote) {
		this.cote = cote;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getCouverture() {
		return couverture;
	}
	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}
	public String getPlanche() {
		return planche;
	}
	public void setPlanche(String planche) {
		this.planche = planche;
	}
	public String getVerso() {
		return verso;
	}
	public void setVerso(String verso) {
		this.verso = verso;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Integer getNbPages() {
		return nbPages;
	}
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	
	public void from(String ligne) {
		String[] values = ligne.split("\\|");
		 idBel = DTOHelper.getInteger(values[0]);
		 nom = values[1];
		 numero = DTOHelper.getInteger(values[2],0);
		 a = values[3];
		 dateRevue = DTOHelper.getDate(values[4]);
		 periodicite = values[5];
		 editeur = values[6];
		 numoureliure = DTOHelper.getInteger(values[7]); //1 numero: 0 reliure
		 if (values.length > 8) {
			 prix = DTOHelper.getDouble(values[8]);
		 }
		 if (values.length > 9) {
			 cote = DTOHelper.getDouble(values[9]);
		 }
		 if (values.length > 10) {
			 commentaire = values[10];
		 }
		 if (values.length > 11) {
			 couverture = values[11];
		 }
		 if (values.length > 12) {
			 planche = values[12];
		 }
		 if (values.length > 13) {
			 verso = values[13];
		 }
		 if (values.length > 14) {
			 titre = values[14];
		 }
		 if (values.length > 15) {
			 nbPages = DTOHelper.getInteger(values[15]);
		 }
	}
	
}
