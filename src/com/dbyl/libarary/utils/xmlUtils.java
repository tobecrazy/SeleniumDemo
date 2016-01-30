package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.dbyl.libarary.utils.Locator.ByType;

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

		Log log = new Log(xmlUtils.class);
		log.info(pageName);
		HashMap<String, Locator> locatorMap = new HashMap<String, Locator>();
		locatorMap.clear();
		File file = new File(path);
		if (!file.exists()) {
			log.error("Can't find " + path);
			throw new IOException("Can't find " + path);
		}
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
			Element page = (Element) i.next();
			if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {
				log.info("page Info is:" + pageName);
				for (Iterator<?> l = page.elementIterator(); l.hasNext();) {
					String type = null;
					String timeOut = "3";
					String value = null;
					String locatorName = null;
					Element locator = (Element) l.next();
					for (Iterator<?> j = locator.attributeIterator(); j
							.hasNext();) {
						Attribute attribute = (Attribute) j.next();
						if (attribute.getName().equals("type")) {
							type = attribute.getValue();
							log.info("get locator type " + type);
						} else if (attribute.getName().equals("timeOut")) {
							timeOut = attribute.getValue();
							log.info("get locator timeOut " + timeOut);
						} else {
							value = attribute.getValue();
							log.info("get locator value " + value);
						}

					}
					Locator temp = new Locator(value,
							Integer.parseInt(timeOut), getByType(type));
					locatorName = locator.getText();
					log.info("locator Name is " + locatorName);
					locatorMap.put(locatorName, temp);
				}
				continue;
			}

		}
		return locatorMap;

	}

	/**
	 * @param type
	 */
	public static ByType getByType(String type) {
		ByType byType = ByType.xpath;
		if (type == null || type.equalsIgnoreCase("xpath")) {
			byType = ByType.xpath;
		} else if (type.equalsIgnoreCase("id")) {
			byType = ByType.id;
		} else if (type.equalsIgnoreCase("linkText")) {
			byType = ByType.linkText;
		} else if (type.equalsIgnoreCase("name")) {
			byType = ByType.name;
		} else if (type.equalsIgnoreCase("className")) {
			byType = ByType.className;
		} else if (type.equalsIgnoreCase("cssSelector")) {
			byType = ByType.cssSelector;
		} else if (type.equalsIgnoreCase("partialLinkText")) {
			byType = ByType.partialLinkText;
		} else if (type.equalsIgnoreCase("tagName")) {
			byType = ByType.tagName;
		}
		return byType;
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
