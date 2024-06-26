package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.domain.Gongjeong.Team;
import com.example.GP.dto.Gongjeong.BusinessDTO;
import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;
import com.example.GP.dto.Gongjeong.TeamDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateBusinessDTO;
import com.example.GP.exception.Gonjeong.BusinessException;
import com.example.GP.repository.Gongjeong.BusinessRepository;
import com.example.GP.repository.Gongjeong.DepartmentRepository;
import com.example.GP.repository.Gongjeong.TeamRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;
    private final TeamRepository teamRepository;
    private final DepartmentRepository departmentRepository;


    public Business createBusiness(CreateBusinessDTO.Request request) {

        if (businessRepository.existsByBusinessName(request.getBusinessName())) {
            throw new BusinessException(ErrorCode.BUSINESS_NAME_DUPLICATED);
        }

        return businessRepository.save(Business.builder()
                .businessName(request.getBusinessName())
                .agency(request.getAgency())
                .build());
    }

    public BusinessDTO getBusinessById(Long id) {

        Business business = businessRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.BUSINESS_NOT_FOUND));

        List<TeamDTO> teamDTOList = teamRepository.findByBusinessId(business.getId()).stream()
                .map(TeamDTO::new)
                .collect(Collectors.toList());

        return new BusinessDTO(business, teamDTOList);
    }

    public List<BusinessDTO> getAllBusiness() {

        List<Business> businessList = businessRepository.findAll();

        return businessList.stream()
                .map(BusinessDTO::new)
                .collect(Collectors.toList());
    }

    public Business updateBusiness(UpdateBusinessDTO.Request request) {

        Business business = businessRepository.findById(request.getId()).orElseThrow(
                () -> new BusinessException(ErrorCode.BUSINESS_NOT_FOUND));

        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                () -> new BusinessException(ErrorCode.DEPARTMENT_NOT_FOUND));


        business.setBusinessName(request.getBusinessName());
        business.setAgency(request.getAgency());
        business.setDepartment(department);

        return businessRepository.save(business);
    }

    public void deleteBusiness(Long id) {

        businessRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.BUSINESS_NOT_FOUND));

        businessRepository.deleteById(id);
    }
}
