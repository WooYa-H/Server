package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.dto.Gongjeong.CreateDepartmentDTO;

public interface DepartmentService {

    Department createDepartment(CreateDepartmentDTO.Request request);
}
