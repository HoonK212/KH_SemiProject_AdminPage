package web.controller.Admin.Board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/posts/update")
public class BoardPostsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param = req.getParameter("bdNo");
		int bdNo = 0;
		if( param!=null && !"".equals(param) ) {
			bdNo = Integer.parseInt(param);
		}
		
		
		Board board = new Board();
		board = boardService.viewPostsDetail(bdNo);
		
		req.setAttribute("board", board);
		
		int userno = board.getUserNo();
		
		req.setAttribute("user", boardService.postsDetailUser(userno));
		
		req.getRequestDispatcher("/WEB-INF/views/board/updatePosts.jsp")
			.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		boardService.updatePostsAnswer(req);
		
		resp.sendRedirect("/m/view/posts");
	
	
	}
	
}
