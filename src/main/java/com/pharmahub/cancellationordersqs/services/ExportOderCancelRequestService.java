package com.pharmahub.cancellationordersqs.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.pharmahub.cancellationordersqs.contracts.requests.OrderCancelFilterRequest;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import com.pharmahub.cancellationordersqs.helpers.ExcelTableGeneratorHelper;
import com.pharmahub.cancellationordersqs.repository.OderCancelRequestRepository;
import com.pharmahub.cancellationordersqs.specifications.OderCancelRequestSpecification;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ExportOderCancelRequestService {

    @Autowired
    private OderCancelRequestRepository oderCancelRequestRepository;

    public ByteArrayResource  exportOderCancelRequest(OrderCancelFilterRequest request) throws IOException {

        InputStream templateStream = this.getClass().getResourceAsStream("/templates/OderCancelRequest.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(templateStream);
        var sheet = workbook.getSheetAt(0);

        Specification<OderCancelRequest> specification = Specification
                .where(OderCancelRequestSpecification.hasStatusRequest(request.getRequestStatus()))
                .and(OderCancelRequestSpecification.hasCreatedDate(request.getCreatedDate()));

        var oderCancelRequestList = oderCancelRequestRepository.findAll(specification);
        int rowNum = 1;
        for(OderCancelRequest oderCancelRequest : oderCancelRequestList) {
            var row = sheet.createRow(rowNum++);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String createdDate = sdf.format(oderCancelRequest.getCreatedDate());
            String orderDateSAP = sdf.format(oderCancelRequest.getOrderDateSAP());

            row.createCell(0).setCellValue(oderCancelRequest.getId());
            row.createCell(1).setCellValue(oderCancelRequest.getCenter());
            row.createCell(2).setCellValue(oderCancelRequest.getSapOrderCode());
            row.createCell(3).setCellValue(oderCancelRequest.getClient());
            row.createCell(4).setCellValue(oderCancelRequest.getCompanyName());
            row.createCell(5).setCellValue(oderCancelRequest.getPmmOrderCode());
            row.createCell(6).setCellValue(orderDateSAP);
            row.createCell(7).setCellValue(oderCancelRequest.getCreatedByUser());
            row.createCell(8).setCellValue(createdDate);
            row.createCell(9).setCellValue(oderCancelRequest.getOderCancelRequestStatus().getShortDescription());
        }
        int lastColumn = sheet.getRow(0).getLastCellNum() - 1;

        ExcelTableGeneratorHelper.generateExcelTable(sheet, rowNum-1, lastColumn);

        // Autoajustar columnas
        for (int i = 0; i < lastColumn; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return new ByteArrayResource(outputStream.toByteArray());
    }
}
