package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IBusInformationDAO;
import org.easybooks.bookstore.service.IBusService;
import org.easybooks.bookstore.vo.Businformation;

public class BusService implements IBusService{
	private IBusInformationDAO busInformationDAO;
	public IBusInformationDAO getBusInformationDAO() {
		return busInformationDAO;
	}
	public void setBusInformationDAO(IBusInformationDAO busInformationDAO) {
		this.busInformationDAO = busInformationDAO;
	}
	public List findAll() {
		return busInformationDAO.findAll();
	}
	@Override
	public Businformation getordersinfo(Integer bus) {
		// TODO Auto-generated method stub
		return busInformationDAO.getordersinfo(bus);
	}
	public Businformation findByBusId(Integer bsid){
		return busInformationDAO.findByBusId(bsid);
	}
	
	public void saveBusin(Businformation businformation){	
		this.busInformationDAO.saveBusin(businformation);
	}
	
	public void deleteBusinfo(Integer bsid) {
		this.busInformationDAO.deleteBusinfo(bsid);
	}
	public void updateBusinfo(Businformation businformation) {
		this.busInformationDAO.updateBusinfo(businformation);
	}
	
}