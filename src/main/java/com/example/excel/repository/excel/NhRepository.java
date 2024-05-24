package com.example.excel.repository.excel;

import com.example.excel.domain.excel.Nh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhRepository extends JpaRepository<Nh, Long> {

    List<Nh> findBySurveyMonth(String month);

    List<Nh> findByRecordMatch(String bad);
}
