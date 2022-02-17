package com.acme.cache.service.databasing.dao;

import com.acme.cache.service.databasing.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long> {
}
