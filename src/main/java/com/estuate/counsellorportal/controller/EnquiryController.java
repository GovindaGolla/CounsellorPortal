package com.estuate.counsellorportal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estuate.counsellorportal.dto.ViewEnquiryFilterRequest;
import com.estuate.counsellorportal.entity.Enquiry;
import com.estuate.counsellorportal.service.CounsellorService;
import com.estuate.counsellorportal.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private EnquiryService enquiryservice;

	public EnquiryController(EnquiryService enquiryservice) {
		this.enquiryservice = enquiryservice;
	}

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {
		Enquiry enqobj = new Enquiry();

		model.addAttribute("enq", enqobj);

		return "enquiryform";
	}

	@PostMapping("/filter-enqs")
	public String filterEnquiries(
			@ModelAttribute("viewenqsfilterrequest") ViewEnquiryFilterRequest viewenqsfilterrequest,
			HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		Integer counsellorid = (Integer) session.getAttribute("counsellorid");

		List<Enquiry> enquiresWithFilter = enquiryservice.getEnquiresWithFilter(viewenqsfilterrequest, counsellorid);

		model.addAttribute("enquiress", enquiresWithFilter);

		return "viewenqspage";
	}

	@GetMapping("/editEnq")
	public String editEnquiryPage(@RequestParam("enq_id") Integer enq_id, Model model) {
		
		Enquiry enquiryById = enquiryservice.getEnquiryById(enq_id);
		
		model.addAttribute("enq", enquiryById);

		return "enquiryform";
	}

	@GetMapping("/view-enquires")
	public String getEnquires(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellorid = (Integer) session.getAttribute("counsellorid");

		List<Enquiry> allEnquires = enquiryservice.getAllEnquires(counsellorid);

		model.addAttribute("enquiress", allEnquires);

		ViewEnquiryFilterRequest filerReq = new ViewEnquiryFilterRequest();
		model.addAttribute("viewenqsfilterrequest", filerReq);

		return "viewenqspage";
	}

	@PostMapping("/addEnquiry")
	public String handleAddEnquiry(@ModelAttribute("enq") Enquiry enq, HttpServletRequest req, Model model)
			throws Exception {

		HttpSession session = req.getSession(false);

		Integer counsellorid = (Integer) session.getAttribute("counsellorid");

		boolean isSaved = enquiryservice.addEnquiry(enq, counsellorid);

		if (isSaved) {
			model.addAttribute("smsg", "Enquiry Added Successfully..");
		} else {
			model.addAttribute("emsg", "Failed to add Enquiry");
		}

		return "enquiryform";
	}

}
