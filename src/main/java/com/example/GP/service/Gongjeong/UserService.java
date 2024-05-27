package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.CreateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;

public interface UserService {

    User createUser(CreateUserDTO.Request request);

    UserDTO getUser(Long id);

}
