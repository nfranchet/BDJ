package com.aeonconsulting.bdj.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.aeonconsulting.bdj.util.DefaultContentGrabber;

public class HTTPProxyServer extends Thread {
	private ServerSocket srvSock;
	public static final int lingerTime = 180; // seconds (?)
	//private static final ProxyService service = new ProxyService();
	
	
	public HTTPProxyServer() throws UnknownHostException, IOException {
		srvSock = new ServerSocket(2000);

	}

	public void run() {
		System.out.println("Server Started");
		try {
			while (!isInterrupted()) {
				Socket serverSocket = srvSock.accept();
				try {
					System.out.println("Accept a new connection");
					serverSocket.setSoLinger(true, lingerTime);
					doConnect(serverSocket);
				} catch (Exception xc) {
					xc.printStackTrace();
				}
			}
			srvSock.close();
		} catch (IOException xc) {
			xc.printStackTrace();
		} finally {
		}
	}

	public void doConnect(Socket inSock) throws UnknownHostException,
			IOException {
		InputStream inS = inSock.getInputStream();
		try {
			StringBuffer buffer = getInputData(inS);
			System.out.println("URL = "+buffer.toString());
			String url = analyse(buffer.toString());
			
			// Instancie le default content grabber qui va bien
			ProxyService.setContentGrabber(new DefaultContentGrabber());
			byte[] output = ProxyService.getInstance().simulation(url);

			inSock.getOutputStream().write(output);
			System.out.println("Sortie:");
			System.out.write(output);
		} catch (Exception xc) {
			xc.printStackTrace();
		}
		System.out.println("We reach the end");
		try {
			System.out.println("We close the connections");
			inSock.close();
		} catch (Exception xc) {
			xc.printStackTrace();
		} finally {
		}
		System.out.println("We have close all the connection");

	}

	private StringBuffer getInputData(InputStream inS) throws IOException,
			InterruptedException {

		byte[] buf = new byte[1024];
		int count = -1;
		System.out.println("copie du flux");
		boolean ended = false;
		StringBuffer buffer = new StringBuffer();
		Thread.sleep(100);
		while ((!ended)) {
			count = inS.read(buf);
			ended = count < 1024;
			buffer.append(new String(buf));
			// System.out.println("We read " + count + " byte = "
			// + new String(buf));
		}
		return buffer;
	}

	private String analyse(String buffer) {
		String[] lines = buffer.split("\n");
		String[] args = lines[0].split(" ");
//		String method = args[0];
		String url = args[1];
//		String protocol = args[2];
		return url;
	}

	public static void main(String[] args) {
		try {
			new HTTPProxyServer().start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
