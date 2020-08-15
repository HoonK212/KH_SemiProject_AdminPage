package web.controller.Admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Fran;
import web.service.face.FranMenuService;
import web.service.impl.FranMenuServiceImpl;
import web.util.Paging;

@WebServlet("/view/fran")
public class ViewFranController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FranMenuService franMenuService = new FranMenuServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//요청파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = franMenuService.getPagingReport(req);
		
		//게시글 페이징 처리 조회
		Map<Fran, String> franView = franMenuService.viewFran(paging);
		 
		
		//페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
	

		req.setAttribute("franList", franView);
		req.getRequestDispatcher("/WEB-INF/views/fran/fran_list.jsp")
			.forward(req, resp);
	
	}
}
