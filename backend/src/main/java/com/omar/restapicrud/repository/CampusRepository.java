package com.omar.restapicrud.repository;

import com.omar.restapicrud.model.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus,Long> {
    Boolean existsByCampusNameIgnoreCase(String campus);
}
