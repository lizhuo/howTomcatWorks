package cn.tt.tomcat.ex01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

	private static final String SHUTDONW_COMMAND = "/SHUTDONW";

	private boolean shutdown = false;

	public static void main(String[] args) {
		System.out.println("WEB_ROOT: " + WEB_ROOT);
		HttpServer server = new HttpServer();
		server.await();
	}

	public void await() {
		int port = 8080;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("localhost"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;

			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();

				Request request = new Request(input);
				request.prase();

				Response response = new Response(output);
				response.setRequest(request);
				response.SendStaticResource();

				socket.close();

				shutdown = SHUTDONW_COMMAND.equals(request.getUri());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
