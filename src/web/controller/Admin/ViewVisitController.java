package web.controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import web.dto.User;
import web.service.face.UserInfoService;
import web.service.impl.UserInfoServiceImpl;
@WebServlet("/web/visit")
public class ViewVisitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userinfo = new UserInfoServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map<Date,Integer> map = userinfo.SelectUserDate();
		
		 
		 
		 
		 Map<Date,Integer> graphMember = userinfo.SelectUserDate();
			List<Date>graphKey = new ArrayList<>();
			List<Integer>graphVal = new ArrayList<>();
			for(Date key:graphMember.keySet()) {
				graphKey.add(key);
				graphVal.add(graphMember.get(key));
			}
			
			//멤버 조회하기
		
			request.setAttribute("graphKey", graphKey);	
			request.setAttribute("graphVal", graphVal);		
			
		
		request.getRequestDispatcher("/WEB-INF/views/web_main_visit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
