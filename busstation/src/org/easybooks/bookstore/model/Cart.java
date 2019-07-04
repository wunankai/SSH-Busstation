package org.easybooks.bookstore.model;
import org.easybooks.bookstore.vo.*;

import java.util.*;
public class Cart {
	protected Map<Integer,Orderitem>items;
	private String orderdate;
	//构造函数
	public Cart(){
		if(items==null)
			items=new HashMap<Integer,Orderitem>();
	}
	//添加车票信息到订单
	public void addBus(Integer bsid,Orderitem orderitem){
		//是否存在，如果存在，则更改数量
		//如果不存在，则添加到集合
		if(items.containsKey("bsid")){
			Orderitem _orderitem=items.get(bsid);
			orderitem.setQuantity(_orderitem.getOrderitemid()+orderitem.getQuantity());
			items.put(bsid,_orderitem);
		}
		else{
			items.put(bsid,orderitem);
		}
	}
	//更新订单的购买车票数量
	public void updateCart(Integer bsid,int quantity){
	Orderitem orderitem=items.get(bsid);
	orderitem.setQuantity(quantity);
	items.put(bsid,orderitem);
	}
	//计算总价格
	public int getTotalPrice(){
		int totalPrice=0;
		for(Iterator it=items.values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			Businformation businformation=orderitem.getBusinformation();
			int quantity=orderitem.getQuantity();
			totalPrice+=businformation.getPrice()*quantity;
		}
		return totalPrice;
		}
	
	public Map<Integer, Orderitem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Orderitem> items) {
		this.items = items;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	
}
