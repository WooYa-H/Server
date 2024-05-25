package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByName(String name);
}
