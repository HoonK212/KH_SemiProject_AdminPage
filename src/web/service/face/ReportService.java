package web.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Report;
import web.dto.User;
import web.util.Paging;

public interface ReportService {

	/**
	 * 요청 파라미터로 페이징 계산해서 페이징 객체 반환
	 * @param req - 요청 파라미터 객체
	 * @return Paging - 계산된 페이징 객체 반환
	 */
	public Paging getPagingReport(HttpServletRequest req);
	
	public Map<User, Report> getListReport(Paging paging);
	
	public void reportMeasure(HttpServletRequest req);
	
	public Map<User, Report> getReport(HttpServletRequest req);
	
	public List<User> getReportTarget(HttpServletRequest req);
}
