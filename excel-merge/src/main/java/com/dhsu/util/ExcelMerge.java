package com.dhsu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.java2d.cmm.kcms.KcmsServiceProvider;

/**
 * @ClassName： ExcelMerge
 * 
 * @Author: dhSu
 * @Description:Excel合并
 * @Date:Created in 2018年10月27日
 */
public class ExcelMerge {
	public static boolean merge(String[] names,String fileName) throws FileNotFoundException, IOException {
		System.out.println("开始合并...");
		// 文件名列表
		//String[] names = { "D:\\kdxf\\开发测试\\excel合并测试\\工作量1.xls", "D:\\kdxf\\开发测试\\excel合并测试\\工作量2.xls"};
		// 转化为文件列表
		List<File> files = new ArrayList<File>();
		for (String name : names)
			files.add(new File(name));
		// 目标excel文件
		XSSFWorkbook  targetBook = new XSSFWorkbook(new FileInputStream(files.get(0)));
		XSSFWorkbook workbook;//要合并的表的引用
		XSSFSheet sourceSheet;
		//遍历文件列表
		int size = files.size();//文件个数
		for (int k = 1;k < size;k ++) {
			// 读取一个表
			workbook = new XSSFWorkbook(new FileInputStream(files.get(k)));
			//获取该表的sheet数
			int st = workbook.getNumberOfSheets();
			//遍历sheet
			for(int s = 0; s < st; s++) {
				// 读取一个sheet
				sourceSheet = workbook.getSheetAt(s);
				XSSFSheet targetSheet;
				//合并第一个表时创建相同的sheet
				if(k == 0) {
					String name = sourceSheet.getSheetName();
					targetSheet = targetBook.createSheet(name);//创建同名的sheet
				}else
					targetSheet = targetBook.getSheetAt(s);
				// 当前的sheet合并数据
				for (int i = 0; i <= sourceSheet.getLastRowNum(); i++) {
					XSSFRow  sourceRow = sourceSheet.getRow(i);
					if(sourceRow == null)
						continue;
					XSSFRow  targetRow = targetSheet.getRow(i);
					if(targetRow == null)
						targetRow = targetSheet.createRow(i);
					// 遍历列
					for (int j = 0; j < sourceRow.getLastCellNum(); j++) {
						XSSFCell  cell = sourceRow.getCell(j);// 读取单元格
						if (cell == null)
							continue;
						// 按单元格类型处理cell
						switch (cell.getCellType()) {
							case Cell.CELL_TYPE_BLANK:
								break;
							case Cell.CELL_TYPE_STRING:
								targetRow.createCell(j).setCellValue(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								targetRow.createCell(j).setCellValue(cell.getNumericCellValue());
								break;
							default:
								targetRow.createCell(j).setCellValue(cell.toString());
						}
					}
				}
			}
		}
		//获取电脑用户名
		String user = System.getenv().get("USERNAME");
		File file2 = new File("C:\\Documents and Settings\\" + user + "\\Desktop\\" + fileName + ".xlsx");
		if (file2.exists()) {
			file2.delete();
		}
		file2.createNewFile();
		FileOutputStream fo = new FileOutputStream(file2);
		targetBook.write(fo);
		targetBook.close();
		fo.close();
		System.out.println("合并成功....");
		return true;
	}
}
