package yu.chap6.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yu.chap6.model.MemberVO;
import yu.chap6.repository.MemberRepository;

@Controller
@RequestMapping ("/ex2/login")
public class loginController {
	@Autowired 
	MemberRepository dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginReq(Model model) {
		return "loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String loginProcess(HttpServletRequest request, Model model) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HashMap<String, Boolean> errors = new HashMap<>();
		
		if(email == null || email.isEmpty()) 
		{
			errors.put("email", true);
		}
		
		if(password == null || password.isEmpty()) 
		{
			errors.put("password", true);
		}
		
		if(!errors.isEmpty()) 
		{
			model.addAttribute("errors", errors);
			return "errorPage";
		}
		
		MemberVO member = dao.getMemberByEmail(email);
		
		if (member == null) 
		{
			errors.put("notfound", true);
		}
		else if (!member.getPassword().equals(password)) 
		{
			errors.put("mismatch", true);
		}
		
		if(!errors.isEmpty()) 
		{
			model.addAttribute("errors", errors);
			return "errorPage";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("login", member);
		
		return "redirect:list";
	}
}
