package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException{
        FileInputStream fileinputstream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileinputstream);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();

        List<Object[]> dataList = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        if(rowIterator.hasNext()){
            Row row = rowIterator.next();
        }


        while (rowIterator.hasNext()){
            Row row =rowIterator.next();
            int cellCount = row.getLastCellNum();
            String[] data= new String[cellCount];
            for( int i=0; i<cellCount; i++){
                data[i]= formatter.formatCellValue(row.getCell(i));
            }
            dataList.add(data);
        }
        workbook.close();
        fileinputstream.close();


        Object[][] dataArray = new Object[dataList.size()][];
        for (int i=0; i< dataList.size();i++){
            dataArray[i] =dataList.get(i);
        }
        return dataArray;


    }





}
