package com.racetolife.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racetolife.service.ForgetPassService;
import com.racetolife.service.RegisterService;
import com.racetolife.util.CommonUtility;

@RestController
public class SessionController {

	@Autowired
	CommonUtility com;

	@Autowired
	ForgetPassService service;
	
	@Autowired
	RegisterService regService;

	@SuppressWarnings("unchecked")
	@GetMapping("/login")
	public JSONObject showLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
            HttpServletRequest request) {
		JSONObject json = new JSONObject();
		if(error!=null) {
			json.put("error","Invalid username or password!");
		}
		if (logout != null) {
			json.put("msg", "You've been logged out successfully.");
		}
		return json;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/checkUser")
	public JSONObject checkUser(@RequestParam(value="username",required=true) String username) {
		JSONObject json = new JSONObject();
		json.put("error",regService.checkUser(username));
		return json;
	}
	
	@GetMapping("/forget-password")
	public String showForgetPassPage() {
		return "forget-password";
	}

	@PostMapping("/forget-password")
	public String  getForgetPass(ModelMap model,@RequestParam String email) {
		String result = service.getForgetPass(email);
		if (result.equalsIgnoreCase("error")) {
			model.put("errorMessage", result);
			return "forget-password";
		}
		else if (result.equalsIgnoreCase("register")) {
			model.put("newUserMessage", "User does not exist! Please Register first");
			return "forget-password";
		}
		else {
			model.put("userPassword", "Your password has been sent on your registered email! Please check uou email.");
			com.sendEmail(" ",email, "Password to log in TMS", "Your password is "+result);
			return "forget-password";
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/logout")
	public JSONObject logout(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		JSONObject json = new JSONObject();
		json.put("msg", "signedout");
		return json;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/")
	public JSONObject login() {
		JSONObject json = new JSONObject();
		json.put("name", getLoggedInUserName());
		return json;
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

}