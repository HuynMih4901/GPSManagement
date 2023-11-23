package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Subscribe;

public interface SubscribeRepo extends JpaRepository<Subscribe, Integer>{

	@Query(value = "SELECT * FROM Gps g WHERE g.name LIKE CONCAT('%',:key,'%')", nativeQuery = true)
	List<String> findSubscribe(@Param("key") String key);
}
