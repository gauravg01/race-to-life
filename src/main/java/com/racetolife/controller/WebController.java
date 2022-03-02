package com.racetolife.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.racetolife.model.UserDetailsDO;
import com.racetolife.service.ForgetPassService;
import com.racetolife.service.RegisterService;
import com.racetolife.service.UserService;
import com.racetolife.util.CommonUtility;

@Controller
public class WebController{

	@Autowired
	CommonUtility com;

	@Autowired
	ForgetPassService service;

	@Autowired
	RegisterService regService;
	
	@Autowired
	UserService userService;

	@Value("${tokenPage}")
	private String tokenPage;

	@GetMapping("/loginWeb")
	public String showLoginPage(ModelMap model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
			HttpServletRequest request, HttpServletResponse response) {

		if(error!=null) {
			model.put("error","Invalid username or password!");
		}
		if (logout != null) {
			model.put("msg", "You've been logged out successfully.");
		}
		
		if(SecurityContextHolder.getContext().getAuthentication() != null &&
				 SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			model.put("logout", "true");
			model.put("profile", "true");
		}
		else {
			model.put("login", "true");
			model.put("register", "true");
		}
		return "home";
	}
	
	@PostMapping("/loginWeb")
	public String showLoginPagePost(ModelMap model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
			HttpServletRequest request, HttpServletResponse response) {

		if(error!=null) {
			model.put("error","Invalid username or password!");
		}
		if (logout != null) {
			model.put("msg", "You've been logged out successfully.");
		}
		
		if(SecurityContextHolder.getContext().getAuthentication() != null &&
				 SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			model.put("logout", "true");
			model.put("profile", "true");
		}
		else {
			model.put("login", "true");
			model.put("register", "true");
		}
		return "home";
	}
	
