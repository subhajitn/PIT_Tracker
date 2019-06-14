package com.tcs.PIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.PIT.model.Employee_details;
import com.tcs.PIT.model.PIT_Participants_Details;
import com.tcs.PIT.model.PIT_Participants_Details_PK;

public interface ParticipantRepository extends JpaRepository<PIT_Participants_Details, PIT_Participants_Details_PK> {
	@Query("SELECT u FROM PIT_Participants_Details u WHERE u.pit_participants_details_id.pit_id = :pit_id")
	List<PIT_Participants_Details> findAllByPit_id(@Param("pit_id") long pit_id);
	
	//List<PIT_Participants_Details> findByParticipant(Employee_details participant);
	List<PIT_Participants_Details> findByParticipant(String participant);
}
