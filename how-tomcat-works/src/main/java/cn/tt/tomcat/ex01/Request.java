package cn.tt.tomcat.ex01;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

public class Request {

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
		System.out.println("request: " + sb.toString());
		this.uri = parseURI(sb.toString());
		this.uri = "index.html";
	}

	private String parseURI(String request) {
		if (StringUtils.isBlank(request)) {
			System.out.println("parse uri exception.");
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
		System.out.println("not find URI");
		return "";
	}

}
