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

import web.dto.Report;
import web.dto.User;
import web.service.face.ReportService;
import web.service.impl.ReportServiceImpl;
import web.util.Paging;

@WebServlet("/report/list")
public class ViewReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportService reportService = new ReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		//요청파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = reportService.getPagingReport(req);
		
		//게시글 페이징 처리 조회
		Map<User, Report> reportList = reportService.getListReport(paging);
		 
		
			List<User> userKey = new ArrayList<>();
			List<Report> reportVal = new ArrayList<>();
			for(User key:reportList.keySet()) {
				userKey.add(key);
				reportVal.add(reportList.get(key));
			}
			
		
		//페이징계산결과 MODEL값 전달
		req.setAttribute("paging", paging);
	
		//게시글 조회 MODEL값 전달
		req.setAttribute("reportkey", userKey);
		req.setAttribute("reportvalue", reportVal);

		req.getRequestDispatcher("/WEB-INF/views/report/report_list.jsp")
			.forward(req, resp);
	
	}
}
