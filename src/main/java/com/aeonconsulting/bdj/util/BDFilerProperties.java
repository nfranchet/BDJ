package com.aeonconsulting.bdj.util;

public enum BDFilerProperties {

	 BDGEST_RQ_PARAM_MOCK("conf.bdgest.request.param.mock"),
	 BDGEST_RQ_DROITS_MOCK("conf.bdgest.request.droits.mock"),
	 BDGEST_RQ_SERIES_MOCK("conf.bdgest.request.series.mock"),
	 BDGEST_RQ_ALBUM_MOCK("conf.bdgest.request.album.mock"),
	 BDGEST_RQ_SERIE_MOCK("conf.bdgest.request.serie.mock"),
	 BDGEST_RQ_ALBUM_RESUME_MOCK("conf.bdgest.request.album.resume.mock"),
	 BDGEST_RQ_AUTEUR_MOCK("conf.bdgest.request.auteur.mock"),
	 BDGEST_RQ_COLLABORATEURS_MOCK("conf.bdgest.request.collaborateurs.mock"),
	 BDGEST_RQ_ISBN_MOCK("conf.bdgest.request.isbn.mock"),
	 BDGEST_RQ_CHARGE_MOCK("conf.bdgest.request.charge.mock"),
	 BDGEST_RQ_DROITS_MAJ_MOCK("conf.bdgest.request.droits_maj.mock"),
	 BDGEST_RQ_PARA_BD_MOCK("conf.bdgest.request.para_bd.mock"),
	 BDGEST_RQ_IMG_PLANCHES_MOCK("conf.bdgest.request.img.planches.mock"),
	 BDGEST_RQ_IMG_COUVERTURES_MOCK("conf.bdgest.request.img.couvertures.mock"),
	 BDGEST_RQ_IMG_VERSOS_MOCK("conf.bdgest.request.img.versos.mock"),
	 BDGEST_RQ_IMG_PHOTOS_MOCK("conf.bdgest.request.img.photos.mock"),
	 BDGEST_RQ_IMG_PARA_BD_MOCK("conf.bdgest.request.img.para_bd.mock"),
	 BDGEST_RQ_MAJ_MOCK("conf.bdgest.request.maj.mock");
	 
	 private String param;
	 
	 private BDFilerProperties(String param) {
		 this.param = param;
	 }
	 
	 public String getParam() {
		 return param;
	 }
}
