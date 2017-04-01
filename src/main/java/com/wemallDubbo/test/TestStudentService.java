package com.wemallDubbo.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wemallDubbo.common.Result;
import com.wemallDubbo.model.Student;
import com.wemallDubbo.service.StudentService;

public class TestStudentService {
	public static void main(String[] args) {
		test();
	}
	private static void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo.xml");
		//[wlj_consumer, com.alibaba.dubbo.config.RegistryConfig, testService, studentService]
		String[] names = context.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string + ", ");
		}
		StudentService service =  (StudentService) context.getBean("studentService");
		System.out.println();
		
		//查询地址列表 
		@SuppressWarnings("unchecked")
		List<Student> list = service.listStu(0, 10);
		System.out.println("查询长度是：" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("数据信息：" + list.get(i).toString());
		}
		System.out.println("------------------------------------------------------------------------");
		List<Student> list1 = service.queryAll();
		System.out.println("------------------------------------------------------------------------");
	}
}

