package com.extremity.controller;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.model.User;
import com.extremity.service.Servicee;
import com.extremity.serviceimpl.ServiceImpl;
@Controller
public class SpringBootController {
	@Autowired
	private Servicee si;
	@RequestMapping("/")
	public String welcome()
	{
		System.out.println("index page...");
		return "index";
	}
	@RequestMapping("/registerPage")
	public String register()
	{
		System.out.println("in registration page...");
		return "registration";
	}
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public ModelAndView adduser(@ModelAttribute User user,BindingResult br)
	{
	System.out.println("Add user");
	System.out.println(user.getId());
	si.saveUser(user);
	System.out.println("Added user");
	return new ModelAndView("index","msg","login successfully.....");
	}
	
     @RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginuser(@RequestParam String username,@RequestParam String password,User user) 
	{
	      
	      List<User> list=si.loginuser(username, password);
	      List<User>listuser=si.getalldata(user);
		
		return new ModelAndView("success", "userlist", listuser);
		
		
	}
     @RequestMapping(value="/delete",method=RequestMethod.GET)
     public ModelAndView deleteuser(@ModelAttribute User user,int id) 
 	{
    	 System.out.println("delete user");
    	si.deleteUser(id);
    	List<User> listuser=si.getalldata(user);
		return new ModelAndView("success", "userlist", listuser);
	
 	}
     @RequestMapping("/edit")
     public ModelAndView edituser(@ModelAttribute User user,int id) 
  	{
    	 System.out.println("edit user");
    	 User u=si.editUser(id);
    	 System.out.println(u.getId());
    	 List<User> listuser=si.getalldata(user);
    	 
		return new ModelAndView("edit", "data", listuser);
  	}

 	@RequestMapping(value="/update")
 	public ModelAndView updateUser(@ModelAttribute User user)
 	{
 		si.updateUser(user);
 		 List<User> listuser=si.getalldata(user);
    	 
 		return new ModelAndView("success", "userlist", listuser);
		 	}
 	
  	
}
