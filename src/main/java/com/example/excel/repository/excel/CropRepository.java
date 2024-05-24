package com.example.excel.repository.excel;

import com.example.excel.domain.excel.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {


    List<Crop> findBySurveyMonth(String month);
}
