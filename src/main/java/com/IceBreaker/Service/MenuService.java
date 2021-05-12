package com.IceBreaker.Service;

import java.util.List;

import com.IceBreaker.Entity.Tbl_menu;



public interface MenuService {
	
	public List<Tbl_menu> getParentClass(String role_id);

	public List<Tbl_menu> getallMenu();

	public List<Tbl_menu> getMenu(int id);

	public boolean updatemenu(Tbl_menu menuBean);

	public boolean deletemenu(int id);

	public boolean addmenu(Tbl_menu menuBean);

	

}
