package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import web.dao.face.UserDao;
import web.dbutil.JDBCTemplate;
import web.dto.User;

public class UserDaoImpl implements UserDao{
	private StringBuffer sql;
	private Connection conn =null;
    private PreparedStatement ps =null;
    private ResultSet rs=null;
	
	@Override
	public Map<Date,Integer> userDate() {
		
			Map<Date,Integer> DateMap = new LinkedHashMap<Date, Integer>();
	    	Calendar calc = Calendar.getInstance();
	    	SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd");
	    	conn = JDBCTemplate.getConnection();
	    	sql = new StringBuffer();
	    	calc.setTime(new Date());
	    	
	    	calc.add(Calendar.DATE, -11);	    	
	    	String minDate = sb.format(calc.getTime()) ;
	    	
	    	calc.add(Calendar.DATE, 11);
	    	String maxDate = sb.format(calc.getTime());
	    	
	    	
	    	sql.append("select * from (select * from users where users_date<? and users_date>?) ");
	    	sql.append(" order by users_date");
	    	
	    	try {
				Date startDate= sb.parse(minDate);
				Date endDate = sb.parse(maxDate);
				//문자열 날짜
				ArrayList<Date> dates = new ArrayList<Date>();
				Date currentDate= startDate;
				while(currentDate.compareTo(endDate)<=0){
					dates.add(sb.parse(sb.format(currentDate)));
					Calendar c = Calendar.getInstance();
					c.setTime(currentDate);
					c.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = c.getTime();
				}
				
				ps =conn.prepareStatement(sql.toString());				
				ps.setString(1,maxDate);
				ps.setString(2,minDate);
				rs = ps.executeQuery();
								
				//해쉬맵에 최저 날짜부터 최대날짜까지 키값설정해주기 -> rs.next에서++;
				for(Date e: dates) {
					DateMap.put(e, 0);
				}
				while(rs.next()) {
				
					Date Date=sb.parse(rs.getString("users_date"));
					
					
					DateMap.put(Date,DateMap.getOrDefault(sb.parse(sb.format(rs.getDate("users_date"))), 0)+1);					
				
				
				}				
			
	    	}catch (SQLException e) {
				e.printStackTrace();
			}catch(ParseException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}

	    	return DateMap;
	    }

	@Override
	public List<User> userSelectList() {
		Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		

		String sql = "";
		sql += "select U.users_no, U.users_id, U.users_grade, (select count(*) from star S where U.users_no=S.users_No) as starCnt, (select count(*) from review R where U.users_no=R.users_No ) as reviewCnt from users U order by u.users_no";
		conn = JDBCTemplate.getConnection();						
		
		List<User> list = new ArrayList<>();	
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			// 조회 결과 처리
			while (rs.next()) {
			User user = new User();
			user.setUserNo(rs.getInt("users_no"));
			user.setUserId(rs.getString("users_id"));
			user.setUserGrade(rs.getInt("users_grade"));
			user.setStartcnt(rs.getInt("starcnt"));
			user.setReviewcnt(rs.getInt("reviewcnt"));
			
				
			list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return list;
	}

}
