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

import web.dto.Blind;
import web.dto.Fran;
import web.dto.Image;
import web.dto.Menu;
import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;

@WebServlet("/web/blind/search")
public class BlindSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FranMenuService franmenuService = new FranMenuServiceImpl();
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Menu,Blind> map = franmenuService.BlindInfoSelect(request);
		
		List<Menu>menukey = new ArrayList<>();
		
		List<Blind>blindval = new ArrayList<>();
		
		for(Menu key:map.keySet()) {
			menukey.add(key);
			blindval.add(map.get(key));
		}
		//블라인드 모달값 출력을 위한....?값??
		request.setAttribute("mukey", menukey);	
		request.setAttribute("blval", blindval);	
	
		
		
		//블라인드 이미지 출력....
		List<Image> list = franmenuService.BlindImageSelect(request);
		request.setAttribute("bimglist", list);	
		// 파일경로 보내주기
		
		
		request.setAttribute("menuno", request.getParameter("menuno"));
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/web_blind_search.jsp").forward(request, response);
	
	
	}

}
