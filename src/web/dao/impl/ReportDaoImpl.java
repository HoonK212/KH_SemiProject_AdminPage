package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import web.dao.face.ReportDao;
import web.dbutil.JDBCTemplate;
import web.dto.Board;
import web.dto.Report;
import web.dto.User;
import web.util.Paging;

public class ReportDaoImpl implements ReportDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public int selectCntReport() {
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM report";
		
		//최종 결과값
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과집합 반환
			
			//조회결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}

	@Override
	public Map<User, Report> selectReport(Paging paging) {
		//DB연결 객체
				conn = JDBCTemplate.getConnection();
				
				//SQL 작성
				String sql = "";
				sql += "SELECT * FROM (";
				sql += "    SELECT rownum rnum, C.* FROM ("; 
				sql += " select A.*, (select B.users_id from users B where B.users_no=A.rpt_target) as target_name from";
				sql += " 				(SELECT";
				sql += " r.*, u.users_id";
				sql += " FROM";
				sql += " report r, users u where r.rpt_users = u.users_no) A";
				sql += "        ORDER BY rpt_no DESC";
				sql += "    ) C";
				sql += "    ORDER BY rnum";
				sql += " ) BOARD";
				sql += " WHERE rnum BETWEEN ? AND ?";

				
				
				
				//결과 저장할 List
				Map<User, Report> reportList = new LinkedHashMap<>();
				
				try {
					ps = conn.prepareStatement(sql); //SQL수행 객체
					
//					ps.setString(1, paging.getSearch());
					ps.setInt(1, paging.getStartNo());	//페이징 게시글 시작 번호
					ps.setInt(2, paging.getEndNo());	//페이징 게시글 끝 번호
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						Report report = new Report(); //결과값 저장 객체
						User user = new User();
						
						//결과값 한 행 처리
						report.setRptNo(rs.getInt("rpt_no"));
						report.setRptRsn(rs.getInt("rpt_rsn"));
						report.setRptDetail(rs.getString("rpt_detail"));
						report.setRptDate(rs.getDate("rpt_date"));
						report.setRptYn(rs.getString("rpt_yn"));
						report.setRptManage(rs.getInt("rpt_manage"));
						report.setRptNote(rs.getString("rpt_note"));
						report.setRptUser(rs.getInt("rpt_users"));
						report.setRptTarget(rs.getInt("rpt_target"));
						report.setReviewNo(rs.getInt("review_no"));
						user.setUserId(rs.getString("users_id"));
						user.setTargetId(rs.getString("target_name"));
						
						//리스트에 결과값 저장
						reportList.put(user, report);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				//최종 결과 반환
				return reportList;
	}

	@Override
	public Map<User, Report> selectMeasure(int rptNo) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += " select A.*, (select B.users_id from users B where B.users_no=A.rpt_target) as target_name from";
		sql += " 				(SELECT";
		sql += " r.*, u.users_id";
		sql += " FROM";
		sql += " report r, users u where r.rpt_users = u.users_no) A";
		sql += " WHERE rpt_no=?";
		
		//결과 저장할 List
		Map<User, Report> reportList = new LinkedHashMap<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, rptNo);	//페이징 게시글 시작 번호

			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			

			//조회 결과 처리
			while(rs.next()) {
				Report report = new Report(); //결과값 저장 객체
				User user = new User();
				
				//결과값 한 행 처리
				report.setRptNo(rs.getInt("rpt_no"));
				report.setRptRsn(rs.getInt("rpt_rsn"));
				report.setRptDetail(rs.getString("rpt_detail"));
				report.setRptDate(rs.getDate("rpt_date"));
				report.setRptYn(rs.getString("rpt_yn"));
				report.setRptManage(rs.getInt("rpt_manage"));
				report.setRptNote(rs.getString("rpt_note"));
				report.setRptUser(rs.getInt("rpt_users"));
				report.setRptTarget(rs.getInt("rpt_target"));
				report.setReviewNo(rs.getInt("review_no"));
				user.setUserId(rs.getString("users_id"));
				user.setTargetId(rs.getString("target_name"));
				
				//리스트에 결과값 저장
				reportList.put(user, report);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//최종 결과 반환
		return reportList;
	}

	@Override
	public List<User> selectMeasureTarget(int rptNo) {
		//DB연결 객체
				conn = JDBCTemplate.getConnection();
				
				//SQL 작성
				String sql = "";
				sql += "        SELECT";
				sql += "			r.*, u.users_id";
				sql += "        FROM report r join users u on r.rpt_target = u.users_no";
				sql += "        WHERE rpt_no=?";
				
				//결과 저장할 List
				List<User> reportList = new ArrayList<>();
				
				try {
					ps = conn.prepareStatement(sql); //SQL수행 객체
					ps.setInt(1, rptNo);	//페이징 게시글 시작 번호

					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					

					//조회 결과 처리
					while(rs.next()) {
						User user = new User(); //결과값 저장 객체
						
						//결과값 한 행 처리
						user.setUserNo(rs.getInt("users_no"));
						
						//리스트에 결과값 저장
						reportList.add(user);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				//최종 결과 반환
				return reportList;
	}

	@Override
	public void updateMeasure(Report report) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		
		sql += "UPDATE report SET rpt_manage=?, rpt_note=?, rpt_yn='Y' WHERE rpt_no=?";
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, report.getRptManage());	//페이징 게시글 시작 번호
			ps.setString(2, report.getRptNote());
			ps.setInt(3, report.getRptNo());
			
			ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	}

}
