package web.controller.Admin.Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.User;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/add/notice")
public class BoardAddNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 생성
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	
		req.getRequestDispatcher("/WEB-INF/views/board/addNotice.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		req.setCharacterEncoding("UTF-8");
		
		boardService.addNotice(req);
		
		resp.sendRedirect("/m/view/notice");
	}
}
