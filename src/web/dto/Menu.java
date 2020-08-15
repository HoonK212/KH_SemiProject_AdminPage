package web.dto;

import java.util.Date;

public class Menu {

	private int	menuNo;
	private String menuName;
	private String menuInfo;
	private int	menuCost;
	private Date menuDate;
	private char menuStat;
	private char menuBlind;
	private int	franNo;
	
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", menuInfo=" + menuInfo + ", menuCost=" + menuCost
				+ ", menuDate=" + menuDate + ", menuStat=" + menuStat + ", menuBlind=" + menuBlind + ", franNo="
				+ franNo + "]";
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	public int getMenuCost() {
		return menuCost;
	}
	public void setMenuCost(int menuCost) {
		this.menuCost = menuCost;
	}
	public Date getMenuDate() {
		return menuDate;
	}
	public void setMenuDate(Date menuDate) {
		this.menuDate = menuDate;
	}
	public char getMenuStat() {
		return menuStat;
	}
	public void setMenuStat(char menuStat) {
		this.menuStat = menuStat;
	}
	public char getMenuBlind() {
		return menuBlind;
	}
	public void setMenuBlind(char menuBlind) {
		this.menuBlind = menuBlind;
	}
	public int getFranNo() {
		return franNo;
	}
	public void setFranNo(int franNo) {
		this.franNo = franNo;
	}

	
	
	
	

}
