package herald.saramsh.schoolapp.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import herald.saramsh.schoolapp.dao.UserDao;
import herald.saramsh.schoolapp.domain.Activities;
import herald.saramsh.schoolapp.domain.User;
import herald.saramsh.schoolapp.services.UserService;
import herald.saramsh.schoolapp.services.exceptions.UserAlreadyPresentException;
import herald.saramsh.schoolapp.domain.User;

@Controller
@RequestMapping(value="/")
public class MainPageController {
	
	@Autowired
	private UserService userserviceimpl;
	
	/**
	 * 
	 * @param principal
	 * @return return username as a common model attribute for all pages 
	 */
	@ModelAttribute("username")
	  String getUserName(Principal principal) {
		if(principal!=null)
			return principal.getName();
		else
			return null;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(Model model,HttpServletRequest request){
		
		//get all Activities to be shown in home page 
		model.addAttribute("allactivities",userserviceimpl.getAllActivities());
		//show index.jsp page
				return "index";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String getLoginPage(Model model) {
		model.addAttribute("log","Thank you");
		return "login";
		}
	
	@RequestMapping(value = "register",method=RequestMethod.GET)
	public String getRegisterPage(Model model) {
		model.addAttribute("msg","Welcome, Please fill the form");
		
		//send new domain object
		model.addAttribute("user",new User());
		return "register";
		}
	
    @RequestMapping(method=RequestMethod.POST, value={"register"})
	public String insertNewUser(@ModelAttribute("user") @Valid User newuser,
			BindingResult bindingResult){
		
		//validate the form data
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		try {
			boolean result=userserviceimpl.registerUser(newuser);
			if (result)
				return "redirect:register?message=Registration is successful";	
			else
				return "redirect:register?message=Unknown problem occured! Please contact administrator";	
			
		} catch (UserAlreadyPresentException e) {
			bindingResult.rejectValue("username", "username", e.getMessage()); 
			return "register";
		}	
	}
    @RequestMapping(value = "logout/success",method=RequestMethod.GET)
	public String logoutSuccess(Model model) {
		
		return "redirect:/?message=Logout Successful";
		}
	
	@RequestMapping(value = "login/failure",method=RequestMethod.GET)
	public String loginFailure(Model model) {
		
		return "redirect:/?message=Unable to login.Please check your username and password";
		}
	

}