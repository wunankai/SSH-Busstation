package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Bus;
import org.easybooks.bookstore.vo.Businformation;

public interface IBusService {
	public List findAll();
	public Businformation getordersinfo(Integer bus);
	public Businformation findByBusId(Integer bsid);
	public void saveBusin(Businformation businformation); 
	public void deleteBusinfo(Integer bsid);
	public void updateBusinfo(Businformation businformation);
}
