package web.dao.face;

import java.util.Date;
import java.util.List;
import java.util.Map;

import web.dto.User;

public interface UserDao {

	public List<User> userSelectList();
	//유저의 가입현황을 가져오는 맵
	public Map<Date,Integer> userDate();
}
