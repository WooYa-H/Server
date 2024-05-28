package com.example.GP.dto.Gongjeong.Create;

import com.example.GP.domain.Gongjeong.Department;
import lombok.*;

public class CreateDepartmentDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private String departmentName;

        private String departmentHead;

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

        private String ok;


        public static CreateDepartmentDTO.Response from(Department department) {

            return Response.builder()
                    .id(department.getId())
                    .departmentName(department.getDepartmentName())
                    .departmentHead(department.getDepartmentHead())
                    .ok("부서를 생성 완료하였습니다.")
                    .build();
        }
    }


}
