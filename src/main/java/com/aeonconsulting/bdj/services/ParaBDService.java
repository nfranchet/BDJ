package com.aeonconsulting.bdj.services;

import java.util.ArrayList;
import java.util.List;

import com.aeonconsulting.bdj.dto.DTOHelper;
import com.aeonconsulting.bdj.dto.ParaBDDTO;
import com.aeonconsulting.bdj.model.ObjectType;
import com.aeonconsulting.bdj.proxy.ProxyService;

public class ParaBDService extends BDJService {

	private static ParaBDService _instance;
	
	private ParaBDService() {}
	
	public static ParaBDService getInstance() {
		if (_instance == null) {
			_instance = new ParaBDService();
		}
		return _instance;
	}
	
	public String getParaBDToJson(String lettre, String langue) {
		return getListeObjectToJson(lettre, langue, ObjectType.PARABD);
	}
	

	public List<ParaBDDTO> getParaBD(Integer identifiant) throws BDJException {
		String url="http://www.bedetheque.com/bdgest7/bel_parabd.php?IdSerie="+identifiant;
		String paraBDs= new String(ProxyService.getInstance().getParaBd(url)).trim();
		if (paraBDs.startsWith("[DEBUT]") && paraBDs.endsWith("[FIN]")) {
			paraBDs = paraBDs.substring("[DEBUT]".length(),paraBDs.length()-"[FIN]".length());
			// Chaque ligne de resultat est séparé par  ##
			String[] lignes = paraBDs.split("##");
			List<ParaBDDTO> liste = new ArrayList<ParaBDDTO>();
			for (String ligne : lignes) {
				ParaBDDTO parabdDTO = new ParaBDDTO();
				parabdDTO.from(ligne);
				liste.add(parabdDTO);
			}
			// On serialise la liste en JSON
			return liste;
		} else {
			throw new BDJException("[ERROR] No data found [ERROR]");
		}
	}
	
	public String getParaBDToJson(Integer identifiant) {
		StringBuffer output = new StringBuffer("{'parabds': [");
		try {
			List<ParaBDDTO> liste = getParaBD(identifiant);
			for (ParaBDDTO parabdDTO : liste) {
				output.append(DTOHelper.toJson(parabdDTO)).append(",");
			}
			output.append("{}]}");
			return output.toString();
		} catch (BDJException e) {
			return e.getMessage();
		}
	}
}
