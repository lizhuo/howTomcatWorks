package cn.tt.tomcat.ex02;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * @author lizhuo
 * @Description: Primitive response demo
 * @date 2019-09-21 11:33
 */
public class ResponseFacade implements ServletResponse {

	private ServletResponse response;

	public ResponseFacade(Response response) {
		this.response = response;
	}

	@Override
	public String getCharacterEncoding() {
		return response.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return response.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return response.getWriter();
	}

	@Override
	public void setCharacterEncoding(String s) {
		response.setCharacterEncoding(s);
	}

	@Override
	public void setContentLength(int length) {
		response.setContentLength(length);
	}

	@Override
	public void setContentType(String type) {
		response.setContentType(type);
	}

	@Override
	public void setBufferSize(int size) {
		response.setBufferSize(size);
	}

	@Override
	public int getBufferSize() {
		return response.getBufferSize();
	}

	@Override
	public void flushBuffer() throws IOException {
		response.flushBuffer();
	}

	@Override
	public void resetBuffer() {
		response.resetBuffer();
	}

	@Override
	public boolean isCommitted() {
		return response.isCommitted();
	}

	@Override
	public void reset() {
		response.reset();
	}

	@Override
	public void setLocale(Locale locale) {
		response.setLocale(locale);
	}

	@Override
	public Locale getLocale() {
		return response.getLocale();
	}
}
