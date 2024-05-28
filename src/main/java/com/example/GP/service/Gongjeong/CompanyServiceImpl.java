package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.dto.Gongjeong.CompanyDTO;
import com.example.GP.dto.Gongjeong.Create.CreateCompanyDTO;
import com.example.GP.repository.Gongjeong.CompanyRepository;
import com.example.GP.exception.Gonjeong.CompanyException;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;


    public Company createCompany(CreateCompanyDTO.Request request) {

        if (companyRepository.existsByName(request.getName())) {
            throw new CompanyException(ErrorCode.COMPANY_NAME_DUPLICATED);
        }


        Company company = companyRepository.save(Company.builder()
                .ceo(request.getCeo())
                .email(request.getEmail())
                .address(request.getAddress())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .businessNumber(request.getBusinessNumber())
                .build());

        return  company;
    }

    public CompanyDTO getCompany(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyException(ErrorCode.COMPANY_NOT_FOUND));


        return new CompanyDTO(company);
    }

    public List<Company> getAllCompany() {

         List<Company> companyList = companyRepository.findAll();

         return companyList;
    }

    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyException(ErrorCode.COMPANY_NOT_FOUND));

        companyRepository.deleteById(company.getId());
    }




}
