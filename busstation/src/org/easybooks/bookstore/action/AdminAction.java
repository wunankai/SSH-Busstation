package org.easybooks.bookstore.action;

import java.util.List;
import java.util.Map;

import org.easybooks.bookstore.service.IAdminService;
import org.easybooks.bookstore.vo.Adminuser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private IAdminService adminService;
	private Adminuser adminuser;
	private Integer adminId;
	
	public String adlogin() throws Exception{
		Adminuser a=adminService.validateadminUser(adminuser.getAdminName(),adminuser.getAdminPassword());
		if(a!=null)
		{
			Map session=ActionContext.getContext().getSession();
			//保存此次会话的a（管理员账号）信息
			session.put("adminuser", a);
			return SUCCESS;
		}
	return ERROR;
	}
	//管理员注销，去除会话中的管理员账号信息即可，无须调用service层
		public String adlogout() throws Exception{
			Map session=ActionContext.getContext().getSession();
			session.remove("adminuser");
			return SUCCESS;
		}
		public String browseAdmin() throws Exception{
			List admins=adminService.getAllAdmin();
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("admins",admins);
			return SUCCESS;
		}
		public IAdminService getAdminService() {
			return adminService;
		}
		public void setAdminService(IAdminService adminService) {
			this.adminService = adminService;
		}
		public Adminuser getAdminuser() {
			return adminuser;
		}
		public void setAdminuser(Adminuser adminuser) {
			this.adminuser = adminuser;
		}
		
}
