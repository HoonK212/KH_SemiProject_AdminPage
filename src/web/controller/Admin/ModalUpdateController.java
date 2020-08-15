package web.controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;

@WebServlet("/web/main/fran/update")
public class ModalUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private FranMenuService franmenuService = new FranMenuServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("menuno", req.getParameter("menuno"));

		franmenuService.FranMenuUpdate(req);
		resp.sendRedirect("/m/web/franman");


		
	}
}
