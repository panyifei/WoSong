package wosong.domain;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class Shopping_cart extends Model<Shopping_cart>{
	public static Shopping_cart dao=new Shopping_cart();
	
	public static Shopping_cart createShopping_cart(String user_id){

		Shopping_cart sc = new Shopping_cart();
		sc.set("user_id", user_id);
		sc.save();
	    System.out.println(sc.getInt("id"));
		return sc;
		}
		
	
	
}
