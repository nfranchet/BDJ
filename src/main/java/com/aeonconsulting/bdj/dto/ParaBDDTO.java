package com.aeonconsulting.bdj.dto;

import com.aeonconsulting.bdj.model.Aspect;
import com.aeonconsulting.bdj.model.Categorie2DParaBD;
import com.aeonconsulting.bdj.model.Categorie3DParaBD;
import com.aeonconsulting.bdj.model.CategorieMultimediaParaBD;
import com.aeonconsulting.bdj.model.CategorieParaBD;
import com.aeonconsulting.bdj.model.CategorieUnknownParaBD;
import com.aeonconsulting.bdj.model.TypeParaBD;

public class ParaBDDTO {

	private Integer idBel;
	private Integer idSerie;
	private Integer idAuteur;
	private String nomSerie;
	private String auteur;
	private String descriptif;
	private TypeParaBD type;
	private CategorieParaBD categorie;
	private String matiere;
	private Aspect aspect; // Aspect ?
	private String editeur;
	private String fabricant;
	private Integer champ8;
	private Boolean numerote;
	private Boolean signe; // 1
	private Boolean boite;
	private Boolean horscommerce;
	private Integer hauteur;
	private Integer largeur;
	private Integer profondeur;
	private String dateSortie;
	private String tirage;
	private String champ14;
	private Double prix;
	private Double cote;
	private String commentaire;
	private String image;
	private String nomAuteur;
	private String prenomAuteur;
	private String pseudoAuteur;
	private String reference;
	private String champ20;

	public Integer getIdBel() {
		return idBel;
	}

	public void setIdBel(Integer champ1) {
		this.idBel = champ1;
	}

	public Integer getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Integer champ2) {
		this.idSerie = champ2;
	}

	public Integer getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Integer champ3) {
		this.idAuteur = champ3;
	}

	public String getNomSerie() {
		return nomSerie;
	}

	public void setNomSerie(String nomSerie) {
		this.nomSerie = nomSerie;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public TypeParaBD getType() {
		return type;
	}

	public void setType(TypeParaBD type) {
		this.type = type;
	}

	public CategorieParaBD getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieParaBD categorie) {
		this.categorie = categorie;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public Aspect getAspect() {
		return aspect;
	}

	public void setAspect(Aspect aspect) {
		this.aspect = aspect;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getChamp7() {
		return fabricant;
	}

	public void setChamp7(String champ7) {
		this.fabricant = champ7;
	}

	public Integer getChamp8() {
		return champ8;
	}

	public void setChamp8(Integer champ8) {
		this.champ8 = champ8;
	}


	public String getFabricant() {
		return fabricant;
	}

	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}

	public Boolean getNumerote() {
		return numerote;
	}

	public void setNumerote(Boolean numerote) {
		this.numerote = numerote;
	}

	public Boolean getSigne() {
		return signe;
	}

	public void setSigne(Boolean signe) {
		this.signe = signe;
	}

	public Boolean getBoite() {
		return boite;
	}

	public void setBoite(Boolean boite) {
		this.boite = boite;
	}

	public Boolean getHorscommerce() {
		return horscommerce;
	}

	public void setHorscommerce(Boolean horscommerce) {
		this.horscommerce = horscommerce;
	}

	public Integer getHauteur() {
		return hauteur;
	}

	public void setHauteur(Integer hauteur) {
		this.hauteur = hauteur;
	}

	public Integer getLargeur() {
		return largeur;
	}

	public void setLargeur(Integer largeur) {
		this.largeur = largeur;
	}

	public Integer getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(Integer profondeur) {
		this.profondeur = profondeur;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getTirage() {
		return tirage;
	}

	public void setTirage(String champ13) {
		this.tirage = champ13;
	}

	public String getChamp14() {
		return champ14;
	}

	public void setChamp14(String champ14) {
		this.champ14 = champ14;
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

	public void setCommentaire(String champ17) {
		this.commentaire = champ17;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getPrenomAuteur() {
		return prenomAuteur;
	}

	public void setPrenomAuteur(String prenomAuteur) {
		this.prenomAuteur = prenomAuteur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String champ19) {
		this.reference = champ19;
	}

	public String getChamp20() {
		return champ20;
	}

	public void setChamp20(String champ20) {
		this.champ20 = champ20;
	}

	public void from(String ligne) {
		String[] values = ligne.split("\\|");
		idBel = DTOHelper.getInteger(values[0]);
		idSerie = DTOHelper.getInteger(values[1]);
		idAuteur = DTOHelper.getInteger(values[2]);
		nomSerie = values[3];
		auteur = values[4];
		descriptif = values[5];
		type = TypeParaBD.values()[Integer.valueOf(values[6])];
		switch (type) {
			case TYPE_2D:
				categorie = Categorie2DParaBD.values()[Integer.valueOf(values[7])];
				break;
			case TYPE_3D:
				categorie = Categorie3DParaBD.values()[Integer.valueOf(values[7])];
				break;
			case MULTIMEDIA:
				categorie = CategorieMultimediaParaBD.values()[Integer.valueOf(values[7])];
				break;
			case VALUE4:
				categorie = CategorieUnknownParaBD.values()[Integer.valueOf(values[7])];
				break;
			case VALUEO:
				categorie = CategorieUnknownParaBD.values()[Integer.valueOf(values[7])];
				break;
		}
		matiere = values[8];
		aspect = Aspect.values()[Integer.valueOf(values[9])]; // Aspect ?
		editeur = values[10];
		fabricant = values[11];
		champ8 = DTOHelper.getInteger(values[12]);
		numerote = DTOHelper.getBoolean(values[13]);
		signe = DTOHelper.getBoolean(values[14]); // 1
		boite = DTOHelper.getBoolean(values[15]);
		horscommerce = DTOHelper.getBoolean(values[16]);
		hauteur = DTOHelper.getInteger(values[17]);
		largeur = DTOHelper.getInteger(values[18]);
		profondeur = DTOHelper.getInteger(values[19]);
		dateSortie = values[20];
		tirage = values[21];
		champ14 = values[22];
		prix = DTOHelper.getDouble(values[23]);
		cote = DTOHelper.getDouble(values[24]);
		commentaire = values[25];
		image = values[26];
		nomAuteur = values[27];
		prenomAuteur = values[28];
		if (values.length > 29) {
			pseudoAuteur = values[29];
		}
		if (values.length > 30) {
			reference = values[30];
		}
		if (values.length>31) {
			champ20 = values[31];
		}
	}

	public String getPseudoAuteur() {
		return pseudoAuteur;
	}

	public void setPseudoAuteur(String pseudoAuteur) {
		this.pseudoAuteur = pseudoAuteur;
	}

}
