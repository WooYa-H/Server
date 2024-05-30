package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {


}
