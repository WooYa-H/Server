package com.example.excel.service.excel;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CropService {
    void saveExcel(MultipartFile file, String month) throws IOException;
}
