package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.dto.Gongjeong.BusinessDTO;
import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;

public interface BusinessService {

    Business createBusiness(CreateBusinessDTO.Request request);

    BusinessDTO getBusinessById(Long id);

}
