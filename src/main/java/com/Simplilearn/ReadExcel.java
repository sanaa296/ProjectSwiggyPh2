package com.Simplilearn;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	public static Object[][] loadExcel(String excelFilePath,int sheetIndex,boolean firstRowIsHeader) {

		try{
			
			// reading excel and getting total rows
			FileInputStream fis = new FileInputStream(excelFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			int totalRows = sheet.getLastRowNum(); //index=> 3 rows (0,1,2) => totalRows =2  
			//System.out.println(totalRows);
			
			// declaring the return object => 2d array
			//[2][3] => [0,1]  ... [0,1,2]
			Object[][] data ;
			int rowIndex;
				
			// if first row is header , start from rowIndex=1
			if(firstRowIsHeader) {
				rowIndex=1;
				data= new Object[totalRows][2];
			}else {
				// if first row is header , start from rowIndex=0
				rowIndex=0;
				data= new Object[totalRows+1][2];
			}
			System.out.println(rowIndex);
			
			//loop all rows => starts from 0 or 1
			// 0->(first row is not header)  
			// 1->(first row is header)
			
			for(;rowIndex <= totalRows;rowIndex++) {
				//iterating to all rows
				//0 0
				int objectRowindex=rowIndex;
				
				
				if(firstRowIsHeader) {
					// rowIndex start with 1
					// so  objectRowindex = 1-1 =0
					objectRowindex=rowIndex-1;
					//System.out.println(objectRowindex);
				}
				
		
				XSSFRow row = sheet.getRow(rowIndex);
				int totalCells=row.getLastCellNum();  //3 rows (0,1,2) == totalcell=3
				for ( int cellIndex=0;cellIndex < totalCells; cellIndex++) {

					XSSFCell cell = row.getCell(cellIndex);
					
					//print
					switch(cell.getCellType()) {
					case STRING:
						//System.out.print(cell.getStringCellValue() +",");
						
						data[objectRowindex][cellIndex]=cell.getStringCellValue();
						break;
					case NUMERIC:
						data[objectRowindex][cellIndex]=cell.getNumericCellValue();
						break;

					}
				}
			}
			return data;
		}
		catch(Exception e) {
			e.printStackTrace();
		}


		return null;
	}

//	public static void main(String[] s) {
//
//		String projectPath=System.getProperty("user.dir");
//		String excelFilePath=projectPath+"/Phase2Swiggy.xlsx";
//
//		Object[][] obj=ReadExcel.loadExcel(excelFilePath, 0,true);
//
//		System.out.print(obj[0][0]+",");
//		System.out.println(obj[0][1]);
//		System.out.print(obj[1][0]+",");
//		System.out.println(obj[1][1]);
//		System.out.print(obj[2][0]+",");
//		System.out.println(obj[2][1]);
//		System.out.print(obj[3][0]+",");
//		System.out.println(obj[3][1]);
//		
//
//	}

}
