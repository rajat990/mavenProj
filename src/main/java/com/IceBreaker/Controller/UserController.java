package com.IceBreaker.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.IceBreaker.Entity.Tbl_login;
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_role;
import com.IceBreaker.Service.MenuService;
import com.IceBreaker.Service.PermissionService;
import com.IceBreaker.Service.RoleService;
import com.IceBreaker.Service.UserService;

@Controller
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	MenuService menuService;

	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService permissionService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// DashBoard
//	@RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
//	public ModelAndView first(HttpSession session) {
//		if(session.getAttribute("userName")!=null) {
//			List<Tbl_menu> parent =menuService.getParentClass((int)session.getAttribute("userRole")); 
//			Map<String, Object> model1 = new HashMap<String, Object>();
//			model1.put("par", parent);
//			return new ModelAndView("dashBoard", "model1", model1);
//		}else {
//			session.setAttribute("msg", "Please Login first");
//			return new ModelAndView("redirect:/admin");
//		}
//	}
	// Display all user
//	 @RequestMapping(value = "/showUser", method = RequestMethod.GET)
//	 public ModelAndView showuser(Model model,HttpSession session) {
//		 if(session.getAttribute("userName")!=null) {
//			 Tbl_login userBean = new Tbl_login();
//			 List<Tbl_login> users =userService.getallUser();
//			 List<Tbl_menu> parent =menuService.getParentClass((String)session.getAttribute("userRole"));
//		
//			 Map<String, Object> model1 = new HashMap<String, Object>();
//			 	model1.put("users", users);
//			 	model1.put("par", parent);
//			 return new ModelAndView("showUser", "model1", model1);
//		//return new ModelAndView("user","users",users); 
//		 }else {
//				session.setAttribute("msg", "Please Login first");
//				return new ModelAndView("redirect:/admin");
//			}
//	 }

	// redirect add user jsp
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView adduser(HttpSession session) {
		if (session.getAttribute("userName") != null) {
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			List<Tbl_role> role = roleService.getallRole();
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("role", role);
			model1.put("par", parent);
			return new ModelAndView("addUser", "model1", model1);
			// return "addUser";
		} else {
			session.setAttribute("msg", "Please Login first");
			return new ModelAndView("redirect:/admin");
		}
	}

//	 //adding new user
//	 @RequestMapping(value = "/proAdd", method = RequestMethod.POST)
//	 public String adduserpro(@ModelAttribute("name")String name, @ModelAttribute("password")String password,
//			 @ModelAttribute("email")String email,@ModelAttribute("mobile_number")String mobile_number,
//			 @ModelAttribute("role")String role, HttpServletRequest request, 
//	              @ModelAttribute MultipartFile file,@ModelAttribute("status")String status, 
//			 Model model,HttpSession session) {
//		if(session.getAttribute("userName")!=null) {
//			
//			
//			Tbl_login userBean=new Tbl_login();
//				 userBean.setEmail(email);
//				 userBean.setPassword(password);
//				// userBean.setImage(userImage);
//				 userBean.setPhone_no(mobile_number);
//				 userBean.setRole_id(role);
//				 userBean.setName(name);
//				 userBean.setStatus(status);
//				 
//				 if (!file.isEmpty()) {
//						try {
//							
//							String relativePath="/static/images/profile/";
//							
//							byte[] bytes = file.getBytes();
//							
//							
//							
//							// Creating the directory to store file
//							String rootPath = request.getSession().getServletContext().getRealPath("/");
//							
//									
//							File dir = new File(rootPath + File.separator + relativePath);
//						
//							if (!dir.exists()) {
//								
//								dir.mkdirs();
//								}
////-----------------------------------Generating Random Number for Adding in image String which is saving  -------------------------------------
//							
//						    Random rnd = new Random();
//							int n = 1000 + rnd.nextInt(9000);
//							String otp=Integer.toString(n);
//							
////-------------------------------------------------------------------------------------------------------------------------------------------------
//							// Create the file on server
//							
//							File serverFile = new File( dir.getAbsolutePath()+File.separator +otp+ file.getOriginalFilename());
//							System.out.println("*************hfjhf*********"+relativePath+serverFile.getName());
//							userBean.setUser_image(relativePath+serverFile.getName());
//							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//							stream.write(bytes);
//							stream.close();
//		
//							logger.info("Server File Location=" + serverFile.getCanonicalPath());
//		
//						} catch (Exception e) {
//							logger.info("You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
//						}
//					}else {
//						logger.info("You failed to upload " + file.getOriginalFilename() + " because the file was empty.");
//						userBean.setUser_image("#");
//					}
//		
//				 boolean out=userService.adduser(userBean);
//				 if(out!=true) {
//					 session.setAttribute("msg", "Email Id Already Registered.");
//						return "redirect:/addUser";
//				 }
//				 session.setAttribute("msg", null);
//				 return "redirect:/showUser";
//		}else {
//			session.setAttribute("msg", "Please Login first");
//			return "redirect:/admin";
//		}
//	 }

