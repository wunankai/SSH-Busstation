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
			//����˴λỰ��a������Ա�˺ţ���Ϣ
			session.put("adminuser", a);
			return SUCCESS;
		}
	return ERROR;
	}
	//����Աע����ȥ���Ự�еĹ���Ա�˺���Ϣ���ɣ��������service��
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
