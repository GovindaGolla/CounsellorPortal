package com.estuate.counsellorportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.counsellorportal.dto.DashboardResponse;
import com.estuate.counsellorportal.entity.Counsellor;
import com.estuate.counsellorportal.entity.Enquiry;
import com.estuate.counsellorportal.repository.CounsellorRepository;
import com.estuate.counsellorportal.repository.EnquiryRepository;

@Service
public class CounsellorServiceImpl implements CounsellorService{
	
	@Autowired
	private CounsellorRepository counsellorrepo;
	
	@Autowired
	private EnquiryRepository enqrepo;

	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor counsellor = counsellorrepo.findByEmailAndPwd(email, pwd);
		return counsellor;
	}

	@Override
	public boolean register(Counsellor counsellor) {
		Counsellor savedcounsellor = counsellorrepo.save(counsellor);
		if(null != savedcounsellor.getCounsellorid()) {
			return true;
		}
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorid) {
		
		DashboardResponse response= new DashboardResponse();
		
		List<Enquiry> enqList = enqrepo.getEnquiresByCounsellor(counsellorid);
		
		int totalenq=enqList.size();
		
		int enrolledEnqs= enqList.stream()
				                 .filter(e -> e.getEnq_status().equals("Enrolled"))
				                 .collect(Collectors.toList())
				                 .size();
		
		int lostEnqs= enqList.stream()
				             .filter(e -> e.getEnq_status().equals("Lost"))
				             .collect(Collectors.toList())
				             .size();
		
		int openEnqs = enqList.stream()
				              .filter(e -> e.getEnq_status().equals("Open"))
				              .collect(Collectors.toList())
				              .size();
		
		
		
		response.setTotalEnqs(totalenq);
		response.setEnrolledEnqs(enrolledEnqs);
		response.setLostEnqs(lostEnqs);
		response.setOpenEnqs(openEnqs);
		return response;
		
	}

	@Override
	public Counsellor findByEmail(String email) {
		return counsellorrepo.findByEmail(email);
	}
    
	
}
