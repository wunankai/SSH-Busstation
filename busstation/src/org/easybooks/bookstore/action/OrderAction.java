package org.easybooks.bookstore.action;

import java.text.SimpleDateFormat;
import java.util.*;

import org.easybooks.bookstore.model.Cart;
import org.easybooks.bookstore.service.IBusService;
import org.easybooks.bookstore.service.IGetinfoService;
import org.easybooks.bookstore.service.IOrderService;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.*;

import com.opensymphony.xwork2.*;


public class OrderAction extends ActionSupport{
	//属性order,用于输入的信息
	private Orders order;
	//属性orderService,用于帮助action完成相关操作
	private int quantity;
	protected IOrderService orderService;
	private IBusService busService;
	protected IUserService userService;
	private Integer bsid;
	protected IGetinfoService getinfoService;
	
	public String addToCart() throws Exception{
		Businformation businformation=busService.findByBusId(bsid);
		Orderitem orderitem=new Orderitem();
		orderitem.setBusinformation(businformation);
		orderitem.setQuantity(quantity);
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addBus(bsid,orderitem);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderdate = simpleDateFormat.format(new Date());  //下单时间
		cart.setOrderdate(orderdate);
		session.put("cart",cart);
		return SUCCESS;
	}
	public String updateCart() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		cart.updateCart(bsid,quantity);
		session.put("cart",cart);
		return SUCCESS;
	}
	public String saving() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		User user=(User)session.get("user");
		if(user==null||cart==null)
			return ActionSupport.ERROR;
		Orders order=new Orders();
		order.setUser(user);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderTime = simpleDateFormat.format(new Date());  //下单时间

		for(Iterator it=cart.getItems().values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			orderitem.setOrders(order);
			order.getOrderitems().add(orderitem);
		}
		
		order.setOrderTime(orderTime);
		order.setState("未交易");
		orderService.saveOrder(order);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order", order);
		return SUCCESS;
	}
	public String queryUerOrders() throws Exception{
	  Orders o=orderService.fingUserOrdersList(order.getUser());
		if(o!=null)
		{
			Map session=ActionContext.getContext().getSession();
			session.put("order",o);
			/*for(Iterator<Object[]> iterator = orders.iterator();iterator.hasNext();){
				Object[] objects = iterator.next();
				Businformation businformation  = (Businformation) objects[2];
				order = (Orders) objects[1];
				User user = (User) objects[0];
				System.out.println(businformation.getBanciId()+"  "+order.getOrdersTime()+"  ");
			}*/
			return SUCCESS;
		}
			return ERROR;
		}
	public String findAllOrders() throws Exception{
		List orderlist=orderService.findAllorder();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("orderlist",orderlist);
		return SUCCESS;
	}
	public Orders getOrder() {
		return this.order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public IOrderService getOrderService() {
		return this.orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	public IBusService getBusService() {
		return this.busService;
	}
	public void setBusService(IBusService busService) {
		this.busService = busService;
	}
	public IUserService getUserService() {
		return this.userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IGetinfoService getGetinfoService() {
		return this.getinfoService;
	}
	public void setGetinfoService(IGetinfoService getinfoService) {
		this.getinfoService = getinfoService;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getBsid() {
		return bsid;
	}
	public void setBsid(Integer bsid) {
		this.bsid = bsid;
	}
	
}
