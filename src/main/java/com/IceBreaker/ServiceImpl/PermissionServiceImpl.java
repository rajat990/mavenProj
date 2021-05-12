package com.IceBreaker.ServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.IceBreaker.Entity.Tbl_menu;
import com.IceBreaker.Entity.Tbl_permission;
import com.IceBreaker.Entity.Tbl_role;
import com.IceBreaker.Service.PermissionService;
import com.IceBreaker.Service.RoleService;


@Repository
@ComponentScan("com.IceBreaker")
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	RoleService roleService;
	@Override
	public List<Tbl_permission> getPermission(String roleId) {
		
		//Tbl_permission userDetails = null;
		List<Tbl_permission> menus= new ArrayList<Tbl_permission>();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Tbl_permission.class);
		criteria.add(Restrictions.eq("roleId", roleId));
		List entityList = criteria.list();
		if (!entityList.isEmpty()) {
			for(final Object o : criteria.list()) {
				menus.add((Tbl_permission)o);
			}
			System.out.print("login");
			Transaction tx = session.beginTransaction();
			
			tx.commit();
			
			session.close();
			return menus;
		} else {
			System.out.println("wrong details_permission");
			session.close();
			return null;
		}
		
	}
	@Override
	public boolean savePermission(String c, String p, String roleId) {
		// TODO Auto-generated method stub
		List<Tbl_role> role =roleService.getRole(roleId);
		
		if(role.isEmpty()) {
			Tbl_permission tbl_permission = new Tbl_permission();
			tbl_permission.setRoleId(roleId);
			tbl_permission.setChild(c);
			tbl_permission.setParent(p);
			
			Session session = sessionFactory.openSession();

			session.save(tbl_permission);

			session.close();
			return true;
			
		}else {
			Tbl_permission userPermission = null;
			 Session session = sessionFactory.openSession();
			
			 Criteria criteria = session.createCriteria(Tbl_permission.class);
				criteria.add(Restrictions.eq("roleId", roleId));
				List entityList = criteria.list();
				if (!entityList.isEmpty()) {
					userPermission = (Tbl_permission) entityList.get(0);

					Transaction txx = session.beginTransaction();
					Query query = session.createQuery(
							"UPDATE Tbl_permission SET child='" + c + "',parent='" + p + "' WHERE id=" + userPermission.getId());
					long result = query.executeUpdate();
					txx.commit();

					session.close();
					return true;
				} else {
					session.close();
					return false;
				}
				
			
		}
	}
}


