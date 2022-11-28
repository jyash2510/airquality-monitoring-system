package com.airquality.Helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.airquality.Model.Airqualitymonitor;

public class Helper {

    public static boolean checkExcelType(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    public static List<Airqualitymonitor> convertExcelToList(InputStream inputStream) {

        List<Airqualitymonitor> listofAirqualitymonitors = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = 0;
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }

                Iterator<Cell> cellIterator = row.iterator();
                int cellId = 0;

                Airqualitymonitor airqualitymonitor = new Airqualitymonitor();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cellId) {

                        case 0:
                            airqualitymonitor.setDustParicle((int) cell.getNumericCellValue());
                        case 1:
                            airqualitymonitor.setCarbonDioxide((int) cell.getNumericCellValue());
                        case 2:
                            airqualitymonitor.setCarbonMonoxide((int) cell.getNumericCellValue());
                        case 3:
                            airqualitymonitor.setNitrogenDioxide((int) cell.getNumericCellValue());
                        case 4:
                            airqualitymonitor.setSculptureDioxide((int) cell.getNumericCellValue());
                        case 5:
                            airqualitymonitor.setYear((int) cell.getNumericCellValue());
                        case 6:
                            airqualitymonitor.setMonth((int) cell.getNumericCellValue());
                        case 7:
                            airqualitymonitor.setDay((int) cell.getNumericCellValue());
                        default:
                            break;

                    }
                    cellId++;

                }

                listofAirqualitymonitors.add(airqualitymonitor);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return listofAirqualitymonitors;
    }

}
