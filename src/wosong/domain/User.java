package wosong.domain;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class User extends Model<User>{
	public static User dao=new User();
	
	public static User createUser(String user_name,String password,String school,String address){
		List<User> users = User.dao.find("select * from user where  user_name=?",user_name);
		if(users.size()!=0){
		return null;
		}else{	
			User u = new User();
			u.set("user_name", user_name);
			u.set("password", password);
			u.set("school", school);
			u.set("address", address);
			u.save();
			String user_id=u.getInt("id")+"";
			Shopping_cart sc=Shopping_cart.createShopping_cart(user_id);
			System.out.println(sc);
			u.set("shopping_cart_id",sc.getInt("id"));
			u.update();
			return u;
		}
		
		
		
	}
	
	public static User loginUser(String user_name,String password){
		List<User> users = User.dao.find("select * from user where user_name=? and password=?",user_name,password);
		if(users.size()!=0){
		return users.get(0);
		}else{
			return null;
		}
	}

	
	
	
}
