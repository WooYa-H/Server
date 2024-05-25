package com.example.GP.repository.excel;

import com.example.GP.domain.excel.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {


    List<Crop> findBySurveyMonth(String month);
}
