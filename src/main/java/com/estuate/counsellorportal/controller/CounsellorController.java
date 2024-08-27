package com.estuate.counsellorportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.estuate.counsellorportal.dto.DashboardResponse;
import com.estuate.counsellorportal.entity.Counsellor;
import com.estuate.counsellorportal.service.CounsellorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	
	private CounsellorService counsellorservice;
	
	public CounsellorController(CounsellorService counsellorservice) {
		this.counsellorservice = counsellorservice;
	}

	@GetMapping("/")
	public String index(Model model) {	
		Counsellor cobj=new Counsellor();	
		model.addAttribute("counsellor",cobj );
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Counsellor counsellor,HttpServletRequest request, Model model) {
		
		Counsellor c = counsellorservice.login(counsellor.getEmail(), counsellor.getPwd());
		
		if(c==null) {
			model.addAttribute("emsg","Invalid Credentials");
			return "index";
		}else {
			
			//valid login, store counsellorid in session for future purpose
			
			HttpSession session= request.getSession(true);
			session.setAttribute("counsellorid", c.getCounsellorid());
			
			DashboardResponse dobj=counsellorservice.getDashboardInfo(c.getCounsellorid());
			System.out.println("Dashboard object Created");
			model.addAttribute("dashboardInfo", dobj);
			return "dashboard";
		}
		
		
	}
	
	@GetMapping("/dashboard")
	public String displayDashboard(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);

		Integer counsellorid = (Integer) session.getAttribute("counsellorid");
		
		DashboardResponse dashboardInfo = counsellorservice.getDashboardInfo(counsellorid);
        
		model.addAttribute("dashboardInfo",dashboardInfo);
		
		return "dashboard";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		
		Counsellor cobj=new Counsellor();
		
		model.addAttribute("counsellor",cobj);
		
		return "register";
		
	}
	
	@PostMapping("/register")
	public String handleRegister(Counsellor counsellor,Model model) {
		
		Counsellor findByEmail = counsellorservice.findByEmail(counsellor.getEmail());
		
		if(findByEmail!=null) {
			model.addAttribute("emsg", "Email Exists Already");
			return "register";
		}
		
		boolean isregistered = counsellorservice.register(counsellor);
		
		if(isregistered) {
			model.addAttribute("smsg","Registration Sucessfull..!");
		}else {
			model.addAttribute("emsg", "Failed To Register..");
		}
		
		return "register";
	}
  
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
	
}
