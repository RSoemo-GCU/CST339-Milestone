package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.model.DatabaseModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display register Form view
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new UserModel());
		return "register";
	}
	
	@RequestMapping("/saveaccount")
	public String saveAccount(UserModel newuser)
	{
		DatabaseModel.addUser(newuser);
		System.out.println("Saved new user: " + newuser.toString());
		System.out.println("Total accounts:" + DatabaseModel.getSize());
		return "home";
	}
	
	
	/*@PostMapping("/doregister")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Registeration Form");
			return "register";
		}
		
		model.addAttribute("userModel", userModel);
		
		return "home";
	}*/
}