package web.dao.face;

import java.util.List;
import java.util.Map;

import web.dto.Blind;
import web.dto.Fran;
import web.dto.Image;
import web.dto.Menu;
import web.util.Paging;

public interface FranDao {
	//메뉴조회 + 메뉴 자세히보기 ajax를 위한 기능들
	public Map<Fran,Menu> SelectFranMenu();
	public Map<Fran,Menu> SelectFranMember(Menu menu);
	public List<Image> SelectImage(Menu menu);
	public void MenuUpdate(Menu menu);
	//-------------------------------------------
	//블라인드 조회 + 블라인드 자세히보기 ajax를 위한 기능들
	
	//맨처음에 화면에 나오는 블라인드 메뉴에 해당하는 값을 뽑아오는 메소드
	public Map<Fran,Menu> SelectFranBlind();
	//모달내부에 나와야하는 블라인드 메뉴의 값
	public Map<Menu,Blind> SelectMenuAndBlind(Menu menu);
	//모달내부에 나와야하는 이미지
	public List<Image> SelectBlindImage(Menu menu);
	//블라인드 업데이트 메소드
	public void BlindUpdate(Menu menu);
	public void BlindUpdateB(Blind blind);
		
	//--------------------------------------------------------------------

	public int selectCntFran(String search);
	public Map<Fran, String> selectFran(Paging paging);
}
