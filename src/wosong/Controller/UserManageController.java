package wosong.Controller; 

import java.util.List;

import wosong.domain.Food;
import wosong.domain.Order;
import wosong.domain.Order_detail;
import wosong.domain.Shopping_cart_detail;
import wosong.domain.User;

import com.jfinal.core.Controller; 
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
public class UserManageController extends Controller { 
 
public void index() { 

} 

	//存入购物车
	public void storeInShoppingCart() { 
		List<User> users = User.dao.find("select * from user where id=?",getPara("user_id"));
		if(users.size()!=0){
			Shopping_cart_detail scd = new Shopping_cart_detail();
			scd.set("shopping_cart_id", users.get(0).getInt("shopping_cart_id"));
			scd.set("food_id", getPara("food_id"));
			scd.set("count", getPara("count"));
			scd.save();		
			renderJson("{\"status\":true}");
		}else{
			renderJson("{\"status\":false}");
		}
	 
	} 

	//查看购物车
	public void showShoppingCart() { 
		String shoppingCart="";
		List<User> users = User.dao.find("select * from user where id=?",getPara("user_id"));
		if(users.size()!=0){
			
			List<Shopping_cart_detail> scds = Shopping_cart_detail.dao.find("select * from shoppingCartDetail where shopping_cart_id=?",users.get(0).getInt("shopping_cart_id"));
			for(int i=0;i<scds.size();i++){
				if(i==0){
					shoppingCart= scds.get(i).toJson();
				}else{
					shoppingCart= shoppingCart+","+scds.get(i).toJson();
				}
				
			}
			shoppingCart="["+shoppingCart+"]";
			renderJson(shoppingCart);
		}else{
			renderJson("{\"status\":false}");
		}
	} 

	//生成订单
	public void setOrder(){
		double sum_price=0.0;
		List<User> users = User.dao.find("select * from user where id=?",getPara("user_id"));
		if(users.size()!=0){
			Order o = new Order();
			o.set("user_id", users.get(0).getInt("id"));
			o.set("user_name", users.get(0).getStr("user_name"));
			o.set("school", users.get(0).getStr("school"));
			o.set("tel_phone", users.get(0).getStr("tel_phone"));
			o.set("address", users.get(0).getStr("address"));
			o.save();
			//下面计算购物车里面的东西
			List<Shopping_cart_detail> scds = Shopping_cart_detail.dao.find("select * from shoppingCartDetail where shopping_cart_id=?",users.get(0).getInt("shopping_cart_id"));
			for(int i=0;i<scds.size();i++){
				Order_detail od = new Order_detail();
				od.set("order_id", o.getInt("id"));
				od.set("food_id", scds.get(i).getInt("food_id"));		
				//查找下food的信息
				List<Food> foods = Food.dao.find("select * from food where id=?",scds.get(i).getInt("food_id"));
				od.set("food_name", foods.get(0).getStr("food_name"));
				od.set("count", scds.get(0).getInt("count"));
				od.set("price", foods.get(0).getDouble("price"));
				od.save();
				sum_price=scds.get(i).getInt("count")*foods.get(0).getDouble("price")+sum_price;
			}
			o.set("sum_price",sum_price);
	        o.update();
	        
			renderJson(o.toJson());
		}else{
			renderJson("{\"status\":false}");
		}	
	}
	
  //查看订单
	

}