package com.IceBreaker.Service;

import java.util.List;

import com.IceBreaker.Entity.Tbl_permission;

public interface PermissionService {
	public List<Tbl_permission> getPermission(String roleId);

	public boolean savePermission(String c, String p, String roleId);

	
}
