package com.estuate.counsellorportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.estuate.counsellorportal.dto.ViewEnquiryFilterRequest;
import com.estuate.counsellorportal.entity.Counsellor;
import com.estuate.counsellorportal.entity.Enquiry;
import com.estuate.counsellorportal.repository.CounsellorRepository;
import com.estuate.counsellorportal.repository.EnquiryRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	private CounsellorRepository counsellorrepo;
	
	private EnquiryRepository enquiryRepo;
	
	

	public EnquiryServiceImpl(CounsellorRepository counsellorrepo, EnquiryRepository enquiryRepo) {
		this.counsellorrepo = counsellorrepo;
		this.enquiryRepo = enquiryRepo;
	}

	@Override
	public boolean addEnquiry(Enquiry Enq, Integer counsellorid) throws Exception {
		Counsellor counsellor = counsellorrepo.findById(counsellorid).orElse(null);
		if(counsellor==null) {
			throw new Exception("No Counsellor Found");
		}
		Enq.setCounsellor(counsellor);
		Enquiry save = enquiryRepo.save(Enq);
		if(save.getEnq_id()!=null) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<Enquiry> getAllEnquires(Integer counsellorid) {
		return enquiryRepo.getEnquiresByCounsellor(counsellorid);
	}

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnquiryFilterRequest filterReq, Integer counsellorid) {
    
		Enquiry enq=new Enquiry();
		
		if(StringUtils.isNotEmpty(filterReq.getClassMode())) {
			enq.setClass_mode(filterReq.getClassMode());
		}
		
		if(StringUtils.isNotEmpty(filterReq.getCourseName())) {
			enq.setCourse_name(filterReq.getCourseName());
		}
		
		if(StringUtils.isNotEmpty(filterReq.getEnqStatus())) {
			enq.setEnq_status(filterReq.getEnqStatus());
		}
		
		Counsellor counsellor  = counsellorrepo.findById(counsellorid).orElse(null);
		enq.setCounsellor(counsellor);
		Example<Enquiry> of= Example.of(enq);
		List<Enquiry> enqlist=enquiryRepo.findAll(of);
		
		return enqlist;
			
	}

	@Override
	public Enquiry getEnquiryById(Integer enq_id) {
		return enquiryRepo.findById(enq_id).orElse(null);
	}
   
	

}
