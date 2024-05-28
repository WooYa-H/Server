package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.dto.Gongjeong.Create.CreateDepartmentDTO;
import com.example.GP.dto.Gongjeong.DepartmentDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateDepartmentDTO;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(CreateDepartmentDTO.Request request);

    DepartmentDTO getDepartment(Long id);

    List<DepartmentDTO> getAllDepartment();

    void deleteDepartment(Long id);

    Department updateDepartment(UpdateDepartmentDTO.Request request);
}
