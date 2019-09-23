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
public class RequestFacade implements ServletRequest {

	private ServletRequest request = null;

	private InputStream inputStream;
	private String uri;

	public RequestFacade(ServletRequest request) {
		this.request = request;
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
	public Object getAttribute(String attribute) {
		return request.getAttribute(attribute);
	}

	@Override
	public Enumeration getAttributeNames() {
		return request.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		return request.getCharacterEncoding();
	}

	@Override
	public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
		request.setCharacterEncoding(encoding);
	}

	@Override
	public int getContentLength() {
		return request.getContentLength();
	}

	@Override
	public String getContentType() {
		return request.getContentType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return request.getInputStream();
	}

	@Override
	public String getParameter(String name) {
		return request.getParameter(name);
	}

	@Override
	public Enumeration getParameterNames() {
		return request.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String parameter) {
		return request.getParameterValues(parameter);
	}

	@Override
	public Map getParameterMap() {
		return request.getParameterMap();
	}

	@Override
	public String getProtocol() {
		return request.getProtocol();
	}

	@Override
	public String getScheme() {
		return request.getScheme();
	}

	@Override
	public String getServerName() {
		return request.getServerName();
	}

	@Override
	public int getServerPort() {
		return request.getServerPort();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return request.getReader();
	}

	@Override
	public String getRemoteAddr() {
		return request.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return request.getRemoteHost();
	}

	@Override
	public void setAttribute(String key, Object value) {
		request.setAttribute(key, value);
	}

	@Override
	public void removeAttribute(String attribute) {
		request.removeAttribute(attribute);
	}

	@Override
	public Locale getLocale() {
		return request.getLocale();
	}

	@Override
	public Enumeration getLocales() {
		return request.getLocales();
	}

	@Override
	public boolean isSecure() {
		return request.isSecure();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return request.getRequestDispatcher(path);
	}

	@Override
	public String getRealPath(String path) {
		return request.getRealPath(path);
	}

	// advance feature
	@Override
	public int getRemotePort() {
		return request.getRemotePort();
	}

	@Override
	public String getLocalName() {
		return request.getLocalName();
	}

	@Override
	public String getLocalAddr() {
		return request.getLocalAddr();
	}

	@Override
	public int getLocalPort() {
		return request.getLocalPort();
	}
}
