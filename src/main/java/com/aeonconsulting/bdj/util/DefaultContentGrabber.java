package com.aeonconsulting.bdj.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultContentGrabber implements ContentGrabber {

	private static Logger _LOGGER = Logger
			.getLogger(DefaultContentGrabber.class.getCanonicalName());

	public StringBuffer getContent(Bumper bumper, String url,
			Map<String, String> headersParams) {

		HttpURLConnection connection = null;
		try {
			if (bumper == null) {
				URL urlConnect;
				urlConnect = new URL(url);

				_LOGGER.info("URL = " + urlConnect.toString());
				// TODO : add the proxy definition
				String proxyHost = "55.37.110.10";
				String proxyPort = "390";
				Properties systemProperties = System.getProperties();
				systemProperties.setProperty("http.proxyHost", proxyHost);
				systemProperties.setProperty("http.proxyPort", proxyPort);

				connection = (HttpURLConnection) urlConnect.openConnection();

				connection.setRequestMethod("GET");
				if (headersParams != null) {
					for (String key : headersParams.keySet()) {
						connection.setRequestProperty(key, headersParams.get(key));						
					}
				}
				connection.connect();

			} else {
				URL urlConnect = new URL(bumper.getUrl() + "?"
						+ bumper.getParamSep() + url);
				connection = (HttpURLConnection) urlConnect.openConnection();
				connection.connect();
			}

			final StringBuffer sb = new StringBuffer();
			try {
				final InputStream is = connection.getInputStream();
				final Reader reader = new InputStreamReader(is, Charset
						.forName("ISO-8859-1"));
				final char[] buf = new char[32684];
				int read;

				while ((read = reader.read(buf)) > 0) {
					sb.append(buf, 0, read);
				}
			} finally {
				connection.disconnect();
			}

			Map<String, List<String>> fields = connection.getHeaderFields();
			if (_LOGGER.isLoggable(Level.INFO)) {
				for (String key : fields.keySet()) {
					StringBuffer keyLog = new StringBuffer();
					keyLog.append("Key = ").append(key).append("values = ");
					// _LOGGER.info("Key = " + key + " values =");
					for (String value : fields.get(key)) {
						// _LOGGER.info(value + " , ");
						keyLog.append(value).append(" , ");
					}
					// _LOGGER.info("");
				}
			}

			return sb;
		} catch (MalformedURLException e) {
			_LOGGER.severe(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			_LOGGER.severe(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
