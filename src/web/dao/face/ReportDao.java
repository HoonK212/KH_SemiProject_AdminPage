package web.dao.face;

import java.util.List;
import java.util.Map;

import web.dto.Board;
import web.dto.Report;
import web.dto.User;
import web.util.Paging;

public interface ReportDao {

	/**
	 * 총 게시글 수 조회
	 * @return 총 게시글 수 반환
	 */
	public int selectCntReport();
	
	public Map<User, Report> selectReport(Paging paging);
	
	public Map<User, Report> selectMeasure(int rptNo);
	
	public List<User> selectMeasureTarget(int rptNo);
	
	public void updateMeasure(Report report);
}
