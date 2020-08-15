package web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import web.dao.face.UserDao;
import web.dao.impl.UserDaoImpl;
import web.dto.User;
import web.service.face.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService{
private UserDao userDao = new UserDaoImpl();
	@Override
	public List<User> SelectUser() {
		

		
		return userDao.userSelectList();
	}

@Override
public Map<Date, Integer> SelectUserDate() {
	
	return userDao.userDate();
}



}
