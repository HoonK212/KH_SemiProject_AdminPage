package web.controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.User;
import web.service.face.UserInfoService;
import web.service.impl.UserInfoServiceImpl;

@WebServlet("/web/main")
public class ViewGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userinfo = new UserInfoServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> list = userinfo.SelectUser();
		
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("login") == null) {
			
			response.sendRedirect("/m/web");
	
		}else if ((boolean)session.getAttribute("login") == true) {
			request.getRequestDispatcher("/WEB-INF/views/web_main_grade.jsp").forward(request, response);
		}

	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
