package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
