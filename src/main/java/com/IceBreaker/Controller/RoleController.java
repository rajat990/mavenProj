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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_role;
import com.IceBreaker.Service.MenuService;
import com.IceBreaker.Service.RoleService;

@Controller
@CrossOrigin
public class RoleController {

	@Autowired
	MenuService menuService;

	@Autowired
	RoleService roleService;

	// add new role

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public ModelAndView addRole(@ModelAttribute("roleName") String roleName, @ModelAttribute("status") String status,
			Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			Tbl_role roleBean = new Tbl_role();
			roleBean.setRoleName(roleName);
			roleBean.setStatus(status);
			boolean output = roleService.addrole(roleBean);

			return new ModelAndView("redirect:/showRole");
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

	// redirect add menu jsp

	// Display all roles

	@RequestMapping(value = "/showRole", method = RequestMethod.GET)
	public ModelAndView showRole(Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			Tbl_role roleBean = new Tbl_role();
			List<Tbl_role> roles = roleService.getallRole();

			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "s>>>>>>>>>>>>>");
			model1.put("roles", roles);
			model1.put("par", parent);
			return new ModelAndView("showRole", "model1", model1);
			// return new ModelAndView("menu","users",users);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

	// taking menu id and show data of repected menu id

	@RequestMapping(value = "/editRole/{id}", method = RequestMethod.GET)
	public ModelAndView editrole(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			Tbl_role roleBean = new Tbl_role();
			roleBean.setId(id);

			List<Tbl_role> role = roleService.getRole(String.valueOf(id));

			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("role", role);
			model1.put("par", parent);
			return new ModelAndView("editRole", "model1", model1);
			// return new ModelAndView("editMenu","menu",menu);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}

	}

	// updating menu

	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public ModelAndView updateRole(@ModelAttribute("id") int id, @ModelAttribute("roleName") String rolename,
			@ModelAttribute("status") String status, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			Tbl_role roleBean = new Tbl_role();
			roleBean.setId(id);
			roleBean.setRoleName(rolename);
			roleBean.setStatus(status);

			boolean out = roleService.updateRole(roleBean);

			String msg = "Update successfully";

			return new ModelAndView("redirect:/showRole", "msg", msg);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

	// delete user respected menu id

	@RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.GET)
	public ModelAndView deleteRole(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			boolean out = roleService.deleteRole(id);
			return new ModelAndView("redirect:/showRole");
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}

	}

}
