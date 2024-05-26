package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.dto.Gongjeong.CreateDepartmentDTO;
import com.example.GP.dto.Gongjeong.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(CreateDepartmentDTO.Request request);

    DepartmentDTO getDepartment(Long id);

    List<DepartmentDTO> getAllDepartment();
}
