package cn.tt.tomcat.ex02;

import cn.tt.tomcat.ex01.Request;
import cn.tt.tomcat.ex01.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lizhuo
 * @Description: Primitive HttpServer for:
 * static resource
 * servlet
 * @date 2019-09-21 11:33
 */
public class HttpServer1 {

	private static final String SHUTDONW_COMMAND = "/SHUTDOWN";

	private boolean shutdown = false;

	public static void main(String[] args) {
		System.out.println("WEB_ROOT: " + Constants.WEB_ROOT);
		HttpServer1 server = new HttpServer1();
		server.await();
	}

	public void await() {
		int port = 8080;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
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

				if (request.getUri().startsWith("/servlet/")) {

				} else {

				}

				socket.close();

				shutdown = SHUTDONW_COMMAND.equals(request.getUri());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
