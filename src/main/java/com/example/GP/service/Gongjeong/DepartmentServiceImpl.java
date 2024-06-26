package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.domain.Gongjeong.Department;
import com.example.GP.dto.Gongjeong.Create.CreateDepartmentDTO;
import com.example.GP.dto.Gongjeong.DepartmentDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateDepartmentDTO;
import com.example.GP.exception.Gonjeong.CompanyException;
import com.example.GP.exception.Gonjeong.DepartmentException;
import com.example.GP.repository.Gongjeong.CompanyRepository;
import com.example.GP.repository.Gongjeong.DepartmentRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;

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

    public DepartmentDTO getDepartment(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new DepartmentException(ErrorCode.DEPARTMENT_NOT_FOUND));

        return new DepartmentDTO(department);
    }

    public List<DepartmentDTO> getAllDepartment() {

       return departmentRepository.findAll()
               .stream()
               .map(department -> {
                   DepartmentDTO departmentDTO = new DepartmentDTO();
                   departmentDTO.setId(department.getId());
                   departmentDTO.setDepartmentName(department.getDepartmentName());
                   departmentDTO.setDepartmentHead(department.getDepartmentHead());
                   departmentDTO.setCreateAt(department.getCreateAt());
                   departmentDTO.setUpdateAt(department.getUpdateAt());
                   return departmentDTO;
               })
               .collect(Collectors.toList());
    }

    public void deleteDepartment(Long id) {

        departmentRepository.findById(id).orElseThrow(
                () -> new DepartmentException(ErrorCode.DEPARTMENT_NOT_FOUND));

        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(UpdateDepartmentDTO.Request request) {

        Department department = departmentRepository.findById(request.getId())
                .orElseThrow(() -> new DepartmentException(ErrorCode.DEPARTMENT_NOT_FOUND));

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new CompanyException(ErrorCode.COMPANY_NOT_FOUND));

        department.setDepartmentName(request.getDepartmentName());
        department.setDepartmentHead(request.getDepartmentHead());
        department.setCompany(company);
        department.setUpdateAt(LocalDateTime.now());

        return departmentRepository.save(department);
    }
}
