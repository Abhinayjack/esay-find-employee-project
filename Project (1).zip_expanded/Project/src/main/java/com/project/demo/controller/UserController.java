package com.project.demo.controller;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
//Abhinandan chouhan
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.demo.entity.Employee;
import com.project.demo.entity.User;
import com.project.demo.repository.empRepo;
import com.project.demo.service.EmpService;
import com.project.demo.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private EmpService service;
	@Autowired
	private UserService uService;
	@Autowired
	private empRepo repo;
	
	@RequestMapping("/")
public String home(Model m) {	
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
	return "index";
}
	@RequestMapping("/addemp")
public String addEmpForm() {
	return "add_emp";
}
	@RequestMapping("/adduser")
public String addUserForm() {
	return "add_user";
}
	@RequestMapping(value="/log_in",method=RequestMethod.GET)
public String loginForm() {
	return "login";
}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e) {
		System.out.println(e);
		service.addEmp(e);
		
		return "redirect:/";
	}
	@PostMapping("/userregister")
	public String userRegister(@ModelAttribute User e) {
	
		//System.out.println(e);
		uService.addUser(e);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp data update succesfully");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		service.deleteEmp(id);
		return "redirect:/";
	}
	
	
	@PostMapping("/searchReg")
	public String searchReg(@RequestParam("id") int id, Model m) {    
	    Employee e = service.getEmpById(id);
	    System.out.println(e);
	    m.addAttribute("emp", e);
	    return "search";
	}
	
	@PostMapping("/searchBySkill")
	public String searchBySkill(@RequestParam("skill") String skill, Model m) {    
	    List<Employee> employees = service.getEmpBySkill(skill);
	    m.addAttribute("emp", employees);
	    System.out.println("Employees: " + employees.toString());
	    return "search"; // Assuming you have a Thymeleaf template named searchResults.html
	}
	

	 @PostMapping("/login_user")
	    public String authenticateUser(String mob, String pass, Model model) {
	        User user = uService.authenticateUser(mob, pass);
	        if (user != null) {
	            model.addAttribute("message", "Welcome, " + user.getFname()+" "+ user.getLname()+" your id is: "+ user.getId());
	            return "login";
	        } else {
	            model.addAttribute("message", "Wrong credentials. Please try again.");
	        }
	        return "login";
	    }
	
		@GetMapping("/order/{id}")
		public String request(@PathVariable int id,Model m) {
			
			Employee e=service.getEmpById(id);
			m.addAttribute("emp",e);
			
			return "order";
		}

		@RequestMapping(value="/get_request", method = RequestMethod.POST)
		public String getrequest(Model m) {
		    m.addAttribute("msg", "Request has been sent.");
		    return "requestSend";
		}
	
	
}
