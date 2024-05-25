package com.example.excel.service.Gongjeong;

import com.example.excel.domain.Gongjeong.Company;
import com.example.excel.dto.Gongjeong.CreateCompanyDTO;
import com.example.excel.repository.Gongjeong.CompanyRepository;
import com.example.exception.Gonjeong.CompanyException;
import com.example.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;


    private Company createCompany(CreateCompanyDTO.Request request) {

        if (companyRepository.existsByName(request.getName())) {
            throw new CompanyException(ErrorCode.COMPANY_NAME_DUPLICATED);
        }

        Company company = Company.builder()
                .ceo(request.getCeo())
                .email(request.getEmail())
                .address(request.getAddress())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .businessNumber(request.getBusinessNumber())
                .build();

        return companyRepository.save(company);
    }

    private Company getCompany(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyException(ErrorCode.COMPANY_NOT_FOUND));

        return company;
    }
}
