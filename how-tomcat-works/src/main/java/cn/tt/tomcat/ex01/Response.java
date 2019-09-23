package cn.tt.tomcat.ex01;

import java.io.*;

public class Response {

	private static final int BUFFER_SIZE = 1024;
	private Request request;
	private OutputStream outputStream;

	public Response(OutputStream output) {
		this.outputStream = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void SendStaticResource() {
		byte[] buffer = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			System.out.println("file:" + HttpServer.WEB_ROOT + File.separator + this.request.getUri());
			File file = new File(HttpServer.WEB_ROOT, this.request.getUri());
			if (file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(buffer, 0, BUFFER_SIZE);
				while (ch != -1) {
					outputStream.write(buffer, 0, ch);
					ch = fis.read(buffer, 0, BUFFER_SIZE);
				}
			} else {
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Content-Length: 23\r\n"
						+ "\r\n"
						+ "<h1>File Not Found yet.</h1>";
				outputStream.write(errorMessage.getBytes());
			}
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
