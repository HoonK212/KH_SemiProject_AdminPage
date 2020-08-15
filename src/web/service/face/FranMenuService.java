package web.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import web.dto.Blind;
import web.dto.Fran;
import web.dto.Image;
import web.dto.Menu;
import web.util.Paging;

public interface FranMenuService {
	//메뉴 신청해야할 메소드들
	public Map<Fran,Menu> FranMenuSelect();
	public Map<Fran,Menu> FranMemberSelect(HttpServletRequest req);
	public List<Image> FramnImageSelect(HttpServletRequest req);
	public void FranMenuUpdate(HttpServletRequest req);
	
	//블라인드 신청때 사용하는 메소드들
	//페이지 화면에 띄워지는 블라인드 값
	public Map<Fran,Menu> FranBlindSelect();
	public Map<Menu,Blind> BlindInfoSelect(HttpServletRequest req);
	public List<Image> BlindImageSelect(HttpServletRequest req);
	public void BlindMenuUpdate(HttpServletRequest req);

	//--------------------------------------------------------------------
	
	public Paging getPagingReport(HttpServletRequest req);
	public Map<Fran, String> viewFran(Paging paging);

}
