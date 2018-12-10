package com.neptune.springhospitalsystem.controllers;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neptune.springhospitalsystem.model.LoginModel;
import com.neptune.springhospitalsystem.model.PostPaymentModel;
import com.neptune.springhospitalsystem.model.RegisterModel;
import com.neptune.springhospitalsystem.model.SearchModel;
import com.neptune.springhospitalsystem.model.ShareModel;

import org.springframework.beans.factory.annotation.Autowired;
import com.neptune.springhospitalsystem.service.LoginService;
import com.neptune.springhospitalsystem.service.PostPaymentService;
import com.neptune.springhospitalsystem.service.RegisterPatientService;
import com.neptune.springhospitalsystem.service.ReportService;
import com.neptune.springhospitalsystem.service.SearchService;
import com.neptune.springhospitalsystem.service.SingleReportService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 
	 @Autowired
	 private ShareModel shareModel;
	 
	//display the landing page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home", "loginBean", new LoginModel());
	}
	
	 @Autowired
	 private LoginService loginService;
	//process the user login info
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String processLoginInfo(Model model, @ModelAttribute("loginBean") LoginModel loginBean){
		String loginId, password,page;
	loginId = loginBean.getLoginId();
	password = loginBean.getPassword();
		boolean result = loginService.processLogin(loginId, password);
		if(result == true){
			model.addAttribute("fname",shareModel.getFirstName());
			page = "default";
		}
		else{
			model.addAttribute("msg", shareModel.getShortMessage());
			page = "home";	
				
		}
	   
		return page;
	}
	
	
	//handler method for displaying the page after login
	@RequestMapping(value="/login/default", method=RequestMethod.GET)
	public String defaultPage(Model model){
     model.addAttribute("fname", shareModel.getFirstName());
		return "default";
	}
	
	//handler method for displaying the patient registration page
		@RequestMapping(value="/login/register", method=RequestMethod.GET)
		public ModelAndView registerPatientPage(Model model){
			 model.addAttribute("fname", shareModel.getFirstName());
			 return new ModelAndView("register-patient","registerPatientBean", new RegisterModel());
		}
		
		//handler method for processing the patient details during registration
		 @Autowired
		 RegisterPatientService registerPatientService;
		 @RequestMapping(value="/login/register", method=RequestMethod.POST)
			public String procesPatientReg(@ModelAttribute("registerPatientBean") RegisterModel registerModel, Model model){
			String fName, midName,lName,phoneOffice,email,phoneHome,address,username;
			int adminId = shareModel.getAdminId();
			fName = registerModel.getFirstName();
			midName = registerModel.getMiddleName();
			lName = registerModel.getLastName();
			phoneOffice = registerModel.getPhoneOffice();
			email = registerModel.getEmail();
			phoneHome = registerModel.getPhoneHome();
			address = registerModel.getAddress();
			username = registerModel.getUsername();
			boolean result = registerPatientService.registerPatient(adminId, fName, midName, lName, phoneOffice, phoneHome, email, username, address);
			if(result==true){
				model.addAttribute("msg", shareModel.getShortMessage());
			}
			else{
				model.addAttribute("msg", shareModel.getShortMessage());
			}
			     model.addAttribute("fname",shareModel.getFirstName());
				return "register-patient";
		}
		 
	//handler method for displaying the post-payment page
	@RequestMapping(value="/login/post-payment",method = RequestMethod.GET)
	public ModelAndView postPaymentPage(Model model){
		 model.addAttribute("fname", shareModel.getFirstName());
		 return new ModelAndView("post-payment","postPaymentBean", new PostPaymentModel());
	}
	
	//handler method for processing the completed payments for patients on the post-payment page
	 @Autowired
	 PostPaymentService paymentService;
	@RequestMapping(value="/login/post-payment",method=RequestMethod.POST)
	public String processPayment(Model model, @ModelAttribute("postPaymentBean") PostPaymentModel postPayment){	
			boolean result = paymentService.registerPayment(shareModel.getAdminId(), postPayment.getPatientId(), Integer.parseInt(postPayment.getAmountPaid()),postPayment.getDescription());
			if(result==true){
				model.addAttribute("msg",shareModel.getShortMessage());
			}
			else{
				model.addAttribute("msg",shareModel.getShortMessage());
			}
	
		model.addAttribute("fname",shareModel.getFirstName());
		return "post-payment";
	}
	
	@Autowired
	ReportService reportService;
	//handler method for displaying the report page
	@RequestMapping(value="/login/report", method=RequestMethod.GET)
	public ModelAndView reportPage(Model model){
		boolean res = reportService.getPatientDetails();
		if(res==true){
		  model.addAttribute("patientData", shareModel.getPatientData());
		}
		else{
			model.addAttribute("msg",shareModel.getShortMessage());
		}
		model.addAttribute("fname", shareModel.getFirstName());
		return new ModelAndView("report","searchBean", new SearchModel());
	}
	
	@Autowired
	SearchService searchService;
	//handler method for displaying the report page
	@RequestMapping(value="/login/report", method=RequestMethod.POST)
	public String searchPage(Model model, @ModelAttribute("searchBean") SearchModel searchModel){
		boolean res = searchService.getSearchRecord(searchModel.getSearchCriteria());
		if(res==true){
		  model.addAttribute("patientData", shareModel.getPatientData());
		}
		else{
			model.addAttribute("msg",shareModel.getShortMessage());
		}
		model.addAttribute("fname", shareModel.getFirstName());
		return "report";
	}
	
	//handler method to view the report page showing the details for each patient
	@Autowired
	SingleReportService singleReportService;
	@RequestMapping(value="/login/report/view-details/{regId}", method=RequestMethod.GET)
	public String viewDetailsPage(Model model, @PathVariable("regId") int regId){
		boolean result = singleReportService.getSingleReport(regId);
		if(result==true){
			model.addAttribute("patientData",shareModel.getPatientData().get(0));
			model.addAttribute("msg",shareModel.getShortMessage());
			model.addAttribute("msg2", result);
		}
		else{
			model.addAttribute("msg",shareModel.getShortMessage());
			model.addAttribute("msg2", result);
		}
		model.addAttribute("fname",shareModel.getFirstName());
		return "view-details";
	}
	
	//process logout
	public String processLogout(){
		return "home";
	}
	
}
