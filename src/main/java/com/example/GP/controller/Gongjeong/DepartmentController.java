package com.example.GP.controller.Gongjeong;

import com.example.GP.service.Gongjeong.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


}
