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
import com.IceBreaker.Service.MenuService;

@Controller

@CrossOrigin
public class MenuController {

	@Autowired
	MenuService menuService;

	// Display all menu
	@RequestMapping(value = "/showMenu", method = RequestMethod.GET)
	public ModelAndView showMenu(Model model, HttpSession session) {

		if (session.getAttribute("userName") != null) {

			List<Tbl_menu> allMenu = menuService.getallMenu();

			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("users", allMenu);
			model1.put("par", parent);
			return new ModelAndView("showMenu", "model1", model1);
			// return new ModelAndView("menu","users",users);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

	// taking menu id and show data of repected menu id
	@RequestMapping(value = "/editMenu/{id}", method = RequestMethod.GET)
	public ModelAndView editmenu(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {

			List<Tbl_menu> menu = menuService.getMenu(id);

			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("menu", menu);
			model1.put("par", parent);

			return new ModelAndView("editMenu", "model1", model1);
			// return new ModelAndView("editMenu","menu",menu);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

	// updating menu
	@RequestMapping(value = "/editMenu/updateMenu", method = RequestMethod.POST)
	public ModelAndView updateuser(@ModelAttribute("id") int id, @ModelAttribute("menu_name") String menu_name,
			@ModelAttribute("url") String url, @ModelAttribute("parent_class") String parent_class,
			@ModelAttribute("status") String status, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			Tbl_menu menuBean = new Tbl_menu();
			menuBean.setId(id);
			menuBean.setMenu_name(menu_name);
			menuBean.setUrl(url);
			menuBean.setIcon_class("");
			menuBean.setParent_class(parent_class);
			menuBean.setPriority("");
			menuBean.setStatus(status);

			boolean out = menuService.updatemenu(menuBean);
			if (out == true) {
				String msg = "Update successfully";
				return new ModelAndView("redirect:/showMenu", "msg", msg);
			} else {
				String msg = "Sorry not Updated";
				return new ModelAndView("redirect:/showMenu", "msg", msg);
			}
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

	// delete user respected menu id
	@RequestMapping(value = "/deleteMenu/{id}", method = RequestMethod.GET)
	public ModelAndView deleteuser(@PathVariable("id") int id, Model model, HttpSession session) {

		if (session.getAttribute("userName") != null) {
			boolean out = menuService.deletemenu(id);
			if (out == true) {
				String msg = "Deleted successfully";
				return new ModelAndView("redirect:/showMenu", "msg", msg);
			} else {
				String msg = "Sorry not Deleted";
				return new ModelAndView("redirect:/showMenu", "msg", msg);
			}

		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

	// add new menu
	@RequestMapping(value = "/addMenuPro", method = RequestMethod.POST)
	public ModelAndView addmenupro(@ModelAttribute("menu_name") String menu_name, @ModelAttribute("url") String url,
			@ModelAttribute("parent_class") String parent_class, @ModelAttribute("status") String status, Model model,
			HttpSession session) {

		if (session.getAttribute("userName") != null) {
			Tbl_menu menuBean = new Tbl_menu();
			menuBean.setMenu_name(menu_name);
			menuBean.setUrl(url);
			menuBean.setIcon_class("");
			menuBean.setParent_class(parent_class);
			menuBean.setPriority("");
			menuBean.setStatus(status);
			boolean output = menuService.addmenu(menuBean);

			return new ModelAndView("redirect:/showMenu");
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}
	}

	// redirect add menu jsp
	@RequestMapping(value = "/addMenu", method = RequestMethod.GET)
	public ModelAndView addmenu(HttpSession session) {
		if (session.getAttribute("userName") != null) {
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			List<Tbl_menu> parent1 = menuService.getallMenu();
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("par1", parent1);
			model1.put("par", parent);
			return new ModelAndView("addMenu", "model1", model1);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("index", "model1", model1);
		}

	}
}
