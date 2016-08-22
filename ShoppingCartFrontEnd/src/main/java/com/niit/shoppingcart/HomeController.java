package com.niit.shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	//if you want to navigate
	/*@RequestMapping("/")
	public String home()
	{
		return "/Home";
	}*/
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("message","thank you for visiting");
		return mv;
	}
	
	@RequestMapping("/Register")
	public ModelAndView register()
	{
		ModelAndView mv = new ModelAndView("Register");
		mv.addObject("user click register here", "true");
		return mv;
	}
	
	@RequestMapping("/Login")
	public ModelAndView login()
	{
	
		ModelAndView mv = new ModelAndView("Login");
		mv.addObject("user click login here", "true");
		return mv;
	}
}
