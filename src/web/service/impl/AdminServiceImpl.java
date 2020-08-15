package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.AdminDao;
import web.dao.impl.AdminDaoImpl;
import web.dto.Admin;
import web.service.face.AdminService;

public class AdminServiceImpl implements AdminService{
private AdminDao adminDao = new AdminDaoImpl();
	@Override
	public boolean login(Admin admin) {
	boolean loginaut = true;
		
		int aut = adminDao.selectCntMemberByAdminIdAdminPw(admin);
		
		//로그인 성공
		if( aut == 1) {
			loginaut = true;
			//로그인 실패
		}else if (aut == 0) {
			loginaut = false;	
		}
		
		return loginaut;
	}

	@Override
	public Admin getLoginAdmin(HttpServletRequest request) {
		
		Admin admin = new Admin();
		String id = request.getParameter("adminid");
		String pw = request.getParameter("adminpw");
		admin.setAdminId(id);
		admin.setAdminPw(pw);
		adminDao.selectCntMemberByAdminIdAdminPw(admin);
	
		
		return admin;
	}

	@Override
	public Admin getAdminByAdminid(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.selectAdminByAdminid(admin);
	}


}
