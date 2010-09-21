package com.aeonconsulting.bdj.services;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.logging.Logger;

public class DispatchService {

	private static Logger _LOGGER = Logger.getLogger(DispatchService.class.getName()); 
	
	private static DispatchService _instance;
	
	private DispatchService() {}
	
	public static DispatchService getInstance() {
		if (_instance == null) {
			_instance = new DispatchService();
		}
		
		return _instance;
	}
	
	public String dispatch(Map<String, String> params) throws UnsupportedEncodingException {
		String action = params.get("action");
		String sortie = "[ERROR] Action inconnue [ERROR]";
		if ("series".equals(action)) {
			String lettre = params.get("lettre");
			String langue = params.get("langue");
			sortie = getSeries(lettre, langue);
		} else if ("albumResume".equals(action)) {
			String id = params.get("idBel");
			sortie = getAlbumResume(id);
		} else if ("paradBDs".equals(action)) {
			String lettre = params.get("lettre");
			String langue = params.get("langue");
			sortie = getParaBDs(lettre, langue);
		} else if ("parabdResume".equals(action)) {
			String id = params.get("idBel");
			sortie = getParabdResume(id);
		} else if ("revues".equals(action)) {
			String lettre = params.get("lettre");
			String langue = params.get("langue");
			sortie = getRevues(lettre, langue);
		} else if ("revuesResume".equals(action)) {
			String nom = params.get("nom");
			sortie = getRevuesResume(nom);
		} else {
			// Aucune action définie
		}
		return sortie;
	}
	

	private String getSeries(String lettre, String langue) throws UnsupportedEncodingException {
		return new String(AlbumsService.getInstance().getSeriesToJson(lettre, langue).getBytes(),"ISO-8859-1");
	}

	private String getParaBDs(String lettre, String langue) throws UnsupportedEncodingException {
		return new String(ParaBDService.getInstance().getParaBDToJson(lettre, langue).getBytes(),"ISO-8859-1");
	}

	private String getRevues(String lettre, String langue) throws UnsupportedEncodingException {
		return new String(RevuesService.getInstance().getRevueToJson(lettre, langue).getBytes(),"ISO-8859-1");
	}
	
	private String getAlbumResume(String idBel) throws UnsupportedEncodingException {
		if (idBel == null) {
			return ("[ERROR] Identifiant obligatoire [ERROR]");
		}
		Integer identifiant = Integer.valueOf(idBel);
		_LOGGER.fine("On demande le resume de la serie "+identifiant);
		return new String(AlbumsService.getInstance().getAlbumResumeToJson(identifiant).getBytes(),"ISO-8859-1");
	}
	
	private String getParabdResume(String idBel) throws UnsupportedEncodingException {
		if (idBel == null) {
			return ("[ERROR] Identifiant obligatoire [ERROR]");
		}
		Integer identifiant = Integer.valueOf(idBel);
		_LOGGER.fine("On demande le resume de la serie "+identifiant);
		return new String(ParaBDService.getInstance().getParaBDToJson(identifiant).getBytes(),"ISO-8859-1");
	}
	
	private String getRevuesResume(String nom) throws UnsupportedEncodingException {
		if (nom == null) {
			return ("[ERROR] Identifiant obligatoire [ERROR]");
		}
		return new String(RevuesService.getInstance().getRevueResumeToJson(nom).getBytes(),"ISO-8859-1");
	}

}
