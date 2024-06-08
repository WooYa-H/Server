package com.example.GP.controller.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.CompanyDTO;
import com.example.GP.dto.Gongjeong.Create.CreateCompanyDTO;
import com.example.GP.dto.Gongjeong.Delete.DeleteDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateCompanyDTO;
import com.example.GP.service.Gongjeong.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @Valid @RequestParam("companyid") Long companyId) {

        return ResponseEntity.ok(companyService.getCompany(companyId));
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getCompanies() {

        return ResponseEntity.ok(companyService.getAllCompany());
    }

    @PostMapping("/company/delete")
    public ResponseEntity<DeleteDTO.Response> deleteCompany(
            @Valid @RequestBody DeleteDTO.Request request) {

        companyService.deleteCompany(request.getId());

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }

    @PutMapping("/company/update")
    public ResponseEntity<UpdateCompanyDTO.Response> updateCompany(
            @Valid @RequestBody UpdateCompanyDTO.Request request) {

        return ResponseEntity.ok(UpdateCompanyDTO.Response.from(
                companyService.updateCompany(request)));
    }



}
