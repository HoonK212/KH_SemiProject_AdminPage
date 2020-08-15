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

@WebServlet("/report/measure")
public class ReportMeasureController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReportService reportService = new ReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<User, Report> reportList = reportService.getReport(req);
		
		List<User> userKey = new ArrayList<>();
		List<Report> reportVal = new ArrayList<>();
		for(User key:reportList.keySet()) {
			userKey.add(key);
			reportVal.add(reportList.get(key));
		}
		
		req.setAttribute("reportkey", userKey);
		req.setAttribute("reportvalue", reportVal);
		req.getRequestDispatcher("/WEB-INF/views/report/report_measure.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		reportService.reportMeasure(req);
		
		resp.sendRedirect("/m/report/list");
	
	}
}
