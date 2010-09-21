package com.aeonconsulting.bdj.model;

import java.util.Date;

public class Albums {

	private String id;
	private String num;
	private String titre;
	private Series serie;
	private Auteurs dessinateur;
	private Auteurs scenariste;
	private Date dateAchat;
	private Double prixAchat;
	private String editeur;
	private Etat etat;
	private Format format;
	private Boolean editionOriginale; // Edition originale
	private Boolean horsSerie;
	private Boolean integrale;
	private Boolean editionLimitee;
	private String collection;
	private Double coteActuelle;
	private String reference; // ISBN
	private Date dateDepotLegal;
	private String commentaire;
	private String imgCouverture;
	private Boolean possede; // Indique si je l'ai ou non
	private Auteurs coloriste;
	private Boolean broche;
	private Boolean dedicace; //Ou alors c'est l'image ?
	private String imgExlibris;
	private Integer nbPages;
	private String perso1;
	private String perso2;
	private String perso3;
	private String numA; // ?? kesako ??
	private Boolean perso4;
	private Boolean prete;
	private Date dateModification;
	private String appreciation;
	private String cycle;
	private Date dateImpression;
	private Date dateDedicace;
	private String infoEdition;
	private Integer nbPlanches;
	private Integer idBel;
	private Boolean aVendre;
	private Boolean aAcheter;
	private Integer nbAlbums;
	private Albums refIntegrale;
	private Boolean upload;
	private String resume;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Series getSerie() {
		return serie;
	}
	public void setSerie(Series serie) {
		this.serie = serie;
	}
	public Auteurs getDessinateur() {
		return dessinateur;
	}
	public void setDessinateur(Auteurs dessinateur) {
		this.dessinateur = dessinateur;
	}
	public Auteurs getScenariste() {
		return scenariste;
	}
	public void setScenariste(Auteurs scenariste) {
		this.scenariste = scenariste;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public Double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public Boolean getEditionOriginale() {
		return editionOriginale;
	}
	public void setEditionOriginale(Boolean editionOriginale) {
		this.editionOriginale = editionOriginale;
	}
	public Boolean getHorsSerie() {
		return horsSerie;
	}
	public void setHorsSerie(Boolean horsSerie) {
		this.horsSerie = horsSerie;
	}
	public Boolean getIntegrale() {
		return integrale;
	}
	public void setIntegrale(Boolean integrale) {
		this.integrale = integrale;
	}
	public Boolean getEditionLimitee() {
		return editionLimitee;
	}
	public void setEditionLimitee(Boolean editionLimitee) {
		this.editionLimitee = editionLimitee;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public Double getCoteActuelle() {
		return coteActuelle;
	}
	public void setCoteActuelle(Double coteActuelle) {
		this.coteActuelle = coteActuelle;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getDateDepotLegal() {
		return dateDepotLegal;
	}
	public void setDateDepotLegal(Date dateDepotLegal) {
		this.dateDepotLegal = dateDepotLegal;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getImgCouverture() {
		return imgCouverture;
	}
	public void setImgCouverture(String imgCouverture) {
		this.imgCouverture = imgCouverture;
	}
	public Boolean getPossede() {
		return possede;
	}
	public void setPossede(Boolean possede) {
		this.possede = possede;
	}
	public Auteurs getColoriste() {
		return coloriste;
	}
	public void setColoriste(Auteurs coloriste) {
		this.coloriste = coloriste;
	}
	public Boolean getBroche() {
		return broche;
	}
	public void setBroche(Boolean broche) {
		this.broche = broche;
	}
	public Boolean getDedicace() {
		return dedicace;
	}
	public void setDedicace(Boolean dedicace) {
		this.dedicace = dedicace;
	}
	public String getImgExlibris() {
		return imgExlibris;
	}
	public void setImgExlibris(String imgElibris) {
		this.imgExlibris = imgElibris;
	}
	public Integer getNbPages() {
		return nbPages;
	}
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}
	public String getPerso1() {
		return perso1;
	}
	public void setPerso1(String perso1) {
		this.perso1 = perso1;
	}
	public String getPerso2() {
		return perso2;
	}
	public void setPerso2(String perso2) {
		this.perso2 = perso2;
	}
	public String getPerso3() {
		return perso3;
	}
	public void setPerso3(String perso3) {
		this.perso3 = perso3;
	}
	public String getNumA() {
		return numA;
	}
	public void setNumA(String numA) {
		this.numA = numA;
	}
	public Boolean getPerso4() {
		return perso4;
	}
	public void setPerso4(Boolean perso4) {
		this.perso4 = perso4;
	}
	public Boolean getPrete() {
		return prete;
	}
	public void setPrete(Boolean prete) {
		this.prete = prete;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public String getAppreciation() {
		return appreciation;
	}
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public Date getDateImpression() {
		return dateImpression;
	}
	public void setDateImpression(Date dateImpression) {
		this.dateImpression = dateImpression;
	}
	public Date getDateDedicace() {
		return dateDedicace;
	}
	public void setDateDedicace(Date dateDedicace) {
		this.dateDedicace = dateDedicace;
	}
	public String getInfoEdition() {
		return infoEdition;
	}
	public void setInfoEdition(String infoEdition) {
		this.infoEdition = infoEdition;
	}
	public Integer getNbPlanches() {
		return nbPlanches;
	}
	public void setNbPlanches(Integer nbPlanches) {
		this.nbPlanches = nbPlanches;
	}
	public Integer getIdBel() {
		return idBel;
	}
	public void setIdBel(Integer idBel) {
		this.idBel = idBel;
	}
	public Boolean getaVendre() {
		return aVendre;
	}
	public void setaVendre(Boolean aVendre) {
		this.aVendre = aVendre;
	}
	public Boolean getaAcheter() {
		return aAcheter;
	}
	public void setaAcheter(Boolean aAcheter) {
		this.aAcheter = aAcheter;
	}
	public Integer getNbAlbums() {
		return nbAlbums;
	}
	public void setNbAlbums(Integer nbAlbums) {
		this.nbAlbums = nbAlbums;
	}
	public Albums getRefIntegrale() {
		return refIntegrale;
	}
	public void setRefIntegrale(Albums refIntegrale) {
		this.refIntegrale = refIntegrale;
	}
	public Boolean getUpload() {
		return upload;
	}
	public void setUpload(Boolean upload) {
		this.upload = upload;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	
	
}
