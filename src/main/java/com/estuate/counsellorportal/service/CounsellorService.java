package com.estuate.counsellorportal.service;

import com.estuate.counsellorportal.dto.DashboardResponse;
import com.estuate.counsellorportal.entity.Counsellor;

public interface CounsellorService {
	
  public Counsellor findByEmail(String email);
	
  public Counsellor login(String email, String pwd);
  
  public boolean register(Counsellor counsellor);
  
  public DashboardResponse getDashboardInfo(Integer counsellorid);
  
  

}
