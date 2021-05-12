package com.IceBreaker.Service;

import com.IceBreaker.Entity.Tbl_login;

public interface LoginService {

	Tbl_login auth(String email, String password);

}
