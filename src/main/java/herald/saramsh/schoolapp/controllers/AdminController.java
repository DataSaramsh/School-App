package herald.saramsh.schoolapp.controllers;

import java.util.List;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import herald.saramsh.schoolapp.domain.Activities;
import herald.saramsh.schoolapp.domain.Enrolledstudent;
import herald.saramsh.schoolapp.domain.Feestructure;
import herald.saramsh.schoolapp.services.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	AdminService adminserviceimpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(Model model) {
		return "admin/index";
		}
	
	@RequestMapping(value = "feestructures",method=RequestMethod.GET)
    public String getFeestructuresPage(Model model){
		//add all the feestructures as well as new feestructure object to be bound with a form 
		List<Feestructure> allfeestructures=adminserviceimpl.getAllFeestructures();
		model.addAttribute("allfees",allfeestructures);
		Feestructure feestructure = new Feestructure();
		model.addAttribute("fee",feestructure);
		return "admin/feestructures";
		}
	
	@RequestMapping(method=RequestMethod.POST, value={"feestructures"})
	public String addNewFeestructure(@ModelAttribute("fee") @Valid Feestructure feestructure,
			BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return "admin/feestructures";
		}
		
		adminserviceimpl.addNewFeestructure(feestructure);
		
		return "redirect:/admin/feestructures?message=New Feestructure is added";	
		
	}
	@RequestMapping(value="activities",method=RequestMethod.GET)
	public String getActivitiesPage(Model model) {
		
		Activities activity=new Activities();
		model.addAttribute("acti",activity);
		
		return"admin/activities";
		}
	
	@RequestMapping(method=RequestMethod.POST, value={"activities"})
	public String addNewActivities(HttpServletRequest servletRequest,@ModelAttribute("acti") @Valid Activities activity,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return"admin/activities";
		}
		
		adminserviceimpl.addNewActivities(activity);
		return "redirect:/admin/activities?message=New Activities is added";
	}
	@RequestMapping(value = "enrolledstudents",method=RequestMethod.GET)
	public String getAllEnrolledstudents(Model model) {
		List<Enrolledstudent> allenrolledstudents=adminserviceimpl.getAllEnrolledstudent();
		model.addAttribute("allenrolledstudents",allenrolledstudents);
		return"admin/enrolledstudents";
		
	}
}
