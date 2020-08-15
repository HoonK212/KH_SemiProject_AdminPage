package web.dto;

import java.util.Date;

public class User {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userNick;
	private Date userBirth;
	private char userGender;
	private String userEmail;
	private int	userTel;
	private Date userDate;
	private int	userCnt;
	private int	userAuth;
	private int	userGrade;
	private char userReport;
	private int	franNo;
	private int count;
	private int startcnt;
	private int reviewcnt;
	private String targetId;

	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public int getStartcnt() {
		return startcnt;
	}
	public void setStartcnt(int startcnt) {
		this.startcnt = startcnt;
	}
	public int getReviewcnt() {
		return reviewcnt;
	}
	public void setReviewcnt(int reviewcnt) {
		this.reviewcnt = reviewcnt;
	}

	
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userNick=" + userNick + ", userBirth=" + userBirth + ", userGender=" + userGender + ", userEmail="
				+ userEmail + ", userTel=" + userTel + ", userDate=" + userDate + ", userCnt=" + userCnt + ", userAuth="
				+ userAuth + ", userGrade=" + userGrade + ", userReport=" + userReport + ", franNo=" + franNo
				+ ", count=" + count + ", startcnt=" + startcnt + ", reviewcnt=" + reviewcnt + ", targetId=" + targetId
				+ "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserTel() {
		return userTel;
	}
	public void setUserTel(int userTel) {
		this.userTel = userTel;
	}
	public Date getUserDate() {
		return userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	public int getUserCnt() {
		return userCnt;
	}
	public void setUserCnt(int userCnt) {
		this.userCnt = userCnt;
	}
	public int getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(int userAuth) {
		this.userAuth = userAuth;
	}
	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
	public char getUserReport() {
		return userReport;
	}
	public void setUserReport(char userReport) {
		this.userReport = userReport;
	}
	public int getFranNo() {
		return franNo;
	}
	public void setFranNo(int franNo) {
		this.franNo = franNo;
	}
	
	
	
}
