package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.dto.Gongjeong.CreateDepartmentDTO;
import com.example.GP.exception.Gonjeong.DepartmentException;
import com.example.GP.repository.Gongjeong.DepartmentRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department createDepartment(CreateDepartmentDTO.Request request) {

        if (departmentRepository.existsByDepartmentName(request.getDepartmentName())) {
            throw new DepartmentException(ErrorCode.DEPARTMENT_NAME_DUPLICATED);
        }

        Department department = departmentRepository.save(Department.builder()
                .createAt(LocalDateTime.now())
                .departmentName(request.getDepartmentName())
                .departmentHead(request.getDepartmentHead())
                .build());

        return department;
    }
}
