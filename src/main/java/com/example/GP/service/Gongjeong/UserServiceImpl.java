package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.CreateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;
import com.example.GP.exception.Gonjeong.UserException;
import com.example.GP.repository.Gongjeong.UserRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserDTO.Request request) {

        return userRepository.save(User.builder()
                .name(request.getName())
                .createAt(LocalDateTime.now())
                .build());
    }

    public UserDTO getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        return new UserDTO(user);
    }
}
