package web.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.ReportDao;
import web.dao.impl.ReportDaoImpl;
import web.dto.Board;
import web.dto.Report;
import web.dto.User;
import web.service.face.ReportService;
import web.util.Paging;

public class ReportServiceImpl implements ReportService {

	private ReportDao reportDao = new ReportDaoImpl();
	
	@Override
	public Paging getPagingReport(HttpServletRequest req) {
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		//검색어
		String search = (String)req.getParameter("search");
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = reportDao.selectCntReport();

		//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
		
		//Paging 객체 반환
		return paging;
	}

	@Override
	public Map<User, Report> getListReport(Paging paging) {
		return reportDao.selectReport(paging);
	}

	@Override
	public void reportMeasure(HttpServletRequest req) {

		
		String param = req.getParameter("rptNo");
		int rptNo = 0;
		if( param!=null && !"".equals(param) ) {
			rptNo = Integer.parseInt(param);
		}
		
		//전달파라미터 curPage를 파싱한다
		String param2 = req.getParameter("rptManage");
		int rptManage = 0;
		if( param2!=null && !"".equals(param2) ) {
			rptManage = Integer.parseInt(param2);
		}
		
		Report report = new Report();
		report.setRptNo(rptNo);
		report.setRptManage(rptManage);
		report.setRptNote((String)req.getParameter("rptNote"));
		
		reportDao.updateMeasure(report);

	}

	@Override
	public Map<User, Report> getReport(HttpServletRequest req) {
		
		String param = req.getParameter("rptNo");
		int rptNo = 0;
		if( param!=null && !"".equals(param) ) {
			rptNo = Integer.parseInt(param);
		}
		return reportDao.selectMeasure(rptNo);
	}

	@Override
	public List<User> getReportTarget(HttpServletRequest req) {
		
		String param = req.getParameter("rptNo");
		int rptNo = 0;
		if( param!=null && !"".equals(param) ) {
			rptNo = Integer.parseInt(param);
		}
		
		return reportDao.selectMeasureTarget(rptNo);
	}

}
