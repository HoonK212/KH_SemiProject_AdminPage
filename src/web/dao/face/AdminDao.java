package web.dao.face;

import web.dto.Admin;

public interface AdminDao {

	int selectCntMemberByAdminIdAdminPw(Admin admin);

	Admin selectAdminByAdminid(Admin admin);

}
