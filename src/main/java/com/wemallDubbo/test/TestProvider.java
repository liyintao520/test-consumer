package com.wemallDubbo.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wemallDubbo.service.DemoService;

/**
 * dubbo 管理后台的页面 用户名密码参见D:\tomcat7.0.75-dubbo\webapps\ROOT\WEB-INF
 * localhost:8080/index.html
 * @author Administrator
 *
 */
public class TestProvider {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-dubbo.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("testService");
		String hello = demoService.sayHello("liyintao");
		System.out.println(hello);

		List list = demoService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		System.in.read();
	}

}