package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import web.dao.face.FranDao;
import web.dbutil.JDBCTemplate;
import web.dto.Blind;
import web.dto.Fran;
import web.dto.Image;
import web.dto.Menu;
import web.util.Paging;

public class FranDaoImpl implements FranDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public Map<Fran, Menu> SelectFranMenu() {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "select f.fran_no,f.fran_name,m.menu_name,m.menu_no\r\n" + 
				"from fran f , menu m\r\n" + 
				"where m.fran_no = f.fran_no and menu_stat = 'N' order by menu_no desc";
		Map<Fran,Menu> map = new LinkedHashMap<Fran, Menu>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {	
				Fran fran = new Fran();
				Menu menu = new Menu();
				
				fran.setFranNo(rs.getInt("fran_no"));
				fran.setFranName(rs.getString("fran_name"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuNo(rs.getInt("menu_no"));
				map.put(fran,menu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return map;
		}
		
		
	
	@Override
	public Map<Fran, Menu> SelectFranMember(Menu mn) {

		conn = JDBCTemplate.getConnection();
		
		String sql = "select f.fran_no," + 
				"          f.fran_name," + 
				"          m.menu_name," + 
				"           m.menu_date," + 
				" m.menu_info,m.menu_cost" + 
				" from fran f , menu m" + 
				" where m.fran_no = f.fran_no" + 
				"    and menu_stat = 'N'" + 
				"    and m.menu_no = ?";
		
		
		Map<Fran,Menu> map = new LinkedHashMap<Fran, Menu>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mn.getMenuNo());
			rs = ps.executeQuery();
			while(rs.next()) {	
				Fran fra = new Fran();
				Menu menu = new Menu();
				
				fra.setFranName(rs.getString("fran_name"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuDate(rs.getDate("menu_date"));
				menu.setMenuInfo(rs.getString("menu_info"));
				menu.setMenuCost(rs.getInt("menu_cost"));
				map.put(fra, menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return map;
	}
	
	@Override
	public List<Image> SelectImage(Menu menu) {
	conn = JDBCTemplate.getConnection();
		
		String sql = " select i.img_name,i.img_server,i.img_ext from image i , menu m  where m.menu_no = i.menu_no" + 
				" and m.menu_no = ? and menu_stat = 'N'";
		
		List<Image> list = new ArrayList<Image>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, menu.getMenuNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {	
			Image image = new Image();
			image.setImgName(rs.getString("img_name"));
			image.setImgServer(rs.getString("img_server"));
				
				
			list.add(image);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}



	@Override
	public void MenuUpdate(Menu menu) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "update menu set menu_stat = 'Y' where menu_no = ? ";
	
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , menu.getMenuNo());	
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		
		}
		
		
	}



	@Override
	public Map<Fran, Menu> SelectFranBlind() {
conn = JDBCTemplate.getConnection();
		
		String sql = "select f.fran_no,f.fran_name,m.menu_name,m.menu_no from fran f, menu m, blind b";
			sql +=	" 	where f.fran_no = m.fran_no and m.menu_no = b.menu_no and b.blind_yn = 'N' order by b.blind_no desc";
		Map<Fran,Menu> map = new LinkedHashMap<Fran, Menu>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {	
				Fran fran = new Fran();
				Menu menu = new Menu();
				
				fran.setFranNo(rs.getInt("fran_no"));
				fran.setFranName(rs.getString("fran_name"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuNo(rs.getInt("menu_no"));
				map.put(fran,menu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return map;
	}


//	모달내부의 메뉴와 블라인드 내용을 뽑아줄 메소드
	@Override
	public Map<Menu, Blind> SelectMenuAndBlind(Menu menu) {
		conn = JDBCTemplate.getConnection();
		String sql = "select m.menu_no,m.menu_name, b.blind_rsn, b.blind_date,b.blind_start,b.blind_note" + 
				" from menu m , blind b where m.menu_no = b.menu_no and m.menu_no = ?";
		Map<Menu,Blind> map = new LinkedHashMap<Menu, Blind>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, menu.getMenuNo());
			rs = ps.executeQuery();
			
			
			while(rs.next() ) {
				Menu menu1 = new Menu();
				Blind blind = new Blind();
				
				menu1.setMenuNo(rs.getInt("menu_no"));
				menu1.setMenuName(rs.getString("menu_name"));
				blind.setBlindRsn(rs.getString("blind_rsn"));
				blind.setBlindDate(rs.getDate("blind_date"));
				blind.setBlindStart(rs.getDate("blind_start"));
				blind.setBlindNote(rs.getString("blind_note"));
				
				map.put(menu1, blind);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return map;
	}


//	모달내부의 이미지를 출력해줄 메소드
	@Override
	public List<Image> SelectBlindImage(Menu menu) {
conn = JDBCTemplate.getConnection();
		
		String sql = " select i.img_name,i.img_server,i.img_ext from image i , menu m  where m.menu_no = i.menu_no" + 
				" and m.menu_no = ? and menu_blind = 'N'";
		
		List<Image> list = new ArrayList<Image>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, menu.getMenuNo());
			rs = ps.executeQuery();
			
			while(rs.next()) {	
			Image image = new Image();
			image.setImgName(rs.getString("img_name"));
			image.setImgServer(rs.getString("img_server"));
				
				
			list.add(image);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}


//블라인드를 업데이트해주는 메소드
	@Override
	public void BlindUpdate(Menu menu) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "update menu set menu_blind = 'Y' where menu_no = ? ";
	
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , menu.getMenuNo());	
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		
		}
		
		
	}



@Override
public void BlindUpdateB(Blind blind) {
	conn = JDBCTemplate.getConnection();
	
	String sql = "update blind set blind_yn = 'Y' where menu_no = ? ";
	
	try {
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1 , blind.getMenuNo());	
		ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	
	}
	
	
}
	//--------------------------------------------------------------------

	@Override
	public int selectCntFran(String search) {
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM fran WHERE fran_name LIKE '%'||?||'%'";
		
		//최종 결과값
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, search);
			
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
	public Map<Fran, String> selectFran(Paging paging) {
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, C.* FROM ("; 
		sql += "	SELECT F.*, D.food_name FROM fran F JOIN food D on F.food_no=D.food_no";
		sql += "		WHERE fran_name LIKE '%'||?||'%'"; 
		sql += "    ) C";
		sql += "    ORDER BY rnum";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		Map<Fran, String> franList = new LinkedHashMap<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());	//페이징 게시글 시작 번호
			ps.setInt(3, paging.getEndNo());	//페이징 게시글 끝 번호
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Fran fran = new Fran();
				//결과값 한 행 처리
				fran.setFranNo(rs.getInt("fran_no"));
				fran.setFranName(rs.getString("fran_name"));
				
				//리스트에 결과값 저장
				franList.put(fran,rs.getString("food_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//최종 결과 반환
		return franList;
	}



}