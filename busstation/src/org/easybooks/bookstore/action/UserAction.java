package org.easybooks.bookstore.action;
import java.util.List;
import java.util.Map;

import org.easybooks.bookstore.service.IUserService;
//import org.easybooks.bookstore.service.impl.UserService;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private User user;
	protected IUserService userService;
	private String username;
	private String password;
	private String result;
	//用户注册，调用service层的saveUser()方法
	public String register() throws Exception{
		userService.saveUser(user);
		return SUCCESS;
	}
	//用户登录，调用service层的validateUser()方法
	public String execute() throws Exception{
		//User u=userService.validateUser(username, password);
		User u=userService.validateUser(user.getUsername(),user.getPassword());
		//System.out.println(u.getUsername());
		//System.out.println(u.getPassword());
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		if(u!=null)
		{
			Map session=ActionContext.getContext().getSession();
			//保存此次会话的u（用户账号）信息
			session.put("user", u);
			//this.setResult("updateSuccess");
			return SUCCESS;
		}
		//this.setResult("error");
		return ERROR;
	}
	
	//用户注销，去除会话中的用户账号信息即可，无须调用service层
	public String logout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.remove("user");
		//session.remove("cart");
		return SUCCESS;
	}
	public String browseUser() throws Exception{
		List alluser=userService.getAllUser();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("alluser",alluser);
		return SUCCESS;
	}
	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user=user;
	}
	public IUserService getUserService(){
		return this.userService;
	}
	public void setUserService(IUserService userService){
		this.userService=userService;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
