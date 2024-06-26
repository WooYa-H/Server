package com.example.GP.controller.excel;

import com.example.GP.service.excel.CropService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class CropController {

    private final CropService cropService;

    @PostMapping("/crop")
    public ResponseEntity<Void> postExcel(@RequestParam("file") MultipartFile file,
                          @RequestParam("month") String month) throws IOException {
        cropService.saveExcel(file, month);
        return ResponseEntity.ok().build();
    }
}
