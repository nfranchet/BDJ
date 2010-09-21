package com.aeonconsulting.bdj.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.aeonconsulting.bdj.dto.ListeObjectsDTO;
import com.aeonconsulting.bdj.model.ObjectType;
import com.aeonconsulting.bdj.proxy.ProxyService;

/**
 * Classe de base des services de l'application
 *
 */
public abstract class BDJService {
	
	private static Logger _LOGGER = Logger.getLogger(BDJService.class.getCanonicalName());
	
	private static final String URL_LISTE_OBJECT_A = "http://www.bedetheque.com/bdgest7/bel_series.php?";
	private static final String URL_LISTE_OBJECT_B = "http://www.bedetheque.com/bdgest7/bel_revues.php?";

	public List<ListeObjectsDTO> getListeObject(String lettre, String langue, ObjectType type) throws BDJException {
		if (lettre.equals(" ")) {
			lettre = "";
		} else {
			try {
				lettre = URLEncoder.encode(lettre, "ISO-8859-1");
			} catch (UnsupportedEncodingException e) {
				throw new BDJException("[ERROR] Encoding error [ERROR]",e);
			}
		}
		// TODO : ajouter la partie mock ici
		String url = URL_LISTE_OBJECT_A+"lettre="+lettre+"&langue="+langue;
		switch (type) {
			case BD:
				break;
			case PARABD:
				url+="&parabd=1";
				break;
			case REVUES:
				url = URL_LISTE_OBJECT_B+"lettre="+lettre;
				break;
				
		}
		String series = new String(ProxyService.getInstance().getSeries(url)).trim();
		//series = series.trim();
		if (series.startsWith("[DEBUT]") && series.endsWith("[FIN]")) {
			series = series.substring("[DEBUT]".length(),series.length()-"[FIN]".length());
			// Chaque ligne de resultat est séparé par  ##
			String[] lignes = series.split("##");
			List<ListeObjectsDTO> liste = new ArrayList<ListeObjectsDTO>();
			
			for (String ligne : lignes) {
				ListeObjectsDTO seriesDTO = new ListeObjectsDTO();
				seriesDTO.from(ligne, type);
				liste.add(seriesDTO);
			}
			
			// On serialise la liste en JSON
			return liste;
		} else {
			if (series.startsWith("[ERROR]")) {
				throw new BDJException(series);
			}
			throw new BDJException("[ERROR] No data found [ERROR]");
		}
	}
	
	public String getListeObjectToJson(String lettre, String langue, ObjectType type) {
		if (lettre == null) {
			return ("[ERROR] Lettre obligatoire [ERROR]");				
		} else {
			lettre = Character.toString((char)Integer.valueOf(lettre).intValue());
		}
		if (langue == null) {
			// Par défaut la langue est francaise
			langue = "Français";
		}
		_LOGGER.info("On demande la liste des objets de type "+type.name()+" et la lettre "+lettre);
		try {
			StringBuffer output = new StringBuffer("{'listeObject': [");
			List<ListeObjectsDTO> listSeries = getListeObject(lettre, langue, type);
			for (ListeObjectsDTO seriesDTO : listSeries) {
				output.append(seriesDTO.toJson()).append(",");
			}
			output.append("{}]}");
			return output.toString();
		} catch (BDJException e) {
			return e.getMessage();
		}
	}
	
}
