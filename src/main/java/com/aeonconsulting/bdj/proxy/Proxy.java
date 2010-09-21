package com.aeonconsulting.bdj.proxy;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aeonconsulting.bdj.services.DispatchService;
import com.aeonconsulting.bdj.util.DefaultContentGrabber;

/**
 * Servlet implementation class Proxy
 */
public class Proxy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger _LOGGER = Logger.getLogger(Proxy.class.getName()); 
	
    /**
     * Default constructor. 
     */
    public Proxy() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		_LOGGER.fine("------ Request start ----------");
		ProxyService.setContentGrabber(new DefaultContentGrabber());
		if (request.getParameter("url") != null) {
			_LOGGER.info("On demande un appelle via proxy");
			// On demande un appelle direct via le proxy
			byte[] output = ProxyService.getInstance().simulation(request.getParameter("url"));
			response.getWriter().write(new String(output));
		} else {
			Map<String, String> params = new HashMap<String, String>();
			Enumeration paramsName = request.getParameterNames();
			while (paramsName.hasMoreElements()) {
				String name = (String)paramsName.nextElement();
				params.put(name, request.getParameter(name));
			}
			String sortie = DispatchService.getInstance().dispatch(params);
			response.getWriter().write(sortie);
		}
		_LOGGER.fine("------ Request end ----------");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
