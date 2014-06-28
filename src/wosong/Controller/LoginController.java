package wosong.Controller; 
import java.util.List;

import wosong.domain.User;

import com.jfinal.core.Controller; 
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
public class LoginController extends Controller { 
 
public void index() { 
renderJson("{\"age\":18}");
} 

public void doLogin(){
	
	User user=User.loginUser(getPara("user_name"), getPara("password"));
	if(user!=null){	
    String s=user.toJson();
    renderJson(s);
	}else{
	renderJson("{\"id\":-1}");
	}
}

}