package com.example.GP.dto.Gongjeong.Update;

import com.example.GP.domain.Gongjeong.Department;
import lombok.*;

import java.time.LocalDateTime;

public class UpdateDepartmentDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String departmentName;

        private String departmentHead;

        private Long companyId;

    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String departmentName;

        private String departmentHead;

        private Long companyId;

        private String ok;


        public static Response from(Department department) {

            return Response.builder()
                    .id(department.getId())
                    .departmentName(department.getDepartmentName())
                    .departmentHead(department.getDepartmentHead())
                    .companyId(department.getCompany().getId())
                    .ok("수정 완료")
                    .build();
        }
    }
}
