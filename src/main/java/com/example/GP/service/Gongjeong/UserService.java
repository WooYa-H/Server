package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.Create.CreateUserDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;

import java.util.List;

public interface UserService {

    User createUser(CreateUserDTO.Request request);

    UserDTO getUser(Long id);

    List<UserDTO> getAllUsers();

    void deleteUser(Long id);

    User updateUser(UpdateUserDTO.Request request);

    UserDTO getUserByEmployeeNumber(String employeeNumber);

    List<UserDTO> getUsersByCompany(Long companyId);

    List<UserDTO> getUsersByDepartment(Long departmentId);
}
