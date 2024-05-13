package com.example.excel.repository;

import com.example.excel.domain.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {


    List<Crop> findByMonth(String month);
}
