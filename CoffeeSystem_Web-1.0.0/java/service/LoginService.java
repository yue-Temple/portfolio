package service;

import DTO.Staff;

public class LoginService {

	private final String password = "koko";

	public boolean loginSystem(String id, String pass) {
		//処理
		StaffDAO dao = null;
		Staff staff = null;
		boolean flag = false;
		dao = new StaffDAO();
		try {
			if (!id.equals("")) {
				staff = dao.selectID(id);

				if (id.equals(staff.getId()) && pass.equals(password)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}

	public String getstaffid(String id) {
		StaffDAO dao = null;
		Staff staff = null;
		dao = new StaffDAO();
		staff = dao.selectID(id);
		String staffid = staff.getId();
		return staffid;
	}
}
