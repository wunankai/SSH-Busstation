package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IAdminDAO;
import org.easybooks.bookstore.dao.impl.AdminDAO;
import org.easybooks.bookstore.service.IAdminService;
import org.easybooks.bookstore.vo.Adminuser;

public class AdminService implements IAdminService{
	private IAdminDAO adminDAO;

	@Override
	public Adminuser validateadminUser(String adminName, String adminPassword) {
		// TODO Auto-generated method stub
		return adminDAO.validateadminUser(adminName, adminPassword);
	}

	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}
	public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	public Adminuser findUserNameById(Integer adminId) {
		return adminDAO.findUserNameById(adminId);
	}

	@Override
	public List getAllAdmin() {
		// TODO Auto-generated method stub
		return adminDAO.getAllAdmin();
	}
}
