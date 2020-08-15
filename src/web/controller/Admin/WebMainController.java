package web.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Admin;
import web.service.face.AdminService;
import web.service.impl.AdminServiceImpl;

@WebServlet("/web")
public class WebMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/web_main_login.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//아이디 비밀번호 정보 넣기
		
		 Admin admin = adminService.getLoginAdmin(request);
		 
			admin = adminService.getAdminByAdminid(admin);
		

		
		
		//로그인 확인
		
		
		
		
		HttpSession session = request.getSession(); //세션 객체 생성
		
		
		
					boolean log = adminService.login(admin);
		
					
					
					
				if( log == true ) {
					//로그인 성공
					session.setAttribute("login",true); //로그인상태, login=true
					session.setAttribute("adminid", admin.getAdminId()); //로그인아이디
					session.setAttribute("adminname", admin.getAdminName()); //로그인아이디
					response.sendRedirect("/m/web/main");

				} else {
					
					//로그인 실패
					response.sendRedirect("/m/fran");
				}
		
		
		
		
		
	
	
	}
	
}
