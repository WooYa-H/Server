package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.CompanyDTO;
import com.example.GP.dto.Gongjeong.Create.CreateCompanyDTO;
import com.example.GP.dto.Gongjeong.DepartmentDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateCompanyDTO;
import com.example.GP.repository.Gongjeong.CompanyRepository;
import com.example.GP.exception.Gonjeong.CompanyException;
import com.example.GP.repository.Gongjeong.DepartmentRepository;
import com.example.GP.repository.Gongjeong.UserRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;


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

        List<DepartmentDTO> departmentDTOList = departmentRepository.findAllByCompany_Id(company.getId())
                .stream()
                .map(DepartmentDTO::new)
                .collect(Collectors.toList());

        return new CompanyDTO(company, departmentDTOList);
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

    public Company updateCompany(UpdateCompanyDTO.Request request) {

        Company company = companyRepository.findById(request.getId())
                .orElseThrow(() -> new CompanyException(ErrorCode.COMPANY_NOT_FOUND));

        company.setId(request.getId());
        company.setName(request.getName());
        company.setAddress(request.getAddress());
        company.setEmail(request.getEmail());
        company.setBusinessNumber(request.getBusinessNumber());
        company.setPhoneNumber(request.getPhoneNumber());

        return companyRepository.save(company);
    }





}
