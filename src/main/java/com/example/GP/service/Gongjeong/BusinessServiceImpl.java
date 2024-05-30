package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;
import com.example.GP.repository.Gongjeong.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