	@GetMapping("/home")
	public String showHomePageGet(ModelMap model) {
		if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && 
				!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			model.put("logout", "true");
			model.put("profile", "true");
		}
		else {
			model.put("login", "true");
			model.put("register", "true");
		}
		return "home";
	}
	
	@GetMapping("/")
	public String showIndexPageGet(ModelMap model) {
		if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && 
				!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			model.put("logout", "true");
			model.put("profile", "true");
		}
		else {
			model.put("login", "true");
			model.put("register", "true");
		}
		return "home";
	}


	@GetMapping("/reset-password-web")
	public String showForgetPassPageGet() {
		return "reset-password";
	}

	@PostMapping("/reset-password-web")
	public String  getForgetPassPost(ModelMap model,@RequestParam String email) {
		String result = service.getForgetPass(email);
		if (result.equalsIgnoreCase("error")) {
			model.put("errorMessage", result);
			return "reset-password";
		}
		else if (result.equalsIgnoreCase("register")) {
			model.put("newUserMessage", "User does not exist! Please Register first");
			return "reset-password";
		}
		else {
			model.put("userPassword", "Your password has been sent on your registered email! Please check your email.");
			com.sendEmail(" ",email, "Password to log in Race to Life", "Your password is "+result);
			return "reset-password";
		}
	}

	@GetMapping("/logoutWeb")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home";
	}

	@GetMapping("/registerWeb")
	public String showRegisterPageGet() {
		return "register";
	}

	@PostMapping("/registerWeb")
	public String registerPost(ModelMap model,@RequestParam String email,@RequestParam String password) {
		String result=regService.register(email,password);
		if(result.equalsIgnoreCase("success")) {
			String token=regService.generateToken(email);
			String activateLink = tokenPage+token+"&username="+email;
			String regSucc = "You have been successfully registered, An activation link is sent to your email, Please activate your account before login!";
			model.put("regSuccessMessage", regSucc);
			String message = "Welcome in Race to Life.<br><br>Thank you for your interest.<br><br>You have been registered successfully!<br><br>Now you can login.<br><br>Your username is "+email+"<br><br>Your password is "+password+"<br><br>Just one more step to begin your journey. To activate your account please click -> <a href=\""+activateLink+"\"><b>Activate</b></a>";
			regService.sendEmail(email,email,"Registration Successful. Please verify your email",message);
			return "register";
		}
		else if(result.equalsIgnoreCase("User already exists, Please login!")) {
			model.put("dupErrorMessage", "Account exists already! Please Login");
			return "register";
		}
		else {
			model.put("regErrorMessage", "Error while registering! Please try Later!");
			return "register";
		}
	}

	@GetMapping("/activateAccountWeb")
	public String activateAccountGet(ModelMap model,@RequestParam String token, @RequestParam String username) {
		String check=regService.checkUser(username);
		if(check.equalsIgnoreCase("User activation pending!")) {
			String result=regService.activateAccount(token,username);
			if(result.equalsIgnoreCase("success"))
				model.put("success", "Your account has been activated! Please Login");
			else
				model.put("error", "Token mismatch. Contact Race to Life!");
		}
		else if (check.equalsIgnoreCase("User found!"))
			model.put("error", "Already activated please login!");
		else if (check.equalsIgnoreCase("User not found, Please Register!"))
			model.put("error", "User not found! Please Register first!");
		else
			model.put("error", "Try again later");
		return "activateAccount";
	}

	@PostMapping("/subscribeWeb")
	public String newsletterSubscriptionPost(ModelMap model,@RequestParam String email) {
		regService.sendEmail(email,email,"Subscription confirmed!","Welcome to Race to life");
		model.put("message", "Congratulations! You are now subscribed to our newsletter.");
		return "home";
	}
	
	@PostMapping("/contactFormWeb")
	public String contactFormSubmissionPost(ModelMap model, @RequestParam (required=false) String name, @RequestParam (required=false) String phone, @RequestParam String email, @RequestParam String message) {
		if (name== null || name=="" || name.equalsIgnoreCase(""))
			name="Anonymous";
		regService.sendEmail("Gaurav","gauravg.tcet@gmail.com","Contact from Website!","From: "+name+" Email:"+email+"<br><br>"+"Message: "+message);
		model.put("message", "Thanks for contacting us! We will revert you soon.");
		return "home";
	}
	
	//Profile
	@GetMapping("/myProfile")
	public String showProfilePage(ModelMap model) {
		String email=getLoggedInEmail();
		UserDetailsDO user = userService.getUserDetails(email);
		model.put("user", user);
		return "myProfile";
	}

	@PostMapping("/changePassword")
	public String changePassword(ModelMap model,@RequestParam String passwordOld, @RequestParam String passwordNew) {
		String emailId=getLoggedInEmail();
		String oldPassword = getLoggedInEmailPassword(emailId);
		if(!passwordNew.equals(passwordOld)) {
			if(passwordOld.equals(oldPassword)) {
				String result=userService.changePassword(emailId,passwordNew);
				if(result.equalsIgnoreCase("success")) {
					model.put("successMessageCP", "Password changed successfully!");
					com.sendEmail(emailId,emailId, "Password changed successfully!", "Password changed successfully to "+passwordNew);
				}
				else {
					model.put("errorMessageCP", "Error while changing password! Please try Later!");
				}
			}
			else
				model.put("errorMessageCP", "Incorrect Password! Please try again with correct Password!");
		}
		else
			model.put("errorMessageCP", "Password cannot be same as earlier!");
		return "myProfile";
	}

	@PostMapping("/changeEmail")
	public String changeEmail(ModelMap model,@RequestParam String newEmail,@RequestParam String password) {
		String oldEmail=getLoggedInEmail();
		if(!oldEmail.equalsIgnoreCase(newEmail))
		{
			if(password.equals(getLoggedInEmailPassword(oldEmail))) {
				String result=userService.changeEmail(oldEmail,newEmail);
				if(result.equalsIgnoreCase("success")) {
					model.put("successMessageCE", "Email changed successfully! Please Login again!");
				}
				else {
					model.put("errorMessageCE", "Error while changing password! Please try Later!");
				}
			}
			else {
				model.put("errorMessageCE", "Incorrect Password! Please try again with correct Password!");
			}
		}
		else
			model.put("errorMessageCE", "Email cannot be same as earlier!");
		return "myProfile";
	}
	
	private String getLoggedInEmail() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
	
	private String getLoggedInEmailPassword(String email) {
		return (userService.getPassword(email));
	}
	
}
