package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Adminuser;

public interface IAdminDAO {
	public Adminuser validateadminUser(String adminName,String adminPassword);
	public Adminuser findUserNameById(Integer adminId);
	public List getAllAdmin();
}
