package com.example.excel.service;

import com.example.excel.domain.Crop;
import com.example.excel.domain.Nh;
import com.example.excel.dto.ExcelDTO;
import com.example.excel.repository.CropRepository;
import com.example.excel.repository.NhRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NhServiceImpl implements NhService {

    private final NhRepository nhRepository;
    private final CropRepository cropRepository;

    public void nhSaveExcel(MultipartFile file, String month) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            XSSFSheet worksheet = workbook.getSheetAt(0);

            for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

                DataFormatter formatter = new DataFormatter();
                XSSFRow row = worksheet.getRow(i);

                String item = formatter.formatCellValue(row.getCell(7));
                String name = formatter.formatCellValue(row.getCell(19));
                String accidentNumber = formatter.formatCellValue(row.getCell(8));
                String securitiesNumber = formatter.formatCellValue(row.getCell(6));
                String targetNumber = formatter.formatCellValue(row.getCell(2));
                String date = formatter.formatCellValue(row.getCell(1));
                String investigator = formatter.formatCellValue(row.getCell(19));
                String contractor = formatter.formatCellValue(row.getCell(5));

                nhRepository.save(Nh.builder()
                        .item(item)
                        .name(name)
                        .accidentNumber(accidentNumber)
                        .securitiesNumber(securitiesNumber)
                        .targetNumber(targetNumber)
                        .date(date)
                        .investigator(investigator)
                        .contractor(contractor)
                        .month(month)
                        .bad("미정")
                        .build());
            }
        }
    }

    public List<ExcelDTO> equalNh(String month) {

        List<Crop> excelDTOList = new ArrayList<>();
        List<Crop> cropData = cropRepository.findByMonth(month);
        List<Nh> nhData = nhRepository.findByMonth(month);

        for (Crop crop : cropData) {
            boolean foundMatch = false;

            for (Nh nh : nhData) {
                if (crop.getItem().equals(nh.getItem()) &&
                        crop.getName().equals(nh.getName()) &&
                        crop.getAccidentNumber().equals(nh.getAccidentNumber()) &&
                        crop.getSecuritiesNumber().equals(nh.getSecuritiesNumber()) &&
                        crop.getTargetNumber().equals(nh.getTargetNumber()) &&
                        crop.getDate().equals(nh.getDate()) &&
                        crop.getInvestigator().equals(nh.getInvestigator())) {
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                excelDTOList.add(crop);
            }
        }
        return excelDTOList.stream()
                .map(ExcelDTO::new)
                .toList();
    }

    public List<Nh> getNhDate(String month) {

        return nhRepository.findByMonth(month);
    }

    public List<Nh> getNonMatchingNh(String month) {

        List<Crop> cropData = cropRepository.findByMonth(month);
        List<Nh> nhData = nhRepository.findByMonth(month);

        for (Nh nh : nhData) {

            for (Crop crop : cropData) {
                if (nh.getItem().equals(crop.getItem()) &&
                        nh.getDate().equals(crop.getDate()) &&
                        nh.getName().equals(crop.getName()) &&
                        nh.getInvestigator().equals(crop.getInvestigator()) &&
                        nh.getSecuritiesNumber().equals(crop.getSecuritiesNumber()) &&
                        nh.getTargetNumber().equals(crop.getTargetNumber()) &&
                        nh.getContractor().equals(crop.getContractor()) &&
                        nh.getAccidentNumber().equals(crop.getAccidentNumber()) &&
                        nh.getMonth().equals(crop.getMonth())
                ) {
                    nhRepository.save(Nh.builder()
                                    .id(nh.getId())
                                    .item(nh.getItem())
                                    .name(nh.getName())
                                    .investigator(nh.getInvestigator())
                                    .date(nh.getDate())
                                    .securitiesNumber(nh.getSecuritiesNumber())
                                    .targetNumber(nh.getTargetNumber())
                                    .contractor(nh.getContractor())
                                    .accidentNumber(nh.getAccidentNumber())
                                    .month(nh.getMonth())
                                    .bad("일치").build());
                }
            }
        }
        return nhRepository.findByBad("일치");
    }
}
