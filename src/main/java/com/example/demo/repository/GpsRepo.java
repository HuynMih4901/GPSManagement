package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Gps;

public interface GpsRepo extends JpaRepository<Gps, Integer> {
	@Query(value = "SELECT * FROM Gps g WHERE g.name LIKE CONCAT('%',:key,'%')", nativeQuery = true)
	List<String> findGpsByProviderAndName(@Param("key") String key);

	@Query(value = "SELECT g.*, c.code from Gps g, Category c" + " where g.code = c.code"
			+ " and c.code = :code ", nativeQuery = true)
	List<Map<String, Object>> findByType(@Param("code") String code);
}
