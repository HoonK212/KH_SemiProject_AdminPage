package web.controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Fran;
import web.dto.Image;
import web.dto.Menu;
import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;

@WebServlet("/web/franman/search")
public class Web_franManagementSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FranMenuService franmenuService = new FranMenuServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("menuno", request.getParameter("menuno"));
		
		List<Image> list = franmenuService.FramnImageSelect(request);
		
		
		
		
		
		
		Map<Fran,Menu> map = franmenuService.FranMemberSelect(request);
		
		
		List<Fran>franKey = new ArrayList<>();
		List<Menu>menuval = new ArrayList<>();
		for(Fran key:map.keySet()) {
			franKey.add(key);
			menuval.add(map.get(key));
		}
		//멤버 조회하기
		request.setAttribute("frkey", franKey);	
		request.setAttribute("muval", menuval);	
		request.setAttribute("imglist", list);	
		// 파일경로 보내주기
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/web_fran_management_search.jsp").forward(request, response);
		
	}

}
