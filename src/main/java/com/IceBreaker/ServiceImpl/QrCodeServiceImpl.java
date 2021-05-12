package com.IceBreaker.ServiceImpl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.IceBreaker.Config.FileStorageService;
import com.IceBreaker.Entity.TblLocation;
import com.IceBreaker.Entity.Tbl_QrCode;
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_role;
import com.IceBreaker.Service.QrCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
@Repository
@ComponentScan("com.IceBreaker")
public class QrCodeServiceImpl implements QrCodeService{


	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@Override
	public String addQrCode(TblLocation location ,String path,HttpServletRequest request) {
		
		Session session = sessionFactory.openSession();
		session.save(location);
		Criteria criteria = session.createCriteria(TblLocation.class);
		String clubEmail = "";
		Integer clubId = 0;
		String status = "";
		List<TblLocation> locationList = criteria.list();
		
		for(TblLocation loc : locationList) {
			clubId = loc.getId();
			clubEmail = loc.getLocationEmail();
			status = loc.getStatus();
		}
		String qrCodeText = "Club ID:"+clubId+"\n"
		  +"Club Email:"+clubEmail+"\n"
		  +"Club Status:"+status;
		Random rand = new Random();
		int randomNo = rand.nextInt(10000);
		String fileName= "QRCode"+randomNo+".png";
		String filePath = path+fileName;
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("UPDATE TblLocation SET qrCode='"+fileName+"' WHERE id="+clubId);
		long result = query.executeUpdate();
		tx.commit();
		int size = 425;
		String fileType = "png";
		File qrFile = new File(filePath);
		qrFile.length();
		try {
			createQRImage(qrFile, qrCodeText, size, fileType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		session.close();
		return fileName;
	}

	@Override
	public String updateQrCode(Tbl_QrCode qrcodeBean ,String path,HttpServletRequest request) {
		
		Session session = sessionFactory.openSession();

		 Transaction tx = session.beginTransaction();
		 Tbl_QrCode tblLoginRetrieved = session.get(Tbl_QrCode.class, new Integer(qrcodeBean.getId()));
		 
		
		 if (qrcodeBean.getClub_name() != null) {
				tblLoginRetrieved.setClub_name(qrcodeBean.getClub_name());
			}
		 if (qrcodeBean.getLatitude() != null) {
				tblLoginRetrieved.setLatitude(qrcodeBean.getLatitude());
			}
		 if (qrcodeBean.getStatus() != null) {
				tblLoginRetrieved.setStatus(qrcodeBean.getStatus());
			}
		 if (qrcodeBean.getLongitude() != null) {
				tblLoginRetrieved.setLongitude(qrcodeBean.getLongitude());
			}
		 if (qrcodeBean.getClub_tag() != null) {
				tblLoginRetrieved.setClub_tag(qrcodeBean.getClub_tag());
			}
		 if (qrcodeBean.getClub_address() != null) {
				tblLoginRetrieved.setClub_address(qrcodeBean.getClub_address());
			}
		 
		String qrCodeText = "Club Address:"+tblLoginRetrieved.getClub_address()+"\n"
		
		  +"Club Name:"+tblLoginRetrieved.getClub_name()+"\n"
		  +"Club Latitude:"+tblLoginRetrieved.getLatitude()+"\n"
		  +"Club Longitude:"+tblLoginRetrieved.getLongitude()+"\n"
		  +"Club Id:"+tblLoginRetrieved.getId()+"\n"
		  +"Club ClubTag:"+tblLoginRetrieved.getClub_tag()+"\n"
		  +"Club Status:"+tblLoginRetrieved.getStatus()
	
		 ;
												
		//uploadFileHandler(null, null);
		Random rand = new Random();
		int randomNo = rand.nextInt(10000);
		String fileName= "QRCode"+randomNo+".png";
		String filePath = path+fileName;
		
		tblLoginRetrieved.setQrCode_location(fileName);
		int size = 425;
		String fileType = "png";
		File qrFile = new File(filePath);
		qrFile.length();
		try {
			createQRImage(qrFile, qrCodeText, size, fileType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		session.saveOrUpdate(tblLoginRetrieved);
		 tx.commit();
		session.close();
		//downloadFile(fileName, request);
		return fileName;
				
	}
	
	private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

	@Override
	public List<TblLocation> getallQrCode() {
		Session session = sessionFactory.openSession();
		List<TblLocation> qrCode = new ArrayList<TblLocation>();
		Criteria criteria = session.createCriteria(TblLocation.class);
		
		List entityList = criteria.list();
		if (!entityList.isEmpty()) {
			for(final Object o : entityList) {
				qrCode.add((TblLocation)o);
			}
			Transaction tx = session.beginTransaction();
			//Query query = session.createQuery("UPDATE LoginBean SET fcmToken='"+password+"' WHERE id="+userDetails.getId());
			//long result = query.executeUpdate();
			tx.commit();
			
			session.close();
			return qrCode;
		}else {
			session.close();
			return null;
		}	
	}

	@Override
	public String getQRCode(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 TblLocation QrCodeRetrieved = session.get(TblLocation.class, new Integer(id));
		 String QRCode_location = QrCodeRetrieved.getQrCode();
		 tx.commit();
		return QRCode_location;
	}
//--------------------------------------------------------------------------------------------
	@Override
	public List <TblLocation> getQRCodeDetails(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		
		 List<TblLocation> qrCode= new ArrayList<TblLocation>();
			Criteria criteria = session.createCriteria(TblLocation.class);
			criteria.add(Restrictions.eq("id", id));
			List entityList = criteria.list();
			if (!entityList.isEmpty()) {
				for(final Object o : entityList) {
					qrCode.add((TblLocation)o);
				}
		 tx.commit();
		 session.close();
		return  qrCode;
		}else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
	}
	//-------------------------------delete menu-----------------------------------------------------------
	
		@Override
		 public boolean deleteQRCode(int id) {
			if (id!= 0) {
			
			Session session = sessionFactory.openSession();
			 Transaction tx = session.beginTransaction();
			 TblLocation qrCode = (TblLocation)session.createCriteria(TblLocation.class)
					 .add(Restrictions.eq("id", id)).uniqueResult();
				session.delete(qrCode);
				
				tx.commit();
				session.close();
				return true;	
			 }else {
					System.out.println("wrong details");
					return false;
				}
		 }
}
