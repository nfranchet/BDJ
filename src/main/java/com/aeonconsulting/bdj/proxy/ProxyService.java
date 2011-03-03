package com.aeonconsulting.bdj.proxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.aeonconsulting.bdj.util.BDFilerProperties;
import com.aeonconsulting.bdj.util.BDGestRequests;
import com.aeonconsulting.bdj.util.Bumper;
import com.aeonconsulting.bdj.util.ContentGrabber;
import com.aeonconsulting.bdj.util.PropertyManager;

public class ProxyService {

	private static Logger _LOGGER = Logger.getLogger(ProxyService.class.getCanonicalName());
	
	private static ProxyService _instance;

	private static final String URL_BASE_V7 = "http://194.146.224.74/";
	private static final String URL_BASE_V6 = "http://194.146.224.74/bdgest6proxy/";
	private static boolean saveData = true;

	private static ContentGrabber contentGrabber = null;
	
	private ProxyService() {
	}

	public static ProxyService getInstance() {
		if (_instance == null) {
			_instance = new ProxyService();
			_instance.setSaveData(false);
		}
		return _instance;
	}

	public void setSaveData(boolean saveData) {
		ProxyService.saveData = saveData;
	}

	public byte[] simulation(String url) {
		int pos = url.indexOf(".php");
		BDGestRequests value = BDGestRequests.fromString(url.substring(0,
				pos + 4));
		if (value == null) {
			_LOGGER.warning("url : " + url);
			return null;
		}
		switch (value) {
		case ALBUM:
			return getAlbum(url);
		case AUTEUR:
			return getAuteur(url);
		case CHARGE:
			return getCharge(url);
		case COLLABORATEURS:
			return getCollaborateurs(url);
		case DROITS:
			return getDroits(url);
		case DROITS_MAJ:
			return getDroitsMaj(url);
		case IMG_COUVERTURES:
			return getImage(url);
		case IMG_PARA_BD:
			return getImage(url);
		case IMG_PHOTOS:
			return getImage(url);
		case IMG_VERSOS:
			return getImage(url);
		case ISBN:
			return getIsbn(url);
		case MAJ:
			return getMaj(url);
		case PARA_BD:
			return getParaBd(url);
		case PARAM6:
			return getParam(url);
		case PLANCHES:
			return getImage(url);
		case SERIE:
			return getSerie(url);
		case SERIES:
			return getSeries(url);
		case PARAM7:
			return getHTTPContent(url);
		case ACCUEIL:
			return getAccueil(url);
		case RESUME:
			return getHTTPContent(url);
		case DEMARRAGE:
			return getDemarrage(url);
		default:
			System.err.println("URL " + url + " non connu : on forward");
			return getHTTPContent(url);
		}
	}

