package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	 * @return
	 * @throws DocumentException 
	 */
	public static String[][] readXMLDocument(String path) throws DocumentException {
		File file = new File("output.xml");
		if (file.isFile()) {
			System.out.println("file is exists " + file.getPath() + " "
					+ file.exists());
		}

		SAXReader reader = new SAXReader();

		Document document = reader.read(file);

		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
			Element page = (Element) i.next();
			if (page.getName().equalsIgnoreCase("page")) {
				System.out.println("page Info is:");
				for (Iterator<?> l = page.elementIterator(); l.hasNext();) {
					Element locator = (Element) l.next();
					System.out.println(">>>>Locator Name " + locator.getName());
					for (Iterator<?> j = locator.attributeIterator(); j
							.hasNext();) {
						Attribute attribute = (Attribute) j.next();
						System.out.print("attribute name "
								+ attribute.getName() + " ->"
								+ attribute.getName());
						System.out.println(" attribute value "
								+ attribute.getValue());

					}

				}
				continue;
			}

			//
			// for (Iterator<?> j = page.attributeIterator(); j.hasNext();) {
			// Attribute attribute = (Attribute) j.next();
			// System.out.print("attribute name " + attribute.getName()
			// + " ->" + attribute.getName());
			// System.out.println(" attribute value " + attribute.getValue());
			//
			// }
			// System.out.println("attribute value " + page.getText());
			// // get path
			// System.out.println("attribute name " + page.getName() + " ->"
			// + page.getPath());

		}

		return null;

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
