package org.easybooks.bookstore.service.impl;

import java.util.Date;
import java.util.List;

import org.easybooks.bookstore.dao.IBusDAO;
import org.easybooks.bookstore.service.IBusesService;
import org.easybooks.bookstore.vo.Bus;
import org.easybooks.bookstore.vo.Businformation;

public class BusesService implements IBusesService{
	private IBusDAO busDAO;
	public IBusDAO getBusDAO() {
		return busDAO;
	}
	public void setBusDAO(IBusDAO busDAO) {
		this.busDAO = busDAO;
	}
	public List BookingQuery(Businformation businformation) {
	// TODO Auto-generated method stub
	return busDAO.Bookingsearch(businformation.getFromcity(),businformation.getTocity(),businformation.getStartDate());
}
	
	public List getAllbus() {
		return busDAO.getAllbus();
	}
	
	public void saveBus(Bus bus) {
		this.busDAO.saveBus(bus);		
	}
	/*@Override
	public void deleteBus(Integer id) {
		// TODO Auto-generated method stub
		this.busDAO.deleteBus(id);
	}
	@Override
	public void updateBus(Integer busId) {
		// TODO Auto-generated method stub
		this.busDAO.updateBus(busId);
	}*/
	
	public void deleteBus(Bus bus) {
		this.busDAO.deleteBus(bus);
	}

	public void updateBus(Bus bus) {
		this.busDAO.updateBus(bus);	
	}
	
	public Bus getBusid(Integer busId) {
		return busDAO.getBusid(busId);
	}
	

}
