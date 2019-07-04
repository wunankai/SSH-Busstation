package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Bus;
import org.easybooks.bookstore.vo.Businformation;

public interface IBusesService{
	//搜索得到所有车辆信息
	public List BookingQuery(Businformation businformation);
	public List getAllbus();
	public void saveBus(Bus bus);
	//public void deleteBus(Integer id);
	//public void updateBus(Integer busId);
	public void deleteBus(Bus bus);
	public void updateBus(Bus bus);
	public Bus getBusid(Integer busId);
}
