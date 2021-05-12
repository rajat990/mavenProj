package com.IceBreaker.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IceBreaker.Entity.Tbl_login;
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Service.LoginService;
import com.IceBreaker.Service.MenuService;


@Controller

@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	MenuService menuService;

	@RequestMapping(value = "/")
	public String admin() {

		return "index";
	}

	@CrossOrigin
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ModelAndView auth(@ModelAttribute("email") String email, @ModelAttribute("password") String password,
			HttpSession session, Model model) {

		// checking login details
		Tbl_login tblUsers = loginService.auth(email, password);

		if (tblUsers != null) {

			session.setAttribute("userId", tblUsers.getId());
			session.setAttribute("userName", tblUsers.getUsername());
			session.setAttribute("userRole", tblUsers.getRole_id());
			session.setAttribute("userEmail", tblUsers.getEmail());
			session.setAttribute("name", tblUsers.getName());
			session.setAttribute("userMobileNo", tblUsers.getPhone_no());
			session.setAttribute("userPassword", tblUsers.getPassword());
			session.setAttribute("ProfilePic", tblUsers.getProfilePic());

			// getting menu according to role_id
			List<Tbl_menu> parent = menuService.getParentClass((String) tblUsers.getRole_id());

			// pass menu to dashboard
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("par", parent);
			return new ModelAndView("dashBoard", "model1", model1);
		} else {

			// login details wrong then
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

	// ----------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("userRole");
		session.removeAttribute("userEmail");
		session.removeAttribute("name");
		session.removeAttribute("ProfilePic");
		session.removeAttribute("userMobileNo");
		session.removeAttribute("userPassword");

		return "redirect:/";
	}
	// -----------------------------------------------------------------------------------------------------------
	//DashBoard 
		@RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
		public ModelAndView first(HttpSession session) {
			if(session.getAttribute("userName")!=null) {
				List<Tbl_menu> parent =menuService.getParentClass((String)session.getAttribute("userRole")); 
				Map<String, Object> model1 = new HashMap<String, Object>();
				model1.put("par", parent);
				return new ModelAndView("dashBoard", "model1", model1);
			}else {
				session.setAttribute("msg", "Please Login first");
				return new ModelAndView("redirect:/");
			}
		}
}
