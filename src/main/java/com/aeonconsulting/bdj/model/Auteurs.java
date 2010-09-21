package com.aeonconsulting.bdj.model;

import java.util.Date;

public class Auteurs {

	private Integer id;
	private String nom;
	private String prenom; 
	private String surnom; // Utilisé pour mettre l'image
	private Date dateNaissance;
	private Date dateDeces;
	private Pays pays;
	private String pseudos;
	private String commentaire;
	private Boolean scenario;
	private Boolean dessin;
	private Boolean couleur;
	private String internet;
	private Date dateModification;
	private Integer idBel;
	private Boolean abonnement;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateDeces() {
		return dateDeces;
	}
	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public String getPseudos() {
		return pseudos;
	}
	public void setPseudos(String pseudos) {
		this.pseudos = pseudos;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Boolean getScenario() {
		return scenario;
	}
	public void setScenario(Boolean scenario) {
		this.scenario = scenario;
	}
	public Boolean getDessin() {
		return dessin;
	}
	public void setDessin(Boolean dessin) {
		this.dessin = dessin;
	}
	public Boolean getCouleur() {
		return couleur;
	}
	public void setCouleur(Boolean couleur) {
		this.couleur = couleur;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
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
	public Boolean getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Boolean abonnement) {
		this.abonnement = abonnement;
	}
}
