package com.IceBreaker.ServiceImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.IceBreaker.Entity.Tbl_login;
import com.IceBreaker.Service.LoginService;


@Repository
@ComponentScan("com.IceBreaker")
public class LoginServiceImpl implements LoginService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Tbl_login auth(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println(email+password);
		
		Tbl_login userDetails = null;
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Tbl_login.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		List entityList = criteria.list();
	
		if (!entityList.isEmpty()) {
			userDetails = (Tbl_login) entityList.get(0);
			
			Transaction tx = session.beginTransaction();
			//Query query = session.createQuery("UPDATE LoginBean SET fcmToken='"+password+"' WHERE id="+userDetails.getId());
			//long result = query.executeUpdate();
			tx.commit();
			
			session.close();
			return userDetails;
		} else {
			System.out.println("wrong details");
			session.close();
			return null;
		}
	}

}
