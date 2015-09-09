package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class xmlUtils {
	/**
	 * @author Young
	 * @param path
	 * @param pageName
	 * @return
	 * @throws Exception 
	 */
	public static HashMap<String, Locator> readXMLDocument(String path,
			String pageName) throws Exception {
		System.out.print(pageName);
		HashMap<String, Locator> locatorMap = new HashMap<String, Locator>();
		locatorMap.clear();
		File file = new File(path);
		if (!file.exists()) {
			throw new IOException("Can't find "+path);
		}
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
			Element page = (Element) i.next();
			if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {
				System.out.println("page Info is:" + pageName);
				for (Iterator<?> l = page.elementIterator(); l.hasNext();) {
					String type;
					String timeOut = "3";
					String value = null;
					String LocatorName = null;
					Element locator = (Element) l.next();
					for (Iterator<?> j = locator.attributeIterator(); j
							.hasNext();) {
						Attribute attribute = (Attribute) j.next();
						if (attribute.getName().equals("type")) {
							type = attribute.getValue();
							System.out.println(">>>>type " + type);
						} else if (attribute.getName().equals("timeOut")) {
							timeOut = attribute.getValue();
							System.out.println(">>>>timeOut " + timeOut);
						} else {
							value = attribute.getValue();
							System.out.println(">>>>value " + value);
						}

					}
					Locator temp = new Locator(value, Integer.parseInt(timeOut));
					LocatorName = locator.getText();
					System.out.println("locator Name is " + LocatorName);
					locatorMap.put(LocatorName, temp);
				}
				continue;
			}

		}
		return locatorMap;

	}

	/**
	 * @author Young
	 * @throws IOException
	 */
	public static void writeXMLDocument() throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter("output.xml"), format);
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("map");
		root.addComment("locator of page map info");
		Element page = root.addElement("page").addAttribute("pageName",
				"com.dbyl.libarary.pageAction.HomePage");
		page.addComment("Locator lists");
		page.addElement("locator").addAttribute("type", "ByName")
				.addAttribute("timeOut", "3")
				.addAttribute("value", "\\\\div[@name]").addText("loginButton");
		page.addElement("locator").addAttribute("type", "ById")
				.addAttribute("timeOut", "3")
				.addAttribute("value", "\\\\div[@id]").addText("InputButton");
		writer.write(document);
		writer.close();
	}

}
