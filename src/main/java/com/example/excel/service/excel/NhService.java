package com.example.excel.service.excel;

import com.example.excel.domain.excel.Nh;
import com.example.excel.dto.ExcelDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NhService {
    void nhSaveExcel(MultipartFile file, String month) throws IOException;

    List<ExcelDTO> equalNh(String month);

//    public List<Nh> getNonMatchingNh(String month);
    List<Nh> getNonMatchingNh(String month);

    List<Nh> getNhDate(String month);


}
