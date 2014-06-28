package wosong.Controller; 
import java.awt.Window;




import wosong.domain.User;

import com.jfinal.core.Controller; 
public class RegisterController extends Controller { 
 
public void index() { 
} 

public void doRegister(){
	User user=User.createUser(getPara("user_name"),getPara("password"),getPara("school"),getPara("address"));
	if(user==null){
		renderJson("{\"status\":false}");
	}else{
		renderJson("{\"status\":true}");
	}
}
}