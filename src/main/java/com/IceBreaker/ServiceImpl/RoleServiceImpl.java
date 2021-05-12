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

import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_role;
import com.IceBreaker.Service.RoleService;
@Repository
@ComponentScan("com.IceBreaker")
public class RoleServiceImpl implements RoleService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addrole(Tbl_role roleBean) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		session.save(roleBean);

		session.close();
		return true;
		
	}

	@Override
	public List<Tbl_role> getallRole() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<Tbl_role> roles= new ArrayList<Tbl_role>();
		Criteria criteria = session.createCriteria(Tbl_role.class);
		
		List entityList = criteria.list();
		
		if (!entityList.isEmpty()) {
			for(final Object o : entityList) {
				roles.add((Tbl_role)o);
			}
			
			System.out.println("get roles");
			Transaction tx = session.beginTransaction();
			//Query query = session.createQuery("UPDATE LoginBean SET fcmToken='"+password+"' WHERE id="+userDetails.getId());
			//long result = query.executeUpdate();
			tx.commit();
			
			session.close();
			return roles;
		}else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
	}

	@Override
	public List<Tbl_role> getRole(String id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		List<Tbl_role> roles= new ArrayList<Tbl_role>();
		Criteria criteria = session.createCriteria(Tbl_role.class);
		criteria.add(Restrictions.eq("id", Integer.parseInt(id)));
		List entityList = criteria.list();
		
		if (!entityList.isEmpty()) {
			for(final Object o : entityList) {
				roles.add((Tbl_role)o);
			}
			
			System.out.println("role by id");
			Transaction tx = session.beginTransaction();
			
			tx.commit();
			
			session.close();
			return roles;
		}else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
	}

	@Override
	public boolean updateRole(Tbl_role Tbl_role) {
		// TODO Auto-generated method stub
		if (Tbl_role.getId()!= null && Tbl_role.getRoleName() != null) {
			 Session session = sessionFactory.openSession();
			 Transaction tx = session.beginTransaction();
			 Tbl_role tblLoginRetrieved = session.get(Tbl_role.class, new Integer(Tbl_role.getId()));
			 //System.out.println(Tbl_role.getRoleName()+"sadhaskdlhsa");
			 
			 if (Tbl_role.getRoleName() != null) {
					tblLoginRetrieved.setRoleName(Tbl_role.getRoleName());
				}
			 if (Tbl_role.getStatus() != null) {
					tblLoginRetrieved.setStatus(Tbl_role.getStatus());
				}
			 
			 
			 session.saveOrUpdate(tblLoginRetrieved);
			 tx.commit();
			session.close();
			return true;	
		 }else {
				System.out.println("wrong details");
				
				return false;
			}
	}

	@Override
	public boolean deleteRole(int id) {
		// TODO Auto-generated method stub
		if (id!= 0) {
			System.out.println(id);
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 Tbl_role role = (Tbl_role)session.createCriteria(Tbl_role.class)
				 .add(Restrictions.eq("id", id)).uniqueResult();
			session.delete(role);
			
			tx.commit();
			session.close();
			return true;	
		 }else {
				System.out.println("wrong details");
				
				return false;
			}
	}

}
