package com.estuate.counsellorportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estuate.counsellorportal.entity.Counsellor;

@Repository
public interface CounsellorRepository extends JpaRepository<Counsellor, Integer> {
	
	public Counsellor findByEmail(String email);
	
	public Counsellor findByEmailAndPwd(String email, String pwd); 

}
