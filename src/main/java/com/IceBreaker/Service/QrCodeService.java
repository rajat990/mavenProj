package com.IceBreaker.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.IceBreaker.Entity.TblLocation;
import com.IceBreaker.Entity.Tbl_QrCode;

public interface QrCodeService {
	

	public String addQrCode(TblLocation qrcodeBean, String path,HttpServletRequest request);

	public  List<TblLocation> getallQrCode() ;

	public String getQRCode(int id);
	
	public boolean deleteQRCode(int id);

	public  List <TblLocation> getQRCodeDetails(int id);
	
	public String updateQrCode(Tbl_QrCode qrcodeBean, String path,HttpServletRequest request);
}
