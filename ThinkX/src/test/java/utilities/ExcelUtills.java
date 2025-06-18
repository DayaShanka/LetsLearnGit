package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtills {

	// creating alias for required class/methods
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static XSSFCellStyle style;

	public static int getRowCount(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;

	}

	public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;

	}

	public static String getCellData(String filePath, String sheetName, int rowNum, int column) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cell = row.getCell(column);

		String data;
		try {
			// data = cell.toString();
			DataFormatter formatter = new DataFormatter(); // Return the formatted data whithin the cell
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = ""; // suppose data is blank in cell then it will not get exception.
		}

		wb.close();
		fis.close();
		return data;

	}

	public static void setCellData(String filePath, String sheetName, int rowNum, int column, String data)
			throws IOException {

		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cell = row.createCell(column);
		cell.setCellValue(data);
		fos = new FileOutputStream(filePath); // using for writing
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
	}

	public static void fillGreenColor(String filePath, String sheetName, int rowNum, int column) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cell = row.getCell(column);
		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();

	}

	public static void fillRedColor(String filePath, String sheetName, int rowNum, int column) throws IOException {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cell = row.getCell(column);
		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
	}

	public static void main(String[] args) {

	}

}