//	 
//	 //taking user id and show data of repected user id
//	 @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
//	 public ModelAndView edituser(@PathVariable("id") int id, Model model,HttpSession session) {
//		 if(session.getAttribute("userName")!=null) {
//			 Tbl_User userBean=new Tbl_User();
//				 userBean.setId(id);
//				
//				 List<Tbl_login> user =userService.getUser(id);
//				 List<Tbl_menu> parent =menuService.getParentClass((String)session.getAttribute("userRole"));
//				 List<Tbl_role> role = roleService.getallRole();
//				 Map<String, Object> model1 = new HashMap<String, Object>();  
//				 	model1.put("user", user);
//			        model1.put("par", parent);
//			        model1.put("role", role);
//			        return new ModelAndView("editUser", "model1", model1);
//				// return new ModelAndView("editUser","user",user);
//		 }else {
//				session.setAttribute("msg", "Please Login first");
//				return new ModelAndView("redirect:/admin");
//			}
//	 }

	// updating users
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateuser(@ModelAttribute("id") int id, @ModelAttribute("name") String name,
			@ModelAttribute("password") String password, @ModelAttribute("email") String email,
			@ModelAttribute("mobile_number") String mobile_number, @ModelAttribute("role") String role,
			HttpServletRequest request, @ModelAttribute MultipartFile file, @ModelAttribute("status") String status,
			Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			Tbl_login userBean = new Tbl_login();
			userBean.setId(id);
			userBean.setEmail(email);
			userBean.setPassword(password);
			// userBean.setImage(userImage);
			userBean.setPhone_no(mobile_number);
			userBean.setRole_id(role);
			userBean.setName(name);
			userBean.setStatus(status);

			if (!file.isEmpty()) {
				try {
					System.out.println("tblUsers.getEmail()");
					String relativePath = "/static/images/profile/";
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = request.getSession().getServletContext().getRealPath("/");
					File dir = new File(rootPath + File.separator + relativePath);
					if (!dir.exists())
						dir.mkdirs();
//-----------------------------------Generating Random Number for Adding in image String which is saving  --------------------------

					Random rnd = new Random();
					int n = 1000 + rnd.nextInt(9000);
					String otp = Integer.toString(n);

//----------------------------------------------------------------------------------------------------------------------------
					// Create the file on server
					File serverFile = new File(
							dir.getAbsolutePath() + File.separator + otp + file.getOriginalFilename());
					System.out.println("**********************" + relativePath + serverFile.getName());
					// userBean.setUser_image(relativePath+serverFile.getName());
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					logger.info("Server File Location=" + serverFile.getCanonicalPath());

				} catch (Exception e) {
					logger.info("You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
				}
			} else {
				logger.info("You failed to upload " + file.getOriginalFilename() + " because the file was empty.");
				// List<Tbl_User> user = userService.getUser(id);
				// Tbl_User userDetails=user.get(0);
				// userBean.setUser_image(userDetails.getUser_image());
			}

			boolean out = userService.updateuser(userBean);
			if (out != true) {
				session.setAttribute("msg", "Email Id Already Registered.");
				return new ModelAndView("redirect:/editUser/{id}");
			}
			String msg = "Update successfully";
			return new ModelAndView("redirect:/showUser", "msg", msg);
		} else {
			session.setAttribute("msg", "Please Login first");
			return new ModelAndView("redirect:/admin");
		}
	}

	// user profile
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public ModelAndView userProfile(HttpSession session) {
		if (session.getAttribute("userName") != null) {
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			List<Tbl_role> role = roleService.getRole(((String) session.getAttribute("userRole")));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("role", role);
			model1.put("par", parent);

			return new ModelAndView("userProfile", "model1", model1);
		} else {
			session.setAttribute("msg", "Please Login first");
			return new ModelAndView("redirect:/");
		}
	}

