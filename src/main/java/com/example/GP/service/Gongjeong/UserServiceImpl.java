package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.CreateUserDTO;
import com.example.GP.dto.Gongjeong.UpdateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;
import com.example.GP.exception.Gonjeong.UserException;
import com.example.GP.repository.Gongjeong.UserRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setName(user.getName());
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        userRepository.deleteById(user.getId());
    }

    public User updateUser(UpdateUserDTO.Request request) {

        User user = userRepository.findById(request.getId()).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
