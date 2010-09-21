package com.aeonconsulting.bdj.util;


public enum BDGestRequests {
	
	PARAM6("param_bdgest6.php"),
	PARAM7("param_bdgest7.php",true),
	DROITS("bel_droits.php"),
	SERIES("bel_series.php"),
	ALBUM("bel_album.php"),
	SERIE("bel_serie.php"),
	AUTEUR("bel_auteur.php"),
	COLLABORATEURS("bel_collaborateurs.php"),
	ISBN("bel_isbn.php"),
	CHARGE("maj_charge.php"),
	DROITS_MAJ("maj_droits.php"),
	PARA_BD("bel_parabd.php"),
	PLANCHES("Planches", true),
	IMG_COUVERTURES("Couvertures", true),
	IMG_VERSOS("Versos", true),
	IMG_PHOTOS("Photos", true),
	IMG_PARA_BD("ParaBD", true),
	MAJ("bel_maj.php",false, true),
	ACCUEIL("bel_accueil.php", true),
	RESUME("bel_album_resume", true),
	DEMARRAGE("demarrage", true),
	UNKNOWN("")
	;
	
	private static String BASE_VERSION_6 = "http://www.bedetheque.com/bdgest6proxy/";
	private static String BASE_VERSION_7 = "http://www.bedetheque.com/bdgest7/";
//	private static Integer VERSION_6 = 6;
//	private static Integer VERSION_7 = 7;
//	private static Integer VERSION_ALL = 0;
	private String request;
	private Integer version;
	

	private boolean enable;
	private boolean data;
	
	private BDGestRequests(String request) {
		this.request = request;
		this.data = false;
		this.enable = true;
	}
	
	private BDGestRequests(String request, boolean data) {
		this.request = request;
		this.data = data;
		this.enable = true;
	}
	
	private BDGestRequests(String request, boolean data, boolean enable) {
		this.request = request;
		this.data = data;
		this.enable = enable;
	}
	
	public String getRequest() {
		return request;
	}
	
	public boolean isData() {
		return data;
	}
	
	public boolean isEnable() {
		return enable;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public static BDGestRequests fromString(String url) {
		
		for (BDGestRequests request : BDGestRequests.values()) {
			if (url.contains(request.getRequest())) {
				if (url.contains(BASE_VERSION_6)) {
					return request;
				} else if (url.contains(BASE_VERSION_7)) {
					return request;
				} else {
					return request;
				}
			}
		}
		return null;
	}
	
}