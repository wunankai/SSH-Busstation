package org.easybooks.bookstore.action;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.easybooks.bookstore.service.IBusService;
import org.easybooks.bookstore.service.IGetinfoService;
import org.easybooks.bookstore.vo.Businformation;

//import org.easybooks.bookstore.service.ICatalogService;
import com.opensymphony.xwork2.*;


public class BusAction extends ActionSupport{
	protected IBusService busService;
	protected Integer id;
	private Integer bsid;
	private String startDateString;
	private String startTimeString;
	protected IGetinfoService getinfoService;
	private String result;
	//protected String id;
	private Businformation businformation;
	public IBusService getBusService() {
		return busService;
	}
	public void setBusService(IBusService busService) {
		this.busService = busService;
	}
	//用于主页车辆查询
	public String searchAll() throws Exception{
		List buses=busService.findAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("buses",buses);
		return SUCCESS;
	}
	//用于管理员查询所有班次
	public String searchbusAll() throws Exception{
		List buses=busService.findAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("buses",buses);
		return SUCCESS;
	}
	public String Getinfo() throws Exception{
		List getinfo=getinfoService.getinformation(id);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("getinfo",getinfo);
		return SUCCESS;
	}
	public String deleBusinfo() throws Exception{
		busService.deleteBusinfo(bsid);
		return SUCCESS;
	}
	public String saveNewBusinfo() throws Exception{
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 //把字符转换为Date类型
		Date startDate = simpleDateFormat.parse(startDateString);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date startTime = sdf.parse(startTimeString);
		businformation.setStartDate(startDate);
		businformation.setStartTime(startTime);
		busService.saveBusin(businformation);
		this.setResult("saveFlightSuccess");
		return SUCCESS;
	}
	public String updaBusin() throws Exception{
			 HttpServletRequest request = ServletActionContext.getRequest();
			 Integer id = Integer.valueOf(request.getParameter("bsid"));
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String st = request.getParameter("st");
			 Date startDate = simpleDateFormat.parse(st);
			 String fp = request.getParameter("fp");
			 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			 Date startTime = sdf.parse(fp);
			 String bp = request.getParameter("bp");
			 String tp = request.getParameter("tp");
			 String fr = request.getParameter("fr");
			 String br = request.getParameter("br");
			 Integer tr = Integer.valueOf(request.getParameter("tr"));
			 Integer sr = Integer.valueOf(request.getParameter("sr"));
			
			 Businformation businfor=busService.findByBusId(id);
			 
			 businfor.setStartTime(startTime);
			 businfor.setFromTerminal(fr);
			 businfor.setToTerminal(bp);
			 businfor.setBanciId(br);
			 businfor.setSpendTime(tp);
			 businfor.setPrice(tr);
			 businfor.setRemain(sr);
			 businfor.setStartDate(startDate);
			 
			 busService.saveBusin(businfor);;
			 this.setResult("updateNewFlightSuccess");
			 
			 return SUCCESS; 
	}
	public IGetinfoService getGetinfoService() {
		return getinfoService;
	}

	public void setGetinfoService(IGetinfoService getinfoService) {
		this.getinfoService = getinfoService;
	}

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Businformation getBusinformation() {
		return businformation;
	}
	public void setBusinformation(Businformation businformation) {
		this.businformation = businformation;
	}
	public String getStartDateString() {
		return startDateString;
	}
	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}
	public String getStartTimeString() {
		return startTimeString;
	}
	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getBsid() {
		return bsid;
	}
	public void setBsid(Integer bsid) {
		this.bsid = bsid;
	}
	
	
	//protected ICatalogService catalogService;	//为使用业务层而设置的属性
	//protected Integer catalogid;				//分类id
	//private String bookname;

	/*public String browseCatalog() throws Exception{
		List catalogs=catalogService.getAllCatalogs();
		//直接调用业务层方法
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}
	public Integer getCatalogid(){
		return this.catalogid;
	}
	public void setCatalogid(Integer catalogid){
		this.catalogid=catalogid;
	}
	public ICatalogService getCatalogService(){
		return this.catalogService;
	}
	public void setCatalogService(ICatalogService catalogService){
		this.catalogService=catalogService;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname=bookname;
	}*/
}
