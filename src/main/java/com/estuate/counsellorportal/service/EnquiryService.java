package com.estuate.counsellorportal.service;

import java.util.List;

import com.estuate.counsellorportal.dto.ViewEnquiryFilterRequest;
import com.estuate.counsellorportal.entity.Enquiry;

public interface EnquiryService  {
	
	
	public boolean addEnquiry(Enquiry Enq, Integer counsellorid)throws Exception;
	
	public List<Enquiry> getAllEnquires(Integer counsellorid);
	
	public List<Enquiry> getEnquiresWithFilter(ViewEnquiryFilterRequest filterReq, Integer counsellorid);
	
	public Enquiry getEnquiryById(Integer enq_id);
	
	
	
    
    
    

}
