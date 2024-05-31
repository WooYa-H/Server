package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.dto.Gongjeong.BusinessDTO;
import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;
import com.example.GP.exception.Gonjeong.BusinessException;
import com.example.GP.repository.Gongjeong.BusinessRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;


    public Business createBusiness(CreateBusinessDTO.Request request) {

        return businessRepository.save(Business.builder()
                .businessName(request.getBusinessName())
                .agency(request.getAgency())
                .build());
    }

    public BusinessDTO getBusinessById(Long id) {

        Business business = businessRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.BUSINESS_NOT_FOUND));

        return new BusinessDTO(business);
    }

    public List<BusinessDTO> getAllBusiness() {

        List<Business> businessList = businessRepository.findAll();

        return businessList.stream()
                .map(BusinessDTO::new)
                .collect(Collectors.toList());
    }
}
