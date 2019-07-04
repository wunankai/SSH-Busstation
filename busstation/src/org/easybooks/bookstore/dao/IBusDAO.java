package org.easybooks.bookstore.dao;

import java.util.Date;
import java.util.List;

import org.easybooks.bookstore.vo.Bus;

public interface IBusDAO {
	//搜索得到所有车辆信息
		public List Bookingsearch(String fromcity, String tocity,Date startDate);
		public List getAllbus();
		public void saveBus(Bus bus);
		//public void deleteBus(Integer id);
		//public void updateBus(Integer busId);
		public void deleteBus(Bus bus);
		public void updateBus(Bus bus);
		public Bus getBusid(Integer busId);
}
