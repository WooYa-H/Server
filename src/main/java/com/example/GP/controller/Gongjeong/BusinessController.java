package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.BusinessDTO;
import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;
import com.example.GP.dto.Gongjeong.Delete.DeleteDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateBusinessDTO;
import com.example.GP.service.Gongjeong.BusinessService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping("/business")
    public ResponseEntity<CreateBusinessDTO.Response> createBusiness(
            @Valid @RequestBody CreateBusinessDTO.Request request) {

        return ResponseEntity.ok(CreateBusinessDTO.Response.from(
                businessService.createBusiness(request)));
    }

    @GetMapping("/business")
    public ResponseEntity<BusinessDTO> getBusiness(
            @RequestParam("businessId") Long id) {

        return ResponseEntity.ok(businessService.getBusinessById(id));
    }

    @GetMapping("/businesses")
    public ResponseEntity<List<BusinessDTO>> getBusinesses() {

        return ResponseEntity.ok(businessService.getAllBusiness());
    }

    @PutMapping("/business")
    public ResponseEntity<UpdateBusinessDTO.Response> updateBusiness(
            @Valid @RequestBody UpdateBusinessDTO.Request request) {

        return ResponseEntity.ok(UpdateBusinessDTO.Response.from(
                businessService.updateBusiness(request)));
    }

    @PostMapping("/business/delete")
    public ResponseEntity<DeleteDTO.Response> deleteBusiness(
            @Valid @RequestBody DeleteDTO.Request request) {

        businessService.deleteBusiness(request.getId());

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }
}
