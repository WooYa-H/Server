package com.example.GP.controller.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.dto.Gongjeong.CompanyDTO;
import com.example.GP.dto.Gongjeong.CreateCompanyDTO;
import com.example.GP.service.Gongjeong.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping("/company")
    public ResponseEntity<CreateCompanyDTO.Response> createCompany(
            @Valid @RequestBody CreateCompanyDTO.Request request) {

        return ResponseEntity.ok(
                CreateCompanyDTO.Response.from(companyService.createCompany(request)));
    }

    @GetMapping("/company")
    public ResponseEntity<CompanyDTO> getCompany(
            @Valid @RequestParam("companyId") Long companyId) {

        return ResponseEntity.ok(companyService.getCompany(companyId));
    }


}
