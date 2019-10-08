package cn.tt.tomcat.ex02;

import cn.tt.tomcat.ex01.HttpServer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * @author lizhuo
 * @Description: Primitive response demo
 * @date 2019-09-21 11:33
 */
public class Response implements ServletResponse {

	private static final int BUFFER_SIZE = 1024;
	private Request request;
	private OutputStream outputStream;

	public Response(OutputStream output) {
		this.outputStream = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void SendStaticResource() throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		System.out.println("file:" + Constants.WEB_ROOT + File.separator + this.request.getUri());
		try {
			File file = new File(HttpServer.WEB_ROOT, this.request.getUri());
			fis = new FileInputStream(file);
			int ch = fis.read(buffer, 0, BUFFER_SIZE);
			while (ch != -1) {
				outputStream.write(buffer, 0, ch);
				ch = fis.read(buffer, 0, BUFFER_SIZE);
			}
		} catch (IOException e) {
			e.printStackTrace();
			String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
					+ "Content-Type: text/html\r\n"
					+ "Content-Length: 23\r\n"
					+ "\r\n"
					+ "<h1>File Not Found yet.</h1>";
			outputStream.write(errorMessage.getBytes());
		} finally {
			outputStream.flush();
			if (fis != null) {
				fis.close();
			}
		}
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// autoflush is true, println() will flush, but print() will not.
		return new PrintWriter(outputStream, true);
	}

	@Override
	public void setCharacterEncoding(String s) {

	}

	@Override
	public void setContentLength(int i) {

	}

	@Override
	public void setContentType(String s) {

	}

	@Override
	public void setBufferSize(int i) {

	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException {

	}

	@Override
	public void resetBuffer() {

	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public void reset() {

	}

	@Override
	public void setLocale(Locale locale) {

	}

	@Override
	public Locale getLocale() {
		return null;
	}
}
