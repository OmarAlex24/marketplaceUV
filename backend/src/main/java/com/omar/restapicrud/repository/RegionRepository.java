package com.omar.restapicrud.repository;

import com.omar.restapicrud.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {
    boolean existsByRegionNameIgnoreCase(String regionName);
}
