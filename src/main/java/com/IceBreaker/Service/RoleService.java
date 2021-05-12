package com.IceBreaker.Service;

import java.util.List;

import com.IceBreaker.Entity.Tbl_role;

public interface RoleService {

	public boolean addrole(Tbl_role roleBean);

	public List<Tbl_role> getallRole();

	public List<Tbl_role> getRole(String id);

	public boolean updateRole(Tbl_role roleBean);

	public boolean deleteRole(int id);

}
