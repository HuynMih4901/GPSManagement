package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ServicePackage;

public interface ServicePackageRepo extends JpaRepository<ServicePackage, Integer> {
	@Query(value = "SELECT * FROM services s WHERE s.name LIKE CONCAT('%',:key,'%') OR s.code LIKE CONCAT('%',:key,'%')", nativeQuery = true)
	List<String> findByCodeAndName(@Param("key") String key);

	@Query(value = "SELECT s.*, c.code from services s, Category c" + " where s.code = c.code"
			+ " and c.code = :code ", nativeQuery = true)
	List<Map<String, Object>> findByType(@Param("code") String code);
}
