package com.IceBreaker.ServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.IceBreaker.Entity.Tbl_login;
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_permission;
import com.IceBreaker.Service.MenuService;
import com.IceBreaker.Service.PermissionService;




@Repository
@ComponentScan("com.IceBreaker")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	PermissionService permissionService;

	@Autowired
	SessionFactory sessionFactory;
//-----------------------------get menu by role_id-----------------------------------------------------------
	@Override
	public List<Tbl_menu> getParentClass(String role_id){
		
		  List<Tbl_permission> permission=permissionService.getPermission(role_id); 
		  Tbl_permission permissionname=permission.get(0);
		
		  
		  String s= permissionname.getChild()+permissionname.getParent(); 
		  String[]array =s.split("/");
		 
		  List<Integer> StringToInt=new ArrayList<Integer>();
		  for(String s1 : array) { 
		  	  StringToInt.add(Integer.valueOf(s1));
		  	  }
		  
		List<Tbl_menu> menus= new ArrayList<Tbl_menu>();
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Tbl_menu.class)
		.addOrder(Order.asc("priority"));
		List <Tbl_menu>entityList = criteria.list();
		
		if (!entityList.isEmpty()) {
			
			
			Transaction tx = session.beginTransaction();
			List<Tbl_menu> persons = session.createQuery("SELECT p FROM Tbl_menu p WHERE p.id IN :ids ORDER BY p.priority").setParameter("ids", StringToInt).getResultList();
			tx.commit();
			for(final Object o : persons) {
				menus.add((Tbl_menu)o);
			}
			
			session.close();
			return   menus;
		} else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
		
		
		
	}
//-----------------------------get all menu-----------------------------------------------------------
	@Override
	public List<Tbl_menu> getallMenu() {
		
		Session session = sessionFactory.openSession();
		List<Tbl_menu> menus= new ArrayList<Tbl_menu>();
		Criteria criteria = session.createCriteria(Tbl_menu.class);
		
		List entityList = criteria.list();
		
		if (!entityList.isEmpty()) {
			for(final Object o : entityList) {
				menus.add((Tbl_menu)o);
			}
			
			System.out.print("login");
			Transaction tx = session.beginTransaction();
			//Query query = session.createQuery("UPDATE LoginBean SET fcmToken='"+password+"' WHERE id="+userDetails.getId());
			//long result = query.executeUpdate();
			tx.commit();
			
			session.close();
			return menus;
		}else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
}
//-----------------------------get menu by id-----------------------------------------------------------
	@Override
	public List<Tbl_menu> getMenu(int id) {
		Session session = sessionFactory.openSession();
		List<Tbl_menu> menus= new ArrayList<Tbl_menu>();
		Criteria criteria = session.createCriteria(Tbl_menu.class);
		criteria.add(Restrictions.eq("id", id));
		List entityList = criteria.list();
		
		if (!entityList.isEmpty()) {
			for(final Object o : entityList) {
				menus.add((Tbl_menu)o);
			}
			
			System.out.print("login");
			Transaction tx = session.beginTransaction();
			
			tx.commit();
			
			session.close();
			return menus;
		}else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
	}
//---------------------------------update edited menu-------------------------------------------------------	
	@Override
	 public boolean updatemenu(Tbl_menu Tbl_menu) {
		 if (Tbl_menu.getMenu_name()!= null && Tbl_menu.getUrl() != null) {
			 Session session = sessionFactory.openSession();
			 Transaction tx = session.beginTransaction();
			 Tbl_menu tblLoginRetrieved = session.get(Tbl_menu.class, new Integer(Tbl_menu.getId()));
			
			 if (Tbl_menu.getMenu_name() != null) {
					tblLoginRetrieved.setMenu_name(Tbl_menu.getMenu_name());
				}
			 if (Tbl_menu.getUrl() != null) {
					tblLoginRetrieved.setUrl(Tbl_menu.getUrl());
				}
			 if (Tbl_menu.getParent_class() != null) {
					tblLoginRetrieved.setParent_class(Tbl_menu.getParent_class());
				}
			 if (Tbl_menu.getStatus() != null) {
					tblLoginRetrieved.setStatus(Tbl_menu.getStatus());
				}
			 
			 session.saveOrUpdate(tblLoginRetrieved);
			 tx.commit();
			session.close();
			return true;	
		 }else {
								
				return false;
			}
	}
//-------------------------------delete menu-----------------------------------------------------------
	
	@Override
	 public boolean deletemenu(int id) {
		if (id!= 0) {
			System.out.println(id);
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 Tbl_menu menu = (Tbl_menu)session.createCriteria(Tbl_menu.class)
				 .add(Restrictions.eq("id", id)).uniqueResult();
			session.delete(menu);
			
			tx.commit();
			session.close();
			return true;	
		 }else {
				System.out.println("wrong details");
				
				return false;
			}
	 }
//-------------------------add menu process---------------------------------------------------------
	@Override
	public boolean addmenu(Tbl_menu menuBean) {
		Session session = sessionFactory.openSession();

		session.save(menuBean);

		session.close();
		return true;
	}
}