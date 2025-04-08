package com.pharmahub.cancellationordersqs.helpers;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

public class ExcelTableGeneratorHelper {

    public static void generateExcelTable(XSSFSheet sheet, int rowNum, int lastColumn){

        AreaReference areaRef = new AreaReference(
                new CellReference(0, 0),
                new CellReference(rowNum-1, lastColumn),
                SpreadsheetVersion.EXCEL2007
        );

        XSSFTable table = sheet.createTable(areaRef);
        table.setDisplayName("defulatTable");
        table.setName("defulatTable");

        CTTableStyleInfo style = table.getCTTable().addNewTableStyleInfo();
        style.setName("TableStyleMedium10");
        style.setShowColumnStripes(false);
        style.setShowRowStripes(true);

    }
}
