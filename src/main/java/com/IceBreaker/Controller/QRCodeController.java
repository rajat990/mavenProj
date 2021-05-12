package com.IceBreaker.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.IceBreaker.Config.FileStorageService;
import com.IceBreaker.Entity.TblLocation;
import com.IceBreaker.Entity.Tbl_QrCode;
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Service.MenuService;
import com.IceBreaker.Service.QrCodeService;

@Controller
@CrossOrigin
public class QRCodeController {
	@Autowired
	MenuService menuService;

	@Autowired
	QrCodeService qrcodeService;

	@Autowired
	FileStorageService fileStorageService;
	private static final Logger logger = LoggerFactory.getLogger(QRCodeController.class);

	// Add ORcode
	@RequestMapping(value = "/GenerateQrCode", method = RequestMethod.GET)
	public ModelAndView showMenuq(Model model, HttpSession session, HttpServletRequest request) {

		if (session.getAttribute("userName") != null) {
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("par", parent);
			return new ModelAndView("GenerateQrCode", "model1", model1);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

//--------------------------------------------------------------------------------------------------
	// add new menu
	@RequestMapping(value = "/addQrcode", method = RequestMethod.POST)
	public ModelAndView addQRCode(@ModelAttribute("clubName") String clubName,
			@ModelAttribute("locationIdentifier") String locationIdentifier,
			@ModelAttribute("distance") String distance, @ModelAttribute("longitude") String longitude,
			@ModelAttribute("latitude") String latitude, @ModelAttribute("type") String type,
			@ModelAttribute("locationPhoneNumber") String locationPhoneNumber,
			@ModelAttribute("locationEmail") String locationEmail, @ModelAttribute("clubAddress") String clubAddress,
			@ModelAttribute("status") String status, Model model, HttpSession session, HttpServletRequest request) {

		if (session.getAttribute("userName") != null) {
			String rootPath = request.getServletContext().getRealPath("/");
			File dir = new File(rootPath + "uploads/images/profile/");
			String path = rootPath + "uploads/images/profile/";
			if (!dir.exists())
				dir.mkdirs();
			TblLocation location = new TblLocation();
			location.setLocationName(clubName);
			location.setLocationIdentifier(locationIdentifier);
			location.setDistance(distance);
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			location.setType(type);
			location.setLocationPhoneNumber(locationPhoneNumber);
			location.setLocationEmail(locationEmail);
			location.setLocationAddress(clubAddress);
			location.setStatus(status);
			
			String output = qrcodeService.addQrCode(location, path, request);
			return new ModelAndView("redirect:/showQRCode");
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}
//--------------------------------------------------------------------------------------------------

	// taking menu id and show data of repected menu id
	@RequestMapping(value = "/editQRCode/{id}", method = RequestMethod.GET)
	public ModelAndView editQrCodeid(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("userName") != null) {

			List<TblLocation> QrCode = qrcodeService.getQRCodeDetails(id);

			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("QrCode", QrCode);
			model1.put("par", parent);

			return new ModelAndView("viewQrCode", "model1", model1);
			// return new ModelAndView("editMenu","menu",menu);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

//--------------------------------------------------------------------------------------------------			
	// add new menu
	@RequestMapping(value = "/updateQrcode", method = RequestMethod.POST)
	public ModelAndView editQrCode(@ModelAttribute("id") int club_id, @ModelAttribute("club_name") String club_name,
			@ModelAttribute("longitude") String longitude, @ModelAttribute("latitude") String latitude,
			@ModelAttribute("club_address") String club_address, @ModelAttribute("club_tag") String club_tag,
			@ModelAttribute("status") String status, Model model, HttpSession session, HttpServletRequest request) {

		if (session.getAttribute("userName") != null) {
			String rootPath = request.getServletContext().getRealPath("/");
			File dir = new File(rootPath + "uploads/images/profile/");
			String path = rootPath + "uploads/images/profile/";
			if (!dir.exists())
				dir.mkdirs();
			Tbl_QrCode qrcodeBean = new Tbl_QrCode();
			qrcodeBean.setId(club_id);
			qrcodeBean.setClub_name(club_name);
			qrcodeBean.setLongitude(longitude);
			qrcodeBean.setLatitude(latitude);
			qrcodeBean.setClub_address(club_address);
			qrcodeBean.setClub_tag(club_tag);
			qrcodeBean.setStatus(status);
			String output = qrcodeService.updateQrCode(qrcodeBean, path, request);
			return new ModelAndView("redirect:/showQRCode");
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

//-------------------------------------------------------------------------------------------------
	// Display all QRCode
	@RequestMapping(value = "/showQRCode", method = RequestMethod.GET)
	public ModelAndView showQRCode(Model model, HttpSession session) {

		if (session.getAttribute("userName") != null) {

			List<TblLocation> allQRCode = qrcodeService.getallQrCode();
			List<Tbl_menu> parent = menuService.getParentClass((String) session.getAttribute("userRole"));

			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("users", allQRCode);
			model1.put("par", parent);
			return new ModelAndView("showQRCode", "model1", model1);
			// return new ModelAndView("menu","users",users);
		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

//-----------------------------------------------------------------------------------------------------------		    
	// delete user respected menu id
	@RequestMapping(value = "/deleteQRCode/{id}", method = RequestMethod.GET)
	public ModelAndView deleteQRCode(@PathVariable("id") int id, Model model, HttpSession session) {

		if (session.getAttribute("userName") != null) {
			boolean out = qrcodeService.deleteQRCode(id);
			if (out == true) {
				String msg = "Deleted successfully";
				return new ModelAndView("redirect:/showQRCode", "msg", msg);
			} else {
				String msg = "Sorry not Deleted";
				return new ModelAndView("redirect:/showQRCode", "msg", msg);
			}

		} else {
			Map<String, Object> model1 = new HashMap<String, Object>();
			model1.put("msg", "0");
			return new ModelAndView("redirect:/", "model1", model1);
		}
	}

//--------------------------------------------------------------------------------------------------				 
	@RequestMapping(value = "/downloadQRCode/{id}", method = RequestMethod.GET)
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") int id) throws ServletException, IOException {
		String QRCode_image = qrcodeService.getQRCode(id);
		String fileName = QRCode_image;
		String dataDirectory = request.getServletContext().getRealPath("/") + "uploads/images/profile/";

		Path file = Paths.get(dataDirectory, fileName);
		if (Files.exists(file)) {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
