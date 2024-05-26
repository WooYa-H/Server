package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Department;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDTO {

    private Long id;

    private String departmentName;

    private String departmentHead;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
        this.departmentHead = department.getDepartmentHead();
        this.createAt = department.getCreateAt();
        this.updateAt = department.getUpdateAt();
    }
}
