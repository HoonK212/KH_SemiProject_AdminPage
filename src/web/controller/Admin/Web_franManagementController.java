package web.controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Fran;
import web.dto.Menu;
import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;

@WebServlet("/web/franman")
public class Web_franManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FranMenuService franmenuService = new FranMenuServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Fran,Menu> map = franmenuService.FranMenuSelect();

		List<Fran>franKey = new ArrayList<>();
		List<Menu>menuval = new ArrayList<>();
		for(Fran key:map.keySet()) {
			franKey.add(key);
			menuval.add(map.get(key));
		}
		
		//멤버 조회하기
		request.setAttribute("frankey", franKey);	
		request.setAttribute("menuval", menuval);	
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("login") == null) {
			
			response.sendRedirect("/m/web");
	
		}else if ((boolean)session.getAttribute("login") == true) {
			request.getRequestDispatcher("/WEB-INF/views/web_fran_management.jsp").forward(request, response);
		}

	}
		
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
