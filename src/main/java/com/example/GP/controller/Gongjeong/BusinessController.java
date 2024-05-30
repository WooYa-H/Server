package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.Create.CreateBusinessDTO;
import com.example.GP.service.Gongjeong.BusinessService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
