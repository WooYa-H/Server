package com.example.excel.controller.Gongjeong;

import com.example.excel.service.Gongjeong.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


}
