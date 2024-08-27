package com.estuate.counsellorportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estuate.counsellorportal.entity.Enquiry;


@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {
	
	@Query(value = "SELECT * FROM Enquiry WHERE counsellor_id = :counsellorid", nativeQuery = true)
	public List<Enquiry> getEnquiresByCounsellor(Integer counsellorid);

}
