package com.example.GP.controller.accountBook;

import com.example.GP.service.accountBook.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

}
