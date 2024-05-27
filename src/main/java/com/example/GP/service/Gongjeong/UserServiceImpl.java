package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.CreateUserDTO;
import com.example.GP.repository.Gongjeong.UserRepository;
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
}
