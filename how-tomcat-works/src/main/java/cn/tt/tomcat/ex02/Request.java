package cn.tt.tomcat.ex02;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author lizhuo
 * @Description: Primitive request demo
 * @date 2019-09-21 11:33
 */
public class Request implements ServletRequest {

	private InputStream inputStream;
	private String uri;

	public Request(InputStream input) {
		this.inputStream = input;
	}

	public String getUri() {
		return uri;
	}

	public void prase() {
		StringBuffer sb = new StringBuffer(2048);
		int i = 0;
		byte[] buffer = new byte[2048];
		try {
			i = inputStream.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for (int j=0; j<i; j++) {
			sb.append((char) buffer[j]);
		}
		System.out.println("ex02 request: " + sb.toString());
		this.uri = parseURI(sb.toString());
	}

	private String parseURI(String request) {
		if (StringUtils.isBlank(request)) {
			System.out.println("ex02 parse uri exception.");
			return "";
		}
		int idx1, idx2;
		idx1 = request.indexOf(" ");
		if (idx1 >= 0) {
			idx2 = request.indexOf(" ", idx1 + 1);
			if (idx2 > idx1) {
				return request.substring(idx1 + 1, idx2);
			}
		}
		System.out.println("ex02 not find URI");
		return "";
	}

	@Override
	public Object getAttribute(String s) {
		return null;
	}

	@Override
	public Enumeration getAttributeNames() {
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

	}

	@Override
	public int getContentLength() {
		return 0;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public String getParameter(String s) {
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		return null;
	}

	@Override
	public String[] getParameterValues(String s) {
		return new String[0];
	}

	@Override
	public Map getParameterMap() {
		return null;
	}

	@Override
	public String getProtocol() {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public int getServerPort() {
		return 0;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return null;
	}

	@Override
	public String getRemoteAddr() {
		return null;
	}

	@Override
	public String getRemoteHost() {
		return null;
	}

	@Override
	public void setAttribute(String s, Object o) {

	}

	@Override
	public void removeAttribute(String s) {

	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public Enumeration getLocales() {
		return null;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String s) {
		return null;
	}

	@Override
	public String getRealPath(String s) {
		return null;
	}

	@Override
	public int getRemotePort() {
		return 0;
	}

	@Override
	public String getLocalName() {
		return null;
	}

	@Override
	public String getLocalAddr() {
		return null;
	}

	@Override
	public int getLocalPort() {
		return 0;
	}
}
