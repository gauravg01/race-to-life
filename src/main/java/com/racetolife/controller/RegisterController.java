package com.racetolife.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racetolife.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	RegisterService register;

	@Value("${tokenPage}")
	private String tokenPage;

	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/register")
	public JSONObject register(@RequestParam String username,@RequestParam String password) {
		String result=register.register(username,password);
		JSONObject json = new JSONObject();
		if(result.equalsIgnoreCase("success")) {
			String token=register.generateToken(username);
			String activateLink = tokenPage+token+"&username="+username;
			String regSucc = "You have been successfully registered, An activation link is sent to your email, Please activate your account before login!";
			json.put("msg", regSucc);
			String message = "Welcome in Race to Life.<br><br>Thank you for your interest.<br><br>You have been registered successfully!<br><br>Now you can login.<br><br>Your username is "+username+"<br><br>Your password is "+password+"<br><br>Just one more step to begin your journey. To activate your account please click -> "+activateLink;
			register.sendEmail(username,username,"Registration Successful. Please verify your email",message);
			return json;
		}
		else {
			json.put("error", result);
			return json;
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/activateAccount")
	public JSONObject activateAccount(@RequestParam String token, @RequestParam String username) {
		String check=register.checkUser(username);
		JSONObject json = new JSONObject();
		if(check.equalsIgnoreCase("User activation pending!")) {
			String result=register.activateAccount(token,username);
			if(result.equalsIgnoreCase("success"))
				json.put("success", "Your account has been activated! Please Login");
			else
				json.put("error", "Token mismatch. Contact Race To Life!");
		}
		else if (check.equalsIgnoreCase("User found!"))
			json.put("error", "Already activated please login!");
		else if (check.equalsIgnoreCase("User not found, Please Register!"))
			json.put("error", "User not found! Please Register first!");
		else
			json.put("error", "Try again later");
		return json;
	}
}
