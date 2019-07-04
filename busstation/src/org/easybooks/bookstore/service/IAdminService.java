package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Adminuser;

public interface IAdminService {
	public Adminuser validateadminUser(String adminName,String adminPassword);
	public Adminuser findUserNameById(Integer adminId);
	public List getAllAdmin();
}
