package com.pharmahub.cancellationordersqs.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.annotation.Resource;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

@Service
public class ExportOderCancelRequestService {

    public ByteArrayResource  exportOderCancelRequest() throws IOException {

        InputStream templateStream = this.getClass().getResourceAsStream("/templates/OderCancelRequest.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(templateStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
        return resource;
    }
}
