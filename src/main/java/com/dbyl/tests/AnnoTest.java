package main.java.com.dbyl.tests;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import main.java.com.dbyl.libarary.utils.AnnotationDemo;

public class AnnoTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("main.java.com.dbyl.tests.AnnotationUsage");
		Annotation[] annos = clazz.getAnnotations();
		for (Annotation anno : annos) {
			AnnotationDemo classAnno = (AnnotationDemo) anno;
			System.out.println("type name = " + clazz.getName() + "  |  id = " + classAnno.id() + "  |  name = "
					+ classAnno.name() + "  |  　　　　　　　　　　　　　　　　　　　　gid = " + classAnno.className());
		}
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Annotation[] methodAnnos = method.getAnnotations();
			for (Annotation anno : methodAnnos) {
				AnnotationDemo classAnno = (AnnotationDemo) anno;
				System.out.println("type name = " + clazz.getName() + "  |  id = " + classAnno.id() + "  |  name = "
						+ classAnno.name() + "  |  　　　　　　　　　　　　　　　　　　　　gid = " + classAnno.className());
			}
		}
	}

}
