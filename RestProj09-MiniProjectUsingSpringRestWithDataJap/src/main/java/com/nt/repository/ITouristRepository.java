package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {
	@Query(value = "FROM Tourist WHERE tname=:name")
	public List<Tourist> fetchTouristByName(@Param("name") String name);
	@Query(value = "DELETE FROM Tourist WHERE budget >=:start and budget <=:end")
	@Modifying
	@Transactional
	public Integer deleteByBudgetRange(@Param("start") double start,@Param("end") double end);
}
