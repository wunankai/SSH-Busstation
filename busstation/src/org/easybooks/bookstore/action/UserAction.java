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
	//�û�ע�ᣬ����service���saveUser()����
	public String register() throws Exception{
		userService.saveUser(user);
		return SUCCESS;
	}
	//�û���¼������service���validateUser()����
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
			//����˴λỰ��u���û��˺ţ���Ϣ
			session.put("user", u);
			//this.setResult("updateSuccess");
			return SUCCESS;
		}
		//this.setResult("error");
		return ERROR;
	}
	
	//�û�ע����ȥ���Ự�е��û��˺���Ϣ���ɣ��������service��
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
