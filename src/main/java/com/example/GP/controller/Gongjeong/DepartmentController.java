package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.CreateCompanyDTO;
import com.example.GP.dto.Gongjeong.CreateDepartmentDTO;
import com.example.GP.service.Gongjeong.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping("/department")
    public ResponseEntity<CreateDepartmentDTO.Response> createDepartment(
            @Valid @RequestBody CreateDepartmentDTO.Request request) {

        return ResponseEntity.ok(CreateDepartmentDTO.Response.from(
                departmentService.createDepartment(request)));
    }
}
