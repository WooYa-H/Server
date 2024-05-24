package com.example.excel.controller.excel;

import com.example.excel.domain.excel.Nh;
import com.example.excel.dto.excel.NhMonth;
import com.example.excel.service.excel.NhService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class NhController {

    private final NhService nhService;

    @PostMapping("/nh")
    public void nhInsertExcel(@RequestParam("file") MultipartFile file,
                          @RequestParam("month") String month) throws IOException {
        nhService.nhSaveExcel(file, month);
    }

    @GetMapping("/result")
    public ResponseEntity<List<Nh>> listExcel(@RequestBody @Valid NhMonth.Request request) {

        return ResponseEntity.ok(nhService.getNonMatchingNh(request.getMonth()));
    }

    @GetMapping("/date")
    public ResponseEntity<List<Nh>> getNhData(@RequestBody @Valid NhMonth.Request request) {

        return ResponseEntity.ok(nhService.getNhDate(request.getMonth()));
    }
}
