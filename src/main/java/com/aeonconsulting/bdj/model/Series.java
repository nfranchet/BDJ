package com.aeonconsulting.bdj.model;

import java.util.Date;

public class Series {

	private Integer id;
	private String titre;
	private String style;
	private Integer noteDessin;
	private Integer noteScenario;
	private String commentaire;
	private Integer noteGlobale;
	private String imgPlanche;
	private String internet;
	private Encours enCours; // TODO
	private Integer majBel; // ?? kesako ??
	private Date dateModification;
	private Integer idBel;
	private Langue langue;
	private Origine origine;
	private String Perso1;
	private String Perso2;
	private Boolean abonnement;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Integer getNoteDessin() {
		return noteDessin;
	}
	public void setNoteDessin(Integer noteDessin) {
		this.noteDessin = noteDessin;
	}
	public Integer getNoteScenario() {
		return noteScenario;
	}
	public void setNoteScenario(Integer noteScenario) {
		this.noteScenario = noteScenario;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Integer getNoteGlobale() {
		return noteGlobale;
	}
	public void setNoteGlobale(Integer noteGlobale) {
		this.noteGlobale = noteGlobale;
	}
	public String getImgPlanche() {
		return imgPlanche;
	}
	public void setImgPlanche(String imgPlanche) {
		this.imgPlanche = imgPlanche;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public Encours getEnCours() {
		return enCours;
	}
	public void setEnCours(Encours enCours) {
		this.enCours = enCours;
	}
	public Integer getMajBel() {
		return majBel;
	}
	public void setMajBel(Integer majBel) {
		this.majBel = majBel;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public Integer getIdBel() {
		return idBel;
	}
	public void setIdBel(Integer idBel) {
		this.idBel = idBel;
	}
	public Langue getLangue() {
		return langue;
	}
	public void setLangue(Langue langue) {
		this.langue = langue;
	}
	public Origine getOrigine() {
		return origine;
	}
	public void setOrigine(Origine origine) {
		this.origine = origine;
	}
	public String getPerso1() {
		return Perso1;
	}
	public void setPerso1(String perso1) {
		Perso1 = perso1;
	}
	public String getPerso2() {
		return Perso2;
	}
	public void setPerso2(String perso2) {
		Perso2 = perso2;
	}
	public Boolean getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Boolean abonnement) {
		this.abonnement = abonnement;
	}
}
