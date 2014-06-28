package wosong.domain;


import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class Admin extends Model<Admin>{
	public static Admin dao=new Admin();

	public static Admin loginAdmin(String admin_name, String password) {
		List<Admin> admins = Admin.dao.find("select * from admin where admin_name=? and password=?",admin_name,password);
		if(admins.size()!=0){
		return admins.get(0);
		}else{
			return null;
		}
	}

	
}
