package com.tcs.PIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.PIT.model.PIT_Details;
import com.tcs.PIT.model.PIT_Details_PK;

public interface PitDetailsRepository extends JpaRepository<PIT_Details, PIT_Details_PK> { 
	
	@Query(value = "SELECT PIT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	long getNextPitId();
	@Query("SELECT u FROM PIT_Details u WHERE u.pit_details_id.pit_id = :pit_id") 
	List<PIT_Details> findAllByPit_id(@Param("pit_id") long pit_id);
}
