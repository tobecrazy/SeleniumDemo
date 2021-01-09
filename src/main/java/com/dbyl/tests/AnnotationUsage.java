package com.dbyl.tests;

import com.dbyl.libarary.utils.AnnotationDemo;

@AnnotationDemo(className = Long.class, name = "Class")
public class AnnotationUsage {
	@AnnotationDemo(className = Long.class, name = "variable", id = 123)
	private String name;

	@AnnotationDemo(className = Long.class, name = "getMethod", id = 783)
	public String getName() {
		return name;
	}

	@AnnotationDemo(className = Long.class, name = "setMethod", id = 456)
	public void setName(String name) {
		this.name = name;
	}

	@AnnotationDemo(className = Long.class, name = "construct", id = 456)
	public AnnotationUsage(String name) {
		super();
		this.name = name;
	}

	
}
