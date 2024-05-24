package com.example.excel.repository.Gongjeong;

import com.example.excel.domain.Gongjeong.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
