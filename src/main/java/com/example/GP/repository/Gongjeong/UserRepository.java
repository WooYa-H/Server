package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCompanyId(Long companyId);

    Optional<User> findByEmployeeNumber(String employeeNumber);
}