//------------------------------------------Edit user profile----------------------------------------  
	@RequestMapping(value = "/editUserProfile", method = RequestMethod.POST)
	public ModelAndView edituserprofile(@ModelAttribute("id") int id, @ModelAttribute("name") String name,
			@ModelAttribute("password") String password, @ModelAttribute("email") String email,
			@ModelAttribute("mobile_number") String mobile_number, HttpServletRequest request,
			@ModelAttribute MultipartFile file, Model model, HttpSession session) {

		if (session.getAttribute("userName") != null) {

			Tbl_login userBean = new Tbl_login();
			// ------user details ----------------
			List<Tbl_login> User = userService.getUser(id);
			// ------------------------------------
			Tbl_login userDetail = User.get(0);

			userBean.setId(id);
			userBean.setEmail(email);
			userBean.setPassword(password);

			userBean.setPhone_no(mobile_number);
			userBean.setRole_id(userDetail.getRole_id());
			userBean.setName(name);
			userBean.setStatus(userDetail.getStatus());

//					 if (!file.isEmpty()) {
//							try {
//							
//								String relativePath="/resources/profilePic/";
//								byte[] bytes = file.getBytes();
//		
//								// Creating the directory to store file
//								String rootPath = request.getSession().getServletContext().getRealPath("/");
//								System.out.println(rootPath);
//								
//								File dir = new File(rootPath + File.separator + relativePath);
//								if (!dir.exists())
//									dir.mkdirs();
////-----------------------------------Generating Random Number for Adding in image String which is saving  ----------------------
//								
//							    Random rnd = new Random();
//								int n = 1000 + rnd.nextInt(9000);
//								String otp=Integer.toString(n);
//								
////---------------------------------------------------------------------------------------------------------------------------------
//								// Create the file on server
//								File serverFile = new File(dir.getAbsolutePath() + File.separator+otp + file.getOriginalFilename());
//								System.out.println("**********************"+relativePath+serverFile.getName());
//								userBean.setProfilePic(relativePath+serverFile.getName());
//								BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//								stream.write(bytes);
//								stream.close();
//		
//								logger.info("Server File Location=>" + serverFile.getCanonicalPath());
//		
//							} catch (Exception e) {
//								logger.info("You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
//							}
//						}else {
//							logger.info("You failed to upload " + file.getOriginalFilename() + " because the file was empty.");
//								userBean.setProfilePic(userDetail.getProfilePic());
//						}

			boolean out = userService.updateuser(userBean);

			if (out != false) {
				List<Tbl_login> user = userService.getUser(id);
				Tbl_login userDetails = user.get(0);
				session.setAttribute("userId", userDetails.getId());
				session.setAttribute("name", userDetails.getName());
				session.setAttribute("userRole", userDetails.getRole_id());
				session.setAttribute("userEmail", userDetails.getEmail());
				session.setAttribute("ProfilePic", userDetails.getProfilePic());
				System.out.println(userDetails.getProfilePic() + "papa=======");
				session.setAttribute("userMobileNo", userDetails.getPhone_no());
				session.setAttribute("userPassword", userDetails.getPassword());
				System.out.println("==========" + out);
				String msg = " Profile Update successfully";
				return new ModelAndView("redirect:/userProfile", "msg", msg);
			} else {
				String msg = " Profile Not Updated";
				return new ModelAndView("redirect:/userProfile", "msg", msg);
			}
		} else {
			session.setAttribute("msg", "Please Login first");
			return new ModelAndView("redirect:/");
		}
	}

//-----------------------------Display Rest password page----------------------------------------
	@RequestMapping(value = "/restPassword", method = RequestMethod.GET)
	public ModelAndView restPassword(HttpSession session) {
		if (session.getAttribute("userName") != null) {
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			Map<String, Object> model1 = new HashMap<String, Object>();

			model1.put("message", " ");
			model1.put("par", parent);
			return new ModelAndView("restPassword", "model1", model1);
		} else {
			session.setAttribute("msg", "Please Login first");
			return new ModelAndView("redirect:/");
		}

	}

	@RequestMapping(value = "/restPasswordPro", method = RequestMethod.POST)
	public ModelAndView restpasswordpro(@ModelAttribute("id") int id, @ModelAttribute("email") String email,
			@ModelAttribute("oldPassword") String oldPassword, @ModelAttribute("newPassword") String newPassword,
			@ModelAttribute("confirmPassword") String confirmPassword, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {

			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("par", parent);
			String out = userService.restpasswordpro(id, email, oldPassword, newPassword, confirmPassword);
			if (out.equals("Your Password is Change Successfully.")) {
				model1.put("message", out);

				return new ModelAndView("restPassword", "model1", model1);

			} else {
				if (out.equals("Plz enter Password.")) {
					model1.put("message", out);
					return new ModelAndView("restPassword", "model1", model1);
				} else {
					if (out.equals("Your old password is wrong.")) {
						model1.put("message", out);
						return new ModelAndView("restPassword", "model1", model1);
					} else {
						model1.put("message", out);
						return new ModelAndView("restPassword", "model1", model1);
					}
				}
			}
		} else {
			session.setAttribute("msg", "Please Login first");

			return new ModelAndView("redirect:/");

		}

	}
	// delete user respected user id
//		 @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
//		 public String deleteuser(@PathVariable("id") int id, Model model,HttpSession session) {
//			 if(session.getAttribute("userName")!=null) {
//				 boolean out=userService.deleteuser(id);			
//				 return "redirect:/showUser";
//			 }else {
//					session.setAttribute("msg", "Please Login first");
//					return "redirect:/admin";
//				}
//		 }
//		  

}
