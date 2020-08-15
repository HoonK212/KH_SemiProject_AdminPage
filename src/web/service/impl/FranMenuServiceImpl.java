package web.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.FranDao;
import web.dao.impl.FranDaoImpl;
import web.dto.Blind;
import web.dto.Fran;
import web.dto.Image;
import web.dto.Menu;
import web.service.face.FranMenuService;
import web.util.Paging;

public class FranMenuServiceImpl implements FranMenuService{
private FranDao franDao = new FranDaoImpl();

	@Override
	public Map<Fran, Menu> FranMenuSelect() {
	
		
		return franDao.SelectFranMenu();
	}

	@Override
	public Map<Fran, Menu> FranMemberSelect(HttpServletRequest req) {
		//모달내에 해당하는 정보를 넘겨주는 service (해당 fran넘버의 값으로 넘겨줌)
		Menu menu = new Menu();
		menu.setMenuNo(Integer.parseInt(req.getParameter("menuno")));
		
		return franDao.SelectFranMember(menu);
	}

	@Override
	public List<Image> FramnImageSelect(HttpServletRequest req) {
		//모달에 해당하는 이미지를 넘겨주는 service (해당 메뉴의 넘버로 넘겨줌)
		Menu menu = new Menu();
		menu.setMenuNo(Integer.parseInt(req.getParameter("menuno")));
		
		
		
		return franDao.SelectImage(menu);
	}

	@Override
	public void FranMenuUpdate(HttpServletRequest req) {
		
		Menu menu = new Menu();
		menu.setMenuNo(Integer.parseInt((String) req.getAttribute("menuno")));
		franDao.MenuUpdate(menu);
		
	}

	@Override
	public Map<Fran, Menu> FranBlindSelect() {

		
		return franDao.SelectFranBlind();
	}

	@Override
	public Map<Menu, Blind> BlindInfoSelect(HttpServletRequest req) {
		Menu menu = new Menu();
		menu.setMenuNo(Integer.parseInt(req.getParameter("menuno")));
		
		return franDao.SelectMenuAndBlind(menu);
	}

	@Override
	public List<Image> BlindImageSelect(HttpServletRequest req) {
		Menu menu = new Menu();
		menu.setMenuNo(Integer.parseInt(req.getParameter("menuno")));
		
		return franDao.SelectBlindImage(menu);
	}

	@Override
	public void BlindMenuUpdate(HttpServletRequest req) {
		Menu menu = new Menu();
		Blind blind = new Blind();
		
		menu.setMenuNo(Integer.parseInt((String) req.getAttribute("menuno")));
		blind.setMenuNo(Integer.parseInt((String) req.getAttribute("menuno")));
		
		franDao.BlindUpdate(menu);
		franDao.BlindUpdateB(blind);
		
		
	}
//--------------------------------------------------------------------
	
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
		int totalCount = franDao.selectCntFran(search);

		//Paging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
		
		//Paging 객체 반환
		return paging;
	}

	@Override
	public Map<Fran, String> viewFran(Paging paging) {
		return franDao.selectFran(paging);
	}


}
