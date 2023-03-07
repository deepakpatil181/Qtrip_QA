package qtriptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.sound.midi.MetaEventListener;
import javax.xml.crypto.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP {

  @DataProvider(name = "userData")
  public Object[][] readExcelData(Method a) throws IOException {
    FileInputStream file = new FileInputStream(new File("src/test/resources/DatasetsforQTrip.xlsx"));
    try (Workbook workbook = new XSSFWorkbook(file)) {
     Sheet sheet=null;
         if(a.getName()=="TestCase01"){
              sheet = workbook.getSheet("TestCase01");
         }
         else if(a.getName()=="TestCase02"){
              sheet = workbook.getSheet("TestCase02");
         }
         else if(a.getName()=="TestCase03"){
             sheet = workbook.getSheet("TestCase03");
         }
         else if(a.getName()=="TestCase04"){
              sheet = workbook.getSheet("TestCase04");
         }
     
       
         int rowCount = sheet.getLastRowNum();
         int colCount = sheet.getRow(0).getLastCellNum();
         Object[][] data =new Object[rowCount][colCount];
     
         for(int i=1;i<=rowCount;i++){
             Row row =sheet.getRow(i);
             for(int j=0;j<colCount;j++){
                     data[i-1][j]=row.getCell(j).toString();
             }
         }
     
     
         file.close();
         return data;
}
  }
}
