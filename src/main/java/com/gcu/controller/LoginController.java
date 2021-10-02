package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.model.DatabaseModel;
import com.gcu.model.LoginModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/login")
public class LoginController
{
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/")
	public String display(Model model)
	{
		// Display login Form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new UserModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		else if (DatabaseModel.findLogin(loginModel) != true)
		{
			return "login";
		}
		
		model.addAttribute("loginModel", loginModel);
		return "LoginSuccess";
	}
}