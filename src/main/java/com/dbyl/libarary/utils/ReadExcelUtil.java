package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * @version 1.1
 * @author young
 *
 */
public class ReadExcelUtil {
	static LogUtils log = new LogUtils(ReadExcelUtil.class);
	static String path;

	/**
	 * @author young
	 * @return
	 * @throws Exception
	 */
	public static String[][] getLocatorMap() throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/java/com/dbyl/libarary/pageAction/UILibrary.xls";
		log.debug(path);
		return getLocatorMap(path);
	}

	/**
	 * @author Young
	 * @return
	 * @throws Exception
	 */
	public static String[][] getLocatorMap(String path) throws Exception {

		log.debug("Read Excel Path: " + path);
		File file = new File(path);
		if (!file.exists()) {
			throw new Exception();
		} else {
			FileInputStream in = new FileInputStream(file);
			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(in));
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow header = sheet.getRow(0);
			try {
				String[][] locatorMap = new String[sheet.getLastRowNum() + 1][header.getLastCellNum()];
				for (int rownum = 0; rownum <= sheet.getLastRowNum(); rownum++) {
					// for (Cell cell : row)
					HSSFRow row = sheet.getRow(rownum);

					if (row == null) {

						continue;

					}
					String value;
					for (int cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
						HSSFCell cell = row.getCell(cellnum);
						if (cell == null) {
							continue;
						} else {
							value = "";
						}
						switch (cell.getCellTypeEnum()) {
						case STRING:
							value = cell.getRichStringCellValue().getString();
							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								value = cell.getDateCellValue().toString();

							} else {
								value = Double.toString((int) cell.getNumericCellValue());

							}
							break;
						case BOOLEAN:
							value = Boolean.toString(cell.getBooleanCellValue());
							break;
						case FORMULA:
							value = cell.getCellFormula().toLowerCase();
							break;
						default:
							value = " ";
							log.info("Null value");
						}
						locatorMap[rownum][cellnum] = value;

					}
				}

				return locatorMap;
			} catch (Exception e) {
				log.error("Unble to read Excel: " + path);
				return null;
			} finally {
				in.close();
				wb.close();
				log.error("Close file: " + path);
			}

		}
	}
}
