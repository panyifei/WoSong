package wosong.Controller; 

import java.util.List;

import wosong.domain.Admin;
import wosong.domain.Order;
import wosong.domain.Order_detail;
import wosong.domain.Senter;
import wosong.domain.User;

import com.jfinal.core.Controller; 
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
public class AdminLoginController extends Controller { 
 
public void index() { 
	render("login/login.html");
} 

public void doLogin(){
	
	Admin admin=Admin.loginAdmin(getPara("admin_name"), getPara("password"));
	if(admin!=null){	
	this.getSession().setAttribute("admin_name",getPara("admin_name"));	
	this.getSession().setAttribute("school",admin.get("school"));	
    String school=admin.get("school")+"";

	setAttr("admin", admin);
				if(school.equals("досй")){
					renderJsp("admin/adminMain.jsp");
				}else if(school.equals("дое╘")){
					renderJsp("admin/adminMain.jsp");
				}else{
					renderJsp("admin/adminMain.jsp");
				}

	}else{
	render("login/login.html");
	}
}



}