package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.dto.Gongjeong.CompanyDTO;
import com.example.GP.dto.Gongjeong.CreateCompanyDTO;

public interface CompanyService {

    Company createCompany(CreateCompanyDTO.Request request);

    CompanyDTO getCompany(Long id);
}
