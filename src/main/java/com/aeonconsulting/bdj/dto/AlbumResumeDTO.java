package com.aeonconsulting.bdj.dto;

import java.util.Date;

import com.aeonconsulting.bdj.model.Format;

public class AlbumResumeDTO {
	// Une ligne d'exemple
	// 22940|Astérix|1||Astérix le gaulois|Goscinny, René|Uderzo, Albert|
	// <Quadrichromie>|Dargaud|La Collection Pilote|
	// 07/1961||1000|0|0|0|0|0|44|
	// asterix01_22940.jpg|BD Gest'|23/01/2003|
	// Goscinny|René||Uderzo|Albert||
	// <Quadrichromie>|||59|2220|148|7691|1||
	// asterix01planche_22940.jpg|||asterix01v_22940.jpg||

	private Integer idBel;
	private String serie;
	private Integer numero;
	private String a; // L'edition ?
	private String titre;
	private String scenariste;
	private String dessinateur;
	private String coloriste;
	private String Editeur;
	private String Collection;
	private String depotLegal;
	private String isbn;
	private Double cote;
	private Format format;
	private Boolean integrale;
	private Boolean tirageTete;
	private Boolean broche;
	private Boolean bool5;
	private Integer nbPages;
	private String couverture;
	private String soumispar; // j'imagine que c'est l'auteur de la fiche
	private Date dateSoumission; // date de la soumission de la fiche
	private String nomDessinateur; // Goscinny
	private String presnomDessinateur; // René
	private String pseudoDessinateur; //
	private String nomScenariste; // Uderzo
	private String prenomScenariste; // Albert
	private String pseudoScenariste; //
	private String nomColoriste; // <Quadrichromie>
	private String prenomColoriste; //
	private String pseudoColoriste; //
	private String idSerie; // 59
	private String idDessinateur; // 2220
	private String idScenariste; // 148
	private String idColoriste; // 7691
	private Boolean editionOriginale; // 1
	private String infosEdition; //
	private String planche; //
	private String planche1; //
	private String AI; //
	private String planche3; //
	private String albumOrigine;
	private String resume;

	public Integer getIdBel() {
		return idBel;
	}

