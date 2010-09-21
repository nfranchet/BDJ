package com.aeonconsulting.bdj.services;

import java.util.ArrayList;
import java.util.List;

import com.aeonconsulting.bdj.dto.AlbumResumeDTO;
import com.aeonconsulting.bdj.dto.DTOHelper;
import com.aeonconsulting.bdj.model.ObjectType;
import com.aeonconsulting.bdj.proxy.ProxyService;

public class AlbumsService extends BDJService {

	private static AlbumsService _instance;
	
	private AlbumsService() {}
	
	public static AlbumsService getInstance() {
		if (_instance == null) {
			_instance = new AlbumsService();
		}
		return _instance;
	}
	
	public String getSeriesToJson(String lettre, String langue) {
		return getListeObjectToJson(lettre, langue, ObjectType.BD);
	}

	public List<AlbumResumeDTO> getAlbumResume(Integer identifiant) throws BDJException {
		// TODO : ajouter la partie mock ici
		String album = (new String(ProxyService.getInstance().getAlbumResume("http://www.bedetheque.com/bdgest7/bel_album_resume.php?IdSerie="+identifiant))).trim();
		if (album.startsWith("[DEBUT]") && album.endsWith("[FIN]")) {
			album = album.substring("[DEBUT]".length(),album.length()-"[FIN]".length());
			// Chaque ligne de resultat est séparé par  ##
			String[] lignes = album.split("##");
			List<AlbumResumeDTO> liste = new ArrayList<AlbumResumeDTO>();
			for (String ligne : lignes) {
				AlbumResumeDTO albumResumeDTO = new AlbumResumeDTO();
				albumResumeDTO.from(ligne);
				liste.add(albumResumeDTO);
			}
			// On serialise la liste en JSON
			return liste;
		} else {
			throw new BDJException("[ERROR] No data found [ERROR]");
		}
	}
	
	public String getAlbumResumeToJson(Integer identifiant) {
		StringBuffer output = new StringBuffer("{'albumResume': [");
		try {
			List<AlbumResumeDTO> liste = getAlbumResume(identifiant);
			for (AlbumResumeDTO albumResumeDTO : liste) {
				output.append(DTOHelper.toJson(albumResumeDTO)).append(",");
			}
			output.append("{}]}");
			return output.toString();
		} catch (BDJException e) {
			return e.getMessage();
		}
	}
}
