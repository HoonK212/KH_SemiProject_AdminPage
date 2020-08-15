package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dao.face.AdminDao;
import web.dbutil.JDBCTemplate;
import web.dto.Admin;

public class AdminDaoImpl implements AdminDao{
	

	@Override
	public int selectCntMemberByAdminIdAdminPw(Admin admin) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT count(*) FROM admin where admin_id = ? and admin_pw = ? ";
		conn = JDBCTemplate.getConnection();						
		
		
		// 결과 저장할 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, admin.getAdminId());
			ps.setString(2, admin.getAdminPw());
			
			rs = ps.executeQuery();

			// 조회 결과 처리
			while (rs.next()) {
				count = rs.getInt(1);
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
				e.printStackTrace();
			}
		
		}

		return count;
	}

	@Override
	public Admin selectAdminByAdminid(Admin admin) {
		Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		

		String sql = "";
		sql += " SELECT * FROM admin WHERE admin_id = ?";
		conn = JDBCTemplate.getConnection();						
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, admin.getAdminId());
			
			rs = ps.executeQuery();

			// 조회 결과 처리
			while (rs.next()) {
			admin.setAdminId(rs.getString("admin_id"));
			admin.setAdminName(rs.getString("admin_name"));
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

		return admin;
	}
	

}
