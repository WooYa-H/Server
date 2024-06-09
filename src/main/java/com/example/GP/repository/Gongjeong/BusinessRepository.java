package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.domain.Gongjeong.Department;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    boolean existsByBusinessName(String name);

    @Query("SELECT b FROM Business b WHERE b.department.id IN :departmentIds")
    List<Business> findAllByDepartmentIdIn(@Param("departmentIds") List<Long> departmentIds);

    List<Business> findAllByDepartment_Id(Long departmentId);
}