	public byte[] getParam(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_PARAM_MOCK)) {
			return new StringBuffer(
					"[DEBUT]5U2ZP8/tkg###puQsgYVVg1a0xTB6or2soeBA###wSBXPHCy###ZZYTfQ###CPRJQx7soRqgn3sfMD4rjjF0###wSBXPHCy###i3Lcj3yCiQ###exJyXQwms9TPP88###soEYkY4muUb+1hoSxuN23gY37NiqhANuKw[FIN]")
					.toString().getBytes();
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getDroits(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_DROITS_MOCK)) {
			return new StringBuffer("[DEBUT]1[FIN]").toString().getBytes();
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getDemarrage(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_DROITS_MOCK)) {
			return "[DEBUT]1|0|7.0.5.2||3595|1|7.0.0.0|||15802[FIN]".getBytes();
		} else {
			return getHTTPContent(url);
		}
	}

	public byte[] getAccueil(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_DROITS_MOCK)) {
			String value = "[DEBUT]Utilisateur non enregistré|1|Nombre d'albums téléchargés : 0||• 3.47 (faible activité)|• 245 utilisateurs en ligne|• 83327 Albums|• 19119 Series|• 13965 Auteurs|• 9119 Para-BD|Attention, BD Gest' nécessite une clé d'enregistrement. Pour commander la licence d'enregistrement qui vous permettra de télécharger les fiches albums, rendez-vous sur www.bdgest.com.|00c603##[FIN]";
			value = "[DEBUT]Utilisateur enregistré|Chp 1|Nombre d'albums téléchargés : 0|Chp 2|• 3.47 (faible activité)|• 245 utilisateurs en ligne|• 83327 Albums|• 19119 Series|• 13965 Auteurs|• 9119 Para-BD|Attention, BD Gest' nécessite une clé d'enregistrement. Pour commander la licence d'enregistrement qui vous permettra de télécharger les fiches albums, rendez-vous sur www.bdgest.com.|00c603##[FIN]";
			return value.getBytes();
		} else {
			return getHTTPContent(url);
		}
	}

	public byte[] getSeries(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_SERIES_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getAlbum(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_ALBUM_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getSerie(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_SERIE_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getAuteur(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_AUTEUR_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getCollaborateurs(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_COLLABORATEURS_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getIsbn(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_ISBN_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getCharge(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_CHARGE_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getDroitsMaj(String url) {
		return getDroits(url);
	}

	public byte[] getParaBd(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_PARA_BD_MOCK)) {
			throw new RuntimeException("Not Yet implemented");
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getImage(String url) {
		// Tentative de recuperation des images
		return getHTTPImageContent(url);
	}

	public byte[] getMaj(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_MAJ_MOCK)) {
			return new byte[] {};
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	public byte[] getAlbumResume(String url) {
		if (PropertyManager
				.getBooleanValue(BDFilerProperties.BDGEST_RQ_ALBUM_RESUME_MOCK)) {
			return new byte[] {};
		} else {
			// Recherche de la liste des series
			// Map<String, String> params = getParams(url);
			// We'll have to go to the website to get the full list
			return getHTTPContent(url);
		}
	}

	// private Map<String, String> getParams(String url) {
	// String[] params = url.substring(url.indexOf("?") + 1).split("&");
	// Map<String, String> paramsValue = new HashMap<String, String>();
	// for (String param : params) {
	// int pos = param.indexOf("=");
	// if (pos!=-1) {
	// String name = param.substring(0, pos);
	// String value = param.substring(pos + 1);
	// paramsValue.put(name, value);
	// }
	// }
	// return paramsValue;
	// }

	private byte[] getHTTPImageContent(String uri) {
		try {
			URL urlConnect = new URL(uri);

			_LOGGER.info("URL = " + urlConnect.toString());
			final HttpURLConnection connection = (HttpURLConnection) urlConnect
					.openConnection();

			connection.setRequestMethod("GET");
			connection.connect();
			int size = connection.getContentLength();
			final ByteBuffer sb = ByteBuffer.allocate(size);
			try {
				final InputStream is = connection.getInputStream();
				final byte[] buf = new byte[32684];
				int read;

				while ((read = is.read(buf)) > 0) {
					sb.put(buf, 0, read);
				}
			} finally {
				connection.disconnect();
			}

			return sb.array();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private byte[] getHTTPContent(String url) {

		StringBuffer sb = new StringBuffer();
		if (contentGrabber != null) {
			Map<String, String> headers = new HashMap<String,String>();
			headers.put("User-Agent", "BDGest7");
			sb.append(contentGrabber.getContent(bumper, url, headers));
		} else {
			return "[ERROR] no content grabber defined [ERROR]".getBytes();
		}
		
		try {

			String data = sb.toString();
			data = data.replace((char) 13, ' ');
			data = data.replace((char) 10, ' ');
			_LOGGER.finest("response : "+data);
			// Mise en cache des demandes suivants une url (pour faire les tests
			// de dev;
			if (saveData) {
				String name = url.replace(URL_BASE_V6, "").replace(URL_BASE_V7,
						"").replace("http://www.bdgest.com/", "").replace("?",
						"_").replace("=", "_").replace("&", "_");
				File file = new File("requests/" + name);
				_LOGGER.info("Ecriture des informations de la requetes dans : "
								+ file.getAbsolutePath());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(data.getBytes());
				fos.flush();
				fos.close();
			}

			return data.getBytes();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Bumper bumper = null;

	public static void setBumper(String url) {
		bumper = new Bumper();
		bumper.setUrl(url);
	}
	
	public static void setBumper(String url, String sep) {
		bumper = new Bumper();
		bumper.setUrl(url);
		bumper.setParamSep(sep);
	}

	public static ContentGrabber getContentGrabber() {
		return contentGrabber;
	}

	public static void setContentGrabber(ContentGrabber contentGrabber) {
		ProxyService.contentGrabber = contentGrabber;
	}
}
