package com.example.GP.controller.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.dto.Gongjeong.CreateCompanyDTO;
import com.example.GP.service.Gongjeong.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
