package org.easybooks.bookstore.model;
import org.easybooks.bookstore.vo.*;

import java.util.*;
public class Cart {
	protected Map<Integer,Orderitem>items;
	private String orderdate;
	//���캯��
	public Cart(){
		if(items==null)
			items=new HashMap<Integer,Orderitem>();
	}
	//��ӳ�Ʊ��Ϣ������
	public void addBus(Integer bsid,Orderitem orderitem){
		//�Ƿ���ڣ�������ڣ����������
		//��������ڣ�����ӵ�����
		if(items.containsKey("bsid")){
			Orderitem _orderitem=items.get(bsid);
			orderitem.setQuantity(_orderitem.getOrderitemid()+orderitem.getQuantity());
			items.put(bsid,_orderitem);
		}
		else{
			items.put(bsid,orderitem);
		}
	}
	//���¶����Ĺ���Ʊ����
	public void updateCart(Integer bsid,int quantity){
	Orderitem orderitem=items.get(bsid);
	orderitem.setQuantity(quantity);
	items.put(bsid,orderitem);
	}
	//�����ܼ۸�
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
