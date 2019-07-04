package org.easybooks.bookstore.dao;
import java.util.List;

import org.easybooks.bookstore.vo.Businformation;

public interface IBusInformationDAO {
	public List findAll();
	public Businformation getordersinfo(Integer bus);
	public Businformation findByBusId(Integer bsid);
	public void saveBusin(Businformation businformation);
	public void deleteBusinfo(Integer bsid);
	public void updateBusinfo(Businformation businformation);
}
