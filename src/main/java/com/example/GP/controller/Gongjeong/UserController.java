package com.example.GP.controller.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.Create.CreateUserDTO;
import com.example.GP.dto.Gongjeong.Delete.DeleteDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;
import com.example.GP.service.Gongjeong.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<CreateUserDTO.Response> createUser(
            @Valid @RequestBody CreateUserDTO.Request request) {

        return ResponseEntity.ok(CreateUserDTO.Response.from(
                userService.createUser(request)));
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUser(
            @RequestParam("userId") Long userId) {

        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/user/delete")
    public ResponseEntity<DeleteDTO.Response> deleteUser(
            @RequestBody DeleteDTO.Request request) {

        userService.deleteUser(request.getId());

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }

    @PutMapping("/user/update")
    public ResponseEntity<UpdateUserDTO.Response> updateUser(
            @Valid @RequestBody UpdateUserDTO.Request request) {

        return ResponseEntity.ok(UpdateUserDTO.Response.from(
                userService.updateUser(request)));
    }

    @GetMapping("/user/employee")
    public ResponseEntity<UserDTO> getUserByEmployee(
            @RequestParam("employee") String employeeNumber) {

        return ResponseEntity.ok(userService.getUserByEmployeeNumber(employeeNumber));
    }
    @GetMapping("/users/company")
    public ResponseEntity<List<UserDTO>> getUsersByCompany(
            @RequestParam("companyId") Long companyId) {

        return ResponseEntity.ok(userService.getUsersByCompany(companyId));
    }


    @GetMapping("/users/department")
    public ResponseEntity<List<UserDTO>> getUsersByDepartment(
            @RequestParam("departmentId") Long departmentId) {

        return ResponseEntity.ok(userService.getUsersByDepartment(departmentId));
    }

    @GetMapping("/users/business")
    public ResponseEntity<List<UserDTO>> getUsersByBusiness(
            @RequestParam("businessId") Long businessId) {

        return ResponseEntity.ok(userService.getUsersByBusiness(businessId));
    }

    @GetMapping("/users/team")
    public ResponseEntity<List<UserDTO>> getUsersByTeam(
            @RequestParam("teamId") Long teamId) {

        return ResponseEntity.ok(userService.getUsersByTeam(teamId));
    }
}
