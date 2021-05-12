package com.IceBreaker.ServiceImpl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.IceBreaker.Entity.Tbl_login;
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Service.RoleService;

import com.IceBreaker.Service.UserService;


@Repository
@ComponentScan("com.IceBreaker")

public class UserServiceImp implements UserService{

	
	 @Autowired
	 RoleService roleService;

		@Autowired
		SessionFactory sessionFactory;
	 
//	 @Override
//	public List<Tbl_User> getallUser() {
		// List<Tbl_User> Users = new ArrayList<Tbl_User>();
//		 ResultSet rs= dbConnect.getallUser();
//		 try {
//			while(rs.next()) {
//				
//				Tbl_User user= new Tbl_User();
//				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
//				user.setEmail(rs.getString("email"));
//				/* user.setRole(rs.getString("role")); */
//				
//				ResultSet r=dbConnect.getRole(Integer.parseInt(rs.getString("role")));
//				 if(r.next()!=false) {
//					 user.setRole(r.getString("rolename"));
//				 }else {
//					 user.setRole(r.getString(" "));
//				 }
//				user.setMobile_no(rs.getString("mobile_number"));
//				user.setStatus(rs.getString("status"));
//				user.setPassword(rs.getString("password"));
//				Users.add(user);
//			 }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		 
//	 }
//	 
	 
//	 @Override
//	 public boolean adduser(Tbl_User Tbl_User) {
//		 if (Tbl_User.getName()!= null && Tbl_User.getPassword() != null) {
//			 ResultSet r= dbConnect.checkEmail(Tbl_User.getEmail());
//			 if(r==null) {
//				
//			 String rs = dbConnect.adduser(Tbl_User.getName(),Tbl_User.getEmail(), Tbl_User.getPassword(),Tbl_User.getMobile_no(),Tbl_User.getRole(),Tbl_User.getImage(),Tbl_User.getStatus());
//			 
//	            if (rs=="Done") {
//				    return true;
//				} else {
//				    
//				    return false;	           	
//				}
//	        } else {
//	            
//	            return false;
//	        }
//			 }else {
//				 return false;
//			 }
//		 return false;
//	 }
	 
	 
	 @Override
		public List<Tbl_login> getUser(int id) {
			Session session = sessionFactory.openSession();
			List<Tbl_login> users= new ArrayList<Tbl_login>();
			Criteria criteria = session.createCriteria(Tbl_login.class);
			criteria.add(Restrictions.eq("id", id));
			List entityList = criteria.list();
			
			if (!entityList.isEmpty()) {
				for(final Object o : entityList) {
					users.add((Tbl_login)o);
				}
				Transaction tx = session.beginTransaction();
				
				tx.commit();
				session.close();
				return users;
			}else {
				System.out.println("wrong details");
				session.close();
				return null;
			}
			
		 }
	 
	 //for update user profile
	 @Override
	 public boolean updateuser(Tbl_login tbl_login) {
		 if (tbl_login.getName()!= null && tbl_login.getEmail() != null) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		
		 Tbl_login tblLoginRetrieved = session.get(Tbl_login.class, new Integer(tbl_login.getId()));

		 System.out.println(tbl_login.getEmail()+tbl_login.getPhone_no()+tbl_login.getName()
			+tbl_login.getPassword()+tbl_login.getRole_id()+tbl_login.getStatus()+"++++++ab");
		
		 if (tbl_login.getId() != 0) {
				tblLoginRetrieved.setId(tbl_login.getId());
			}
		 if (tbl_login.getName() != null) {
				tblLoginRetrieved.setName(tbl_login.getName());
			}
		 if (tbl_login.getEmail() != null) {
				tblLoginRetrieved.setEmail(tbl_login.getEmail());
			}
		 if (tbl_login.getStatus() != null) {
				tblLoginRetrieved.setStatus(tbl_login.getStatus());
			}
		 if (tbl_login.getPassword() != null) {
				tblLoginRetrieved.setPassword(tbl_login.getPassword());
			}
		 if (tbl_login.getPhone_no() != null) {
				tblLoginRetrieved.setPhone_no(tbl_login.getPhone_no());
			}
		 if (tbl_login.getRole_id()!=null) {
				tblLoginRetrieved.setRole_id(tbl_login.getRole_id());
			}
		 if (tbl_login.getProfilePic() != null) {
				tblLoginRetrieved.setProfilePic(tbl_login.getProfilePic());
			}
		
		 session.saveOrUpdate(tblLoginRetrieved);
		
		 tx.commit();
		session.close();
		System.out.println("sahil++=");
		return true;	
		 }else {
				System.out.println("wrong details");
				
				return false;
			} 
	 }
	 
	 @Override
	 public String restpasswordpro(int id , String email, String oldPassword,String newPassword,String confirmPassword) {
		 String msg="";
			if(newPassword.equals(confirmPassword)){
				 Session session = sessionFactory.openSession();
				 Transaction tx = session.beginTransaction();
				 Tbl_login tblLoginRetrieved = session.get(Tbl_login.class, new Integer(id));
				
				 if(tblLoginRetrieved.getPassword().equals(oldPassword)) {
					 tblLoginRetrieved.setPassword(newPassword);
					 session.saveOrUpdate(tblLoginRetrieved);
					 tx.commit();
					session.close();
					 msg= "Your Password is Change Successfully.";
					return msg;
				 }else{
				 msg ="Your old password is wrong.";}
		 }else{
			 msg= "Your Password donot match.";
		}
			return msg;
		
	 }

	
	 
//	 @Override
//	 public boolean deleteuser(int id) {
//		 String rs= dbConnect.deleteuser(id);
//		 if (rs=="Done") {
//			    return true;
//			} else {
//			    
//			    return false;	           	
//			}
//		 return false;
//	 }
		
	 
}
