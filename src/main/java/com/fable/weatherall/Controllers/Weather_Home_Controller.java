package com.fable.weatherall.Controllers;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.Admin_User_Entities.ApiKeyUrl;
import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.DTOs.UserDTO;
import com.fable.weatherall.FoodEntites.Food;
import com.fable.weatherall.Repos.FoodRepo;
import com.fable.weatherall.Repos.UserRepo;
import com.fable.weatherall.Services.AdminService;
import com.fable.weatherall.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Weather_Home_Controller {

	
	@Autowired
    private UserRepo userRepo;
	
	@Autowired
	private FoodRepo foodrepo;

	
	@Autowired
	private UserService userService;
	
	  @Autowired
      private AdminService adminService;

	
	@GetMapping("/home")
    public String displayHome() {
        return "Homepage";
    }
	
	@GetMapping("/comlogin")
	public String displayLogin() {
        return "comlogin";
    }
	
	@GetMapping("/signup")
	public String displaySignup() {
        return "signup";
    }
	
	@GetMapping("/user_dashboard")
	public String displayUserDashboard() {
        return "user";
    }
	

//	@GetMapping("/user_profile")
//	public String displayUserProfile() {
//        return "user_profile";
//    }
	
	@GetMapping("/admin_dashboard")
	public String displayAdminDashboard() {
        return "admin_dashboard";
    }
	
	@GetMapping("/map-google")
	public String displayMap() {
        return "map-google";
    }
	
	@GetMapping("/about")
	public String displayAboutPage() {
        return "about";
    }
	
	@GetMapping("/forgetPassword")
	public String forgetPassword() {
        return "forgetPassword";
    }
	
	
	@GetMapping("/feedback")
	public String displayfeedbackPage() {
        return "s_feedback";
    }
	
	@GetMapping("/forecast")
	public String displayForecast() {
        return "Forecast";
    }
	
	
//	@GetMapping("/addusr")
//	public String displayForm() {
//        return "addusr";
//    }
	
//	  @GetMapping("/pages-profile")
//	    public String adminprofile(HttpSession session,Model model) {
//	    	System.out.println("Hi");
//	    	return "/pages-profile";
//	    }
//	    
	
	
//	 @GetMapping("/getAllfood")
//	 public List<Food> allFoods(){
//   	 
//   	 List<Food> a=foodrepo.findAll();
//   	 
//   	 return a;
//   	 
//    }
	
	    @PostMapping("/update_api")
	    public String updateApi(@ModelAttribute("update") ApiKeyUrl apikeyurl) {
	            
	             //System.out.println("In the method");  	  
	  	  
	            //String id = 
	             
            adminService.update_ApiKeyUrl(apikeyurl);
	            
	        return "redirect:/api/view"; // Redirect to a different page after successful user addition
	    }
	    

	    @PostMapping("/update_admin")
	    public String updateAdminprofile(@ModelAttribute("update") User update) {
	            
            adminService.update_Admin(update);
	            
	        return "redirect:/view_adminprofile"; // Redirect to a different page after successful user addition
	    }

	
//	    @PostMapping("/update_api")
//	    public void updateApi() {
//	            
//	             System.out.println("In the method");  	  
//	  	  
//	            //String id = 
//	    	ApiKeyUrl apikeyurl_in = new ApiKeyUrl();
//	    	
//	    	apikeyurl_in.setApikey("8c8f2a026dd44c7ee20c5a1a657bd2fa");
//	    	apikeyurl_in.setApiurl("https://api.openweathermap.org/data/2.5/weather");
//	    	
//	    	
//         adminService.update_ApiKeyUrl(apikeyurl_in);
//	            
////	        return "redirect:/api/view"; // Redirect to a different page after successful user addition
//	    }
	 
	      @PostMapping("/u_add")
	      public String saveUser(@ModelAttribute("userAdd") UserDTO userDTO) {
                  
	               //System.out.println("In the method");  	  
	    	  
	              //String id = 
	               
	              userService.addUserinAdmin(userDTO);
	              
	              return "redirect:/getUsers"; // Redirect to a different page after successful user addition
	      }

	      @GetMapping("/getUsers")
	      public String getAllUsers(Model model) {
	          List<User> users = userRepo.findAll();
	          model.addAttribute("users", users);
//	          System.out.println("Table");
	          return "table-basic"; // Assuming "userTable" is the Thymeleaf template name
	      }
	  	
	  	    @PostMapping("/deleteUser")
	  	    public String deleteUser(@RequestParam("userId") int userId) {
	  	        //System.out.println("agfakasbdfpkbws");
	  	    	userService.deleteUserById(userId);
	  	        // You can redirect to a different page or return a response as needed
	  	        return "redirect:/getUsers"; // Redirect to a page showing the list of users, for example
	  	    }
	
	  
	    @GetMapping("/pages-profile")
	    public String adminprofile() {
		  
//	    	System.out.println("Hi");
	    	return "pages-profile";
	    }
	  
//	    @GetMapping("/table-basic")
//	    public String admin_tablebasic() {
//	    	
//	    	return "table-basic";
//	    }
	  
//	@GetMapping("/view_adminprofile")
//    public String view_adminprofile(HttpSession session,Model model)
//	    {
//			String email = (String) session.getAttribute("adminEmail");
//			String name = userRepo.findUsernameByEmail(email);
////			String pass = (String) session.getAttribute("adminPass");
//	    	Admin admin = userRepo.findUsernameByEmail(email);
////	    	Admin admin2 = repo.findByPassword(pass);
////	    	System.out.println(email);
////    	    System.out.println("admin : " + name);
////	    	System.out.println("admin : " + admin2.getPassword());
//	    	List<Admin> user = new ArrayList<>();
//	    	List<String> user1 = new ArrayList<>();
////	    	List<Admin> user2 = new ArrayList<>();
//	    	user.add(admin);
//	    	user1.add(name);
////	    	user2.add(admin);
//	    	model.addAttribute("user", user);
//	    	model.addAttribute("user1", user1);
////	    	model.addAttribute("user2", user2);
//	    	return "/pages-profile";
//	    }
//	    @GetMapping("/view_adminprofile")
//	    public String view_adminprofile(HttpSession session, Model model) {
//	        String email = (String) session.getAttribute("adminEmail");
//
//	        // Assuming you have a User entity with the necessary fields (username, email, etc.)
//	        User admin = userRepo.findByEmail(email);
//	        String name = admin.getUsername();
//	        
//	        List<User> user = new ArrayList<>();
//	        List<String> user1 = new ArrayList<>();
//}
	@GetMapping("/view_adminprofile")
    public String view_adminprofile(HttpSession session,Model model)
	    {
		
			String email = (String) session.getAttribute("adminEmail");
			String name = userRepo.findUsernameByEmail(email);
			
//			String pass = (String) session.getAttribute("adminPass");
			
	    	User us = userRepo.findByEmail(email);
	    	
	    	
//	    	Admin admin2 = repo.findByPassword(pass);
	    	
//	    	System.out.println(email);
//    	    System.out.println("admin : " + name);
//	    	System.out.println("admin : " + admin2.getPassword());
    	    
	    	List<User> user = new ArrayList<>();
	    	List<String> user1 = new ArrayList<>();
//	    	List<Admin> user2 = new ArrayList<>();

	    	
	    	user.add(us);
	    	user1.add(name);
//	    	user2.add(admin);

//
//	        user.add(admin);
//	        user1.add(name);

	        model.addAttribute("user", user);
	        model.addAttribute("user1", user1);

	        return "/pages-profile"; // Assuming "pages-profile" is the Thymeleaf template name
	    }
	
	
	

	
	      @GetMapping("/view_userprofile")
	       public String view_userprofile(HttpSession session,Model model)
		    {
				
			//System.out.println("user profile with data");
				String email = (String) session.getAttribute("userEmail");
				String name = userRepo.findUsernameByEmail(email);
				int userid =userRepo.findUseridByEmail(email);
				
//				System.out.println(name);
				
				
//		    	User user = repo.findByEmail(email);
		    	
		    	
		    	
//		    	System.out.println("admin + " + admin.getEmail());
		    	
		    	List<String> user1 = new ArrayList<>();
		    	List<String> user2 = new ArrayList<>();
		    	List<Integer> user3 = new ArrayList<>();
		    	
		    	user1.add(email);
		    	user2.add(name);
		    	user3.add(userid);
		    	
		    	model.addAttribute("user1", user1);
		    	model.addAttribute("user2", user2);
		    	model.addAttribute("user3", user3);
//		    	System.out.println("Raja");
		    	
		    	return "userprofile";
		    }
	      
	      
	      //changes made by shweta 
//	      @GetMapping("/Foodtable")
//		    public String adminprofilefood() {
//			  
////		    	System.out.println("Hi");
//		    	return "foodtable";
//		    }
	      
	      @GetMapping("/Clothtable")
		    public String adminprofilecloth() {
			  
//		    	System.out.println("Hi");
		    	return "clothtable";
		    }
	    
	      
	      @GetMapping("/Activetable")
		    public String adminprofileactive() {
			  
//		    	System.out.println("Hi");
		    	return "activetable";
		    }
	      
	      @GetMapping("/Traveltable")
		    public String adminprofiletravel() {
			  
//		    	System.out.println("Hi");
		    	return "traveltable";
		    }
	      
//	      @GetMapping("/getAllFoodItems")
//	      public String getAllFoodItems(Model model) {
//	    	  
//	          List<User> users = userRepo.findAll();
//	          model.addAttribute("users", users);
////	          System.out.println("Table");
//	          
//	          return "table-basic"; 
//	      }
	      
	      
	     
}