package com.aeonconsulting.bdj.conf;

public class DB_VERSION_1 {

	public static String createAlbumsQuery() {
		StringBuffer query = new StringBuffer("CREATE TABLE `Albums`");
		query.append("(");
		query.append("id INTEGER NOT NULL,");
		query.append("num VARCHAR(50),");
		query.append("titre TEXT NOT NULL,");
		query.append("serie TEXT,");
		query.append("dessinateur INTEGER,");
		query.append("scenariste INTEGER,");
		query.append("dateAchat DATETIME,");
		query.append("prixAchat FLOAT,");
		query.append("editeur VARCHAR(50),");
		query.append("etat INTEGER,");
		query.append("format INTEGER,");
		query.append("editionOriginale INTEGER NOT NULL,");
		query.append("horsSerie INTEGER NOT NULL,");
		query.append("integrale INTEGER NOT NULL,");
		query.append("editionLimitee INTEGER NOT NULL,");
		query.append("collection VARCHAR(50),");
		query.append("coteActuelle FLOAT,");
		query.append("reference VARCHAR(50),");
		query.append("dateDepotLegal DATETIME,");
		query.append("commentaire TEXT,");
		query.append("imgCouverture VARCHAR(50),");
		query.append("possede INTEGER NOT NULL,");
		query.append("coloriste INTEGER,");
		query.append("broche INTEGER NOT NULL,");
		query.append("dedicace INTEGER NOT NULL,");
		query.append("imgExLibris VARCHAR(50),");
		query.append("nbPages INTEGER,");
		query.append("perso1 TEXT,");
		query.append("perso2 TEXT,");
		query.append("perso3 TEXT,");
		query.append("numA VARCHAR(50),");
		query.append("perso4 INTEGER NOT NULL,");
		query.append("prete INTEGER NOT NULL,");
		query.append("dateModification DATETIME,");
		query.append("appreciation VARCHAR(50),");
		query.append("cycle VARCHAR(50),");
		query.append("dateImpression DATETIME,");
		query.append("dateDedicace DATETIME,");
		query.append("infoEdition TEXT,");
		query.append("nbPlanches INTEGER,");
		query.append("idBel INTEGER,");
		query.append("aVendre INTEGER NOT NULL,");
		query.append("aAcheter INTEGER NOT NULL,");
		query.append("nbAlbums INTEGER,");
		query.append("refIntegrale INTEGER,");
		query.append("upload INTEGER NOT NULL,");
		query.append("resume TEXT,");
		query.append("PRIMARY KEY(id)");
		query.append(")");
		return query.toString();
	}
	
	public static String createAuteursQuery() {
		StringBuffer query = new StringBuffer();
		query.append("CREATE TABLE `Auteurs`");
		query.append("(");
		query.append("id INTEGER NOT NULL,");
		query.append("nom VARCHAR(50),");
		query.append("prenom VARCHAR(50),");
		query.append("surnom VARCHAR(50),");
		query.append("dateNaissance DATETIME,");
		query.append("dateDeces DATETIME,");
		query.append("pays INTEGER,");
		query.append("pseudos TEXT,");
		query.append("commentaire TEXT,");
		query.append("scenario INTEGER NOT NULL,");
		query.append("dessin INTEGER NOT NULL,");
		query.append("couleur INTEGER NOT NULL,");
		query.append("internet VARCHAR(50),");
		query.append("dateModification DATETIME,");
		query.append("idBel INTEGER,");
		query.append("abonnement INTEGER NOT NULL,");
		query.append("PRIMARY KEY(id)");
		query.append(")");
		return query.toString();
	}
	
	public static String createVersionQuery() {
		StringBuffer query = new StringBuffer("CREATE TABLE Version (version integer primary key not null)");
		return query.toString();
	}
	
	public static Integer getVersion() {
		return 1;
	}
}
