package com.aeonconsulting.bdj.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.aeonconsulting.bdj.dto.DTOHelper;
import com.aeonconsulting.bdj.dto.RevuesDTO;
import com.aeonconsulting.bdj.model.ObjectType;
import com.aeonconsulting.bdj.proxy.ProxyService;

public class RevuesService extends BDJService {

	private static RevuesService _instance;
	
	private RevuesService() {}
	
	public static RevuesService getInstance() {
		if (_instance == null) {
			_instance = new RevuesService();
		}
		return _instance;
	}
	
	public String getRevueToJson(String lettre, String langue) {
		return getListeObjectToJson(lettre, langue, ObjectType.REVUES);
	}
	
	public List<RevuesDTO> getRevuesResume(String nom) throws BDJException {
		String url;
		try {
			nom = new String ( nom.getBytes(), "UTF8" );
			url = "http://194.146.224.74/bdgest7/bel_revue.php?revue="+URLEncoder.encode(nom, "UTF8");
		} catch (UnsupportedEncodingException e) {
			throw new BDJException("[ERROR] Encoding error [ERROR]");
		}
		String revues= new String(ProxyService.getInstance().getParaBd(url)).trim();
		if (revues.startsWith("[DEBUT]") && revues.endsWith("[FIN]")) {
			revues = revues.substring("[DEBUT]".length(),revues.length()-"[FIN]".length());
			// Chaque ligne de resultat est séparé par  ##
			String[] lignes = revues.split("##");
			List<RevuesDTO> liste = new ArrayList<RevuesDTO>();
			for (String ligne : lignes) {
				RevuesDTO revuesDTO = new RevuesDTO();
				revuesDTO.from(ligne);
				liste.add(revuesDTO);
			}
			// On serialise la liste en JSON
			return liste;
		} else {
			throw new BDJException("[ERROR] No data found [ERROR]");
		}
	}

	public String getRevueResumeToJson(String nom) {
		StringBuffer output = new StringBuffer("{'revues': [");
		try {
			List<RevuesDTO> liste = getRevuesResume(nom);
			for (RevuesDTO revuesDTO : liste) {
				output.append(DTOHelper.toJson(revuesDTO)).append(",");
			}
			output.append("{}]}");
			return output.toString();
		} catch (BDJException e) {
			return e.getMessage();
		}
	}
}
