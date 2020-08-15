package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.Admin;

public interface AdminService {
	
	public Admin getLoginAdmin(HttpServletRequest request);
	
	
	public boolean login(Admin admin);


	public Admin getAdminByAdminid(Admin admin);
	
	
}