	public void setIdBel(Integer idBel) {
		this.idBel = idBel;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getScenariste() {
		return scenariste;
	}

	public void setScenariste(String scenariste) {
		this.scenariste = scenariste;
	}

	public String getDessinateur() {
		return dessinateur;
	}

	public void setDessinateur(String dessinateur) {
		this.dessinateur = dessinateur;
	}

	public String getColoriste() {
		return coloriste;
	}

	public void setColoriste(String coloriste) {
		this.coloriste = coloriste;
	}

	public String getEditeur() {
		return Editeur;
	}

	public void setEditeur(String editeur) {
		Editeur = editeur;
	}

	public String getCollection() {
		return Collection;
	}

	public void setCollection(String collection) {
		Collection = collection;
	}

	public String getDepotLegal() {
		return depotLegal;
	}

	public void setDepotLegal(String depotLegal) {
		this.depotLegal = depotLegal;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getCote() {
		return cote;
	}

	public void setCote(Double cote) {
		this.cote = cote;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Boolean getIntegrale() {
		return integrale;
	}

	public void setIntegrale(Boolean integrale) {
		this.integrale = integrale;
	}

	public Boolean getTirageTete() {
		return tirageTete;
	}

	public void setTirageTete(Boolean tirageTete) {
		this.tirageTete = tirageTete;
	}

	public Boolean getBroche() {
		return broche;
	}

	public void setBroche(Boolean broche) {
		this.broche = broche;
	}

	public Boolean getBool5() {
		return bool5;
	}

	public void setBool5(Boolean bool5) {
		this.bool5 = bool5;
	}

	public Integer getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	public String getCouverture() {
		return couverture;
	}

	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}

	public String getSoumispar() {
		return soumispar;
	}

	public void setSoumispar(String soumispar) {
		this.soumispar = soumispar;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public String getNomDessinateur() {
		return nomDessinateur;
	}

	public void setNomDessinateur(String champ1) {
		this.nomDessinateur = champ1;
	}

	public String getPresnomDessinateur() {
		return presnomDessinateur;
	}

	public void setPresnomDessinateur(String champ2) {
		this.presnomDessinateur = champ2;
	}

	public String getPseudoDessinateur() {
		return pseudoDessinateur;
	}

	public void setPseudoDessinateur(String champ3) {
		this.pseudoDessinateur = champ3;
	}

	public String getNomScenariste() {
		return nomScenariste;
	}

	public void setNomScenariste(String champ4) {
		this.nomScenariste = champ4;
	}

	public String getPrenomScenariste() {
		return prenomScenariste;
	}

	public void setPrenomScenariste(String champ5) {
		this.prenomScenariste = champ5;
	}

	public String getPseudoScenariste() {
		return pseudoScenariste;
	}

	public void setPseudoScenariste(String champ6) {
		this.pseudoScenariste = champ6;
	}

	public String getNomColoriste() {
		return nomColoriste;
	}

	public void setNomColoriste(String champ7) {
		this.nomColoriste = champ7;
	}

	public String getPrenomColoriste() {
		return prenomColoriste;
	}

	public void setPrenomColoriste(String champ8) {
		this.prenomColoriste = champ8;
	}

	public String getPseudoColoriste() {
		return pseudoColoriste;
	}

	public void setPseudoColoriste(String champ9) {
		this.pseudoColoriste = champ9;
	}

	public String getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(String champ10) {
		this.idSerie = champ10;
	}

	public String getIdDessinateur() {
		return idDessinateur;
	}

	public void setIdDessinateur(String champ11) {
		this.idDessinateur = champ11;
	}

	public String getIdScenariste() {
		return idScenariste;
	}

	public void setIdScenariste(String champ12) {
		this.idScenariste = champ12;
	}

	public String getIdColoriste() {
		return idColoriste;
	}

	public void setIdColoriste(String champ13) {
		this.idColoriste = champ13;
	}

	public Boolean getEditionOriginale() {
		return editionOriginale;
	}

	public void setEditionOriginale(Boolean editionOriginale) {
		this.editionOriginale = editionOriginale;
	}

	public String getInfosEdition() {
		return infosEdition;
	}

	public void setInfosEdition(String infosEdition) {
		this.infosEdition = infosEdition;
	}

	public String getPlanche() {
		return planche;
	}

	public void setPlanche(String planche) {
		this.planche = planche;
	}

	public String getPlanche1() {
		return planche1;
	}

	public void setPlanche1(String planche1) {
		this.planche1 = planche1;
	}

	public String getAI() {
		return AI;
	}

	public void setAI(String aI) {
		AI = aI;
	}

	public String getPlanche3() {
		return planche3;
	}

	public void setPlanche3(String planche3) {
		this.planche3 = planche3;
	}

	public String getAlbumOrigine() {
		return albumOrigine;
	}

	public void setAlbumOrigine(String avantdernierchamp) {
		this.albumOrigine = avantdernierchamp;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String dernierchamp) {
		this.resume = dernierchamp;
	}

	public void from(String ligne) {
		String[] values = ligne.split("\\|");
		idBel = DTOHelper.getInteger(values[0]);
		serie = values[1];
		numero = DTOHelper.getInteger(values[2], 0);
		a = values[3]; // L'edition ?
		titre = values[4];
		scenariste = values[5];
		dessinateur = values[6];
		coloriste = values[7];
		Editeur = values[8];
		Collection = values[9];
		depotLegal = values[10];
		isbn = values[11];
		cote = DTOHelper.getDouble(values[12],0D);
		format = Format.values()[Integer.valueOf(values[13])];
		integrale = DTOHelper.getBoolean(values[14]);
		tirageTete = DTOHelper.getBoolean(values[15]);
		broche = DTOHelper.getBoolean(values[16]);
		bool5 = DTOHelper.getBoolean(values[17]);
		nbPages = DTOHelper.getInteger(values[18]);
		couverture = values[19];
		soumispar = values[20]; // j'imagine que c'est l'auteur de la fiche
		dateSoumission = DTOHelper.getDate(values[21]);// date de la soumission de la fiche
		nomDessinateur = values[22]; // Goscinny
		presnomDessinateur = values[23]; // René
		pseudoDessinateur = values[24]; //
		nomScenariste = values[25]; // Uderzo
		prenomScenariste = values[26]; // Albert
		pseudoScenariste = values[27]; //
		nomColoriste = values[28]; // <Quadrichromie>
		prenomColoriste = values[29]; //
		pseudoColoriste = values[30]; //
		idSerie = values[31]; // 59
		idDessinateur = values[32]; // 2220
		idScenariste = values[33]; // 148
		idColoriste = values[34]; // 7691
		editionOriginale = DTOHelper.getBoolean(values[35]);
		if (values.length > 36) {
			infosEdition = values[36]; //
		}
		if (values.length > 37) {
			planche = values[37]; //
		}
		if (values.length > 38) {
			planche1 = values[38]; //
		}
		if (values.length > 39) {
			AI = values[39]; //
		}
		if (values.length > 40) {
			planche3 = values[40]; //
		}
		if (values.length > 41) {
			albumOrigine = values[41];
		}
		if (values.length > 42) {
			resume = values[42];
			
		}
	}


}
