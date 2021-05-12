package com.IceBreaker.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_permission;
import com.IceBreaker.Entity.Tbl_role;
import com.IceBreaker.Service.MenuService;
import com.IceBreaker.Service.PermissionService;
import com.IceBreaker.Service.RoleService;

@Controller
@CrossOrigin
public class PermissionController {

	@Autowired
	MenuService menuService;

	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService permissionService;

	@RequestMapping(value = "/permission", method = RequestMethod.GET)
	public ModelAndView permission(HttpSession session) {
		if (session.getAttribute("userName") != null) {
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			List<Tbl_role> roles = roleService.getallRole();
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("par", parent);
			model1.put("roles", roles);
			return new ModelAndView("permission", "model1", model1);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}

	}

//------------------------------------------------------------------------------------------------------------------------------------	
	@RequestMapping(value = "/setpermission", method = RequestMethod.POST)
	public ModelAndView setpermission(@ModelAttribute("select") String id, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			List role_id = new ArrayList();
			role_id.add(id);
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			List<Tbl_menu> parent1 = menuService.getallMenu();
			List<Tbl_permission> users = permissionService.getPermission(id);

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("par", parent);
			model1.put("par1", parent1);
			model1.put("user", users);
			model1.put("role_id", role_id);
			return new ModelAndView("setpermission", "model1", model1);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

//-------------------------------------------------------------------------------------------------------------------------------------	
	@RequestMapping(value = "/addpermission", method = RequestMethod.POST)

	public ModelAndView addpermission(@RequestParam("roleId") String roleId, @RequestParam("parent") String[] parent,
			@RequestParam("child") String[] child, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			String c = "", p = "";
			for (int i = 0; i < child.length; i++) {
				c += child[i] + "/";

			}

			for (int i = 0; i < parent.length; i++) {
				p += parent[i] + "/";

			}

			boolean output = permissionService.savePermission(c, p, roleId);

			return new ModelAndView("redirect:/permission");
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------

}
