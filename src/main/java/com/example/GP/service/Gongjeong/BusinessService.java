package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.dto.Gongjeong.BusinessDTO;
import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateBusinessDTO;

import java.util.List;

public interface BusinessService {

    Business createBusiness(CreateBusinessDTO.Request request);

    BusinessDTO getBusinessById(Long id);

    List<BusinessDTO> getAllBusiness();

    Business updateBusiness(UpdateBusinessDTO.Request request);

    void deleteBusiness(Long id);
}
