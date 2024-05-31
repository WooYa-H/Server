package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    boolean existsByBusinessName(String name);
}
