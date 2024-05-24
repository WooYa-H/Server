package com.example.excel.service.excel;

import com.example.excel.domain.excel.Crop;
import com.example.excel.repository.excel.CropRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService{

    private final CropRepository cropRepository;

    public void saveExcel(MultipartFile file, String month) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            XSSFSheet worksheet = workbook.getSheetAt(0);

            for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

                DataFormatter formatter = new DataFormatter();
                XSSFRow row = worksheet.getRow(i);

                int emptyCellCount = 0;

//                for (int j = 0; j < row.getLastCellNum(); j++) {
//                    XSSFCell cell = row.getCell(j);
//                    if (cell == null || cell.getCellType() == CellType.BLANK) {
//                        emptyCellCount++;
//                    }
//                }
//
//                if (emptyCellCount < 1) {
//                    continue;
//                }

                String item = formatter.formatCellValue(row.getCell(1));
                String name = formatter.formatCellValue(row.getCell(16));
                String accidentNumber = formatter.formatCellValue(row.getCell(7));
                String securitiesNumber = formatter.formatCellValue(row.getCell(8));
                String targetNumber = formatter.formatCellValue(row.getCell(9));
                String date = formatter.formatCellValue(row.getCell(15));
                String investigator = formatter.formatCellValue(row.getCell(16));
                String contractor = formatter.formatCellValue(row.getCell(6));

                String shortInvestigator = investigator.length() >= 3 ? investigator.substring(0, 3) : investigator;
                String shortName = name.length() >= 3 ? name.substring(0, 3) : name;
                String modifiedAccidentNumber = accidentNumber.length() >= 6?
                        accidentNumber.substring(0, 6) + "-" + accidentNumber.substring(6) : accidentNumber;

                cropRepository.save(Crop.builder()
                        .item(item)
                        .name(shortName)
                        .accidentNumber(modifiedAccidentNumber)
                        .securitiesNumber(securitiesNumber)
                        .targetNumber(targetNumber)
                        .date(date)
                        .investigator(shortInvestigator)
                        .contractor(contractor)
                        .surveyMonth(month)
                        .build());
            }
        }



    }
}
