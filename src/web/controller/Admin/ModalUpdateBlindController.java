package web.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;

/**
 * Servlet implementation class ModalUpdateBlindController
 */
@WebServlet("/web/main/blind/update")
public class ModalUpdateBlindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FranMenuService franService = new FranMenuServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("menuno", request.getParameter("menuno"));
		
		franService.BlindMenuUpdate(request);
		
		response.sendRedirect("/m/web/main/blind");

	
	}


}
