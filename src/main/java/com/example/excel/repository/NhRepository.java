package com.example.excel.repository;

import com.example.excel.domain.Crop;
import com.example.excel.domain.Nh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhRepository extends JpaRepository<Nh, Long> {

    List<Nh> findByMonth(String month);

    List<Nh> findByBad(String bad);
}
