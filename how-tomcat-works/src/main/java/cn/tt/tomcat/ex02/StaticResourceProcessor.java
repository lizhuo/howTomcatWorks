package cn.tt.tomcat.ex02;

import java.io.IOException;

/**
 * @author lizhuo
 * @Description: static resource for http server
 * @date 2019-10-07 19:30
 */
public class StaticResourceProcessor {

	public void process(Request request, Response response) {
		try {
			response.SendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
