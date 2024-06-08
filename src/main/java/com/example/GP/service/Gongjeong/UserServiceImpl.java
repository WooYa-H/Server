package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.domain.Gongjeong.User;
import com.example.GP.dto.Gongjeong.Create.CreateUserDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;
import com.example.GP.exception.Gonjeong.UserException;
import com.example.GP.repository.Gongjeong.CompanyRepository;
import com.example.GP.repository.Gongjeong.UserRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public User createUser(CreateUserDTO.Request request) {

        int currentYear = LocalDateTime.now().getYear();
        String yearString = String.valueOf(currentYear);
        String lastTwoDigits = yearString.substring(yearString.length() -2);
        String phoneNumber = request.getPhoneNumber().substring(request.getPhoneNumber().length() - 8);

        Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(
                () -> new UserException(ErrorCode.COMPANY_NOT_FOUND));

        return userRepository.save(User.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .createAt(LocalDateTime.now())
                .employeeNumber(lastTwoDigits + phoneNumber)
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

        Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(
                () -> new UserException(ErrorCode.COMPANY_NOT_FOUND));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public UserDTO getUserByEmployeeNumber(String employeeNumber) {

        User user = userRepository.findByEmployeeNumber(employeeNumber).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        return new UserDTO(user);
    }
}
