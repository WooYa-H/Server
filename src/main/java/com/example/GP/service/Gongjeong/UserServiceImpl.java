package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.*;
import com.example.GP.dto.Gongjeong.Create.CreateUserDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;
import com.example.GP.exception.Gonjeong.UserException;
import com.example.GP.repository.Gongjeong.*;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final BusinessRepository businessRepository;
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

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

    public List<UserDTO> getUsersByCompany(Long companyId) {

        Company company = companyRepository.findById(companyId).orElseThrow(
                () -> new UserException(ErrorCode.COMPANY_NOT_FOUND));

        List<Department> departments = departmentRepository.findAllByCompany_Id(company.getId());

        List<Long> departmentIds = departments.stream()
                .map(Department::getId)
                .collect(Collectors.toList());

        List<Business> businesses = businessRepository.findAllByDepartmentIdIn(departmentIds);

        List<Long> businessIds = businesses.stream()
                .map(Business::getId)
                .collect(Collectors.toList());

        List<Team> teams = teamRepository.findAllByBusinessIdIn(businessIds);

        List<Long> teamIds = teams.stream()
                .map(Team::getId)
                .collect(Collectors.toList());

        List<TeamMember> teamMembers = teamMemberRepository.findAllByTeamIdIn(teamIds);

        List<Long> userIds = teamMembers.stream()
                .map(TeamMember::getUser)
                .map(User::getId)
                .collect(Collectors.toList());

        List<UserDTO> userDTOS = userRepository.findAllById(userIds).stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());

        return userDTOS;
    }

    public List<UserDTO> getUsersByDepartment(Long departmentId) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new UserException(ErrorCode.DEPARTMENT_NOT_FOUND));

        List<Business> businesses = businessRepository.findAllByDepartment_Id(department.getId());

        List<Long> businessIds = businesses.stream()
                .map(Business::getId)
                .collect(Collectors.toList());

        List<Team> teams = teamRepository.findAllByBusinessIdIn(businessIds);

        List<Long> teamIds = teams.stream()
                .map(Team::getId)
                .collect(Collectors.toList());

        List<TeamMember> teamMembers = teamMemberRepository.findAllByTeamIdIn(teamIds);

        List<Long> userIds = teamMembers.stream()
                .map(TeamMember::getUser)
                .map(User::getId)
                .collect(Collectors.toList());

        List<UserDTO> userDTOS = userRepository.findAllById(userIds).stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());

        return userDTOS;
    }
}
