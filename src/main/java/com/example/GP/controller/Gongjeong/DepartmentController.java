package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.Create.CreateDepartmentDTO;
import com.example.GP.dto.Gongjeong.Delete.DeleteDTO;
import com.example.GP.dto.Gongjeong.DepartmentDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateDepartmentDTO;
import com.example.GP.service.Gongjeong.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/department")
    public ResponseEntity<DepartmentDTO> getDepartment(
            @RequestParam("departmentId") Long departmentId) {

        return ResponseEntity.ok(departmentService.getDepartment(departmentId));
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {

        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping("/department/delete")
    public ResponseEntity<DeleteDTO.Response> deleteDepartment(
            @Valid @RequestParam("departmentId") Long departmentId) {
        departmentService.deleteDepartment(departmentId);

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }

    @PutMapping("/department/update")
    public ResponseEntity<UpdateDepartmentDTO.Response> updateDepartment(
            @Valid @RequestBody UpdateDepartmentDTO.Request request) {

        return ResponseEntity.ok(
                UpdateDepartmentDTO.Response.from(departmentService.updateDepartment(request)));
    }
}
