package com.IceBreaker.Service;

import java.util.List;


import com.IceBreaker.Entity.Tbl_login;



public interface UserService {

//	public List<Tbl_User> getallUser();
//	
//	public boolean adduser(Tbl_User userBean);
	
	public List<Tbl_login> getUser(int id);
	
	public boolean updateuser(Tbl_login userBean);
	
	public String restpasswordpro(int id,String email,String oldPassword,String newPassword,String confirmPassword);
	
//	public boolean deleteuser(int id);
	

}
