package wosong.Controller; 


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import wosong.domain.Admin;
import wosong.domain.Food;
import wosong.domain.Order;
import wosong.domain.Order_detail;
import wosong.domain.Senter;
import wosong.domain.User;

import com.jfinal.core.Controller; 
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
public class AdminManageController extends Controller { 
 
public void index() { 
} 

//退出登录
public void quitLogin(){
	this.getSession().setAttribute("admin_name",null);	
	this.getSession().setAttribute("school",null);
	render("login/login.html");
}

//默认显示未发货的订单
public void orderManage(){
	String  order_type="unsentOrders";
	if(this.getSession().getAttribute("admin_name")==null){
		//System.out.println(this.getSession().getAttribute("admin_name"));
		render("login/login.html");
	}else{
	String school=this.getSession().getAttribute("school")+"";
	//得到所有的order信息,并显示出来

	List<Order> orders = Order.dao.find("select * from orders where school=? and if_sent='false' and if_cancel='false'",school);
	List<Senter> senters = Senter.dao.find("select * from senter where school=?",school);
	List<Order_detail> order_details = Order_detail.dao.find("select * from orderDetail");
	setAttr("orders", orders);
	setAttr("senters", senters);
	setAttr("order_type", order_type);
	setAttr("order_details", order_details);
	renderJsp("admin/orderManage.jsp");
	}
}

//未付款的订单
public void unpayOrdersManage(){
	String  order_type="unpayOrders";
	if(this.getSession().getAttribute("admin_name")==null){
		//System.out.println(this.getSession().getAttribute("admin_name"));
		render("login/login.html");
	}else{
	String school=this.getSession().getAttribute("school")+"";
	//得到所有的order信息,并显示出来

	List<Order> orders = Order.dao.find("select * from orders where school=? and if_pay='false' and if_cancel='false'",school);
	List<Order_detail> order_details = Order_detail.dao.find("select * from orderDetail");
	setAttr("orders", orders);
	setAttr("order_type", order_type);
	setAttr("order_details", order_details);
	renderJsp("admin/orderManage.jsp");
	}
}

public void endedOrdersManage(){
	String  order_type="endedOrders";
	if(this.getSession().getAttribute("admin_name")==null){
		//System.out.println(this.getSession().getAttribute("admin_name"));
		render("login/login.html");
	}else{
	String school=this.getSession().getAttribute("school")+"";
	//得到所有的order信息,并显示出来

	List<Order> orders = Order.dao.find("select * from orders where school=? and if_pay='true' and if_sent='true'",school);
	List<Order_detail> order_details = Order_detail.dao.find("select * from orderDetail");
	setAttr("orders", orders);
	setAttr("order_type", order_type);
	setAttr("order_details", order_details);
	renderJsp("admin/orderManage.jsp");
}
}

//所有订单
public void allOrdersManage(){
	String  order_type="allOrders";
	if(this.getSession().getAttribute("admin_name")==null){
		//System.out.println(this.getSession().getAttribute("admin_name"));
		render("login/login.html");
	}else{
	String school=this.getSession().getAttribute("school")+"";
	//得到所有的order信息,并显示出来

	List<Order> orders = Order.dao.find("select * from orders where school=?",school);
	List<Order_detail> order_details = Order_detail.dao.find("select * from orderDetail");
	setAttr("orders", orders);
	setAttr("order_type", order_type);
	setAttr("order_details", order_details);
	renderJsp("admin/orderManage.jsp");
	}
}




//默认显示所有上架的商品列表
public void shelfedProductsManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
		
	List<Food> foods = Food.dao.find("select * from food where if_shelf='true'");
		
	    
		//做分页
		String pageSize=getPara("pageSize");
		String pageidx=getPara("pageidx");
		String pageCount=(int)Math.ceil(foods.size()/Double.valueOf(pageSize))+"";
		List<Food> showFoods=new ArrayList<Food>();
		for(int i=0;i<Integer.valueOf(pageSize);i++){
			int trueNum=i+(Integer.valueOf(pageidx)-1)*Integer.valueOf(pageSize);
			if(trueNum<foods.size()){
				showFoods.add(foods.get(trueNum));
		     }
		}

	setAttr("foods", showFoods);
	setAttr("pageCount", pageCount);
	setAttr("pageidx", pageidx);
	setAttr("products_type", "shelfedProducts");
	renderJsp("admin/productManage.jsp");
	}
}


public void allProductsManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	List<Food> foods = Food.dao.find("select * from food");
	
	//做分页
	String pageSize=getPara("pageSize");
	if(pageSize==null){
		pageSize=10+"";	
	}
	String pageidx=getPara("pageidx");
	if(pageidx==null){
		pageidx=1+"";	
	}
	String pageCount=(int)Math.ceil(foods.size()/Double.valueOf(pageSize))+"";
	List<Food> showFoods=new ArrayList<Food>();
	for(int i=0;i<Integer.valueOf(pageSize);i++){
		int trueNum=i+(Integer.valueOf(pageidx)-1)*Integer.valueOf(pageSize);
		if(trueNum<foods.size()){
			showFoods.add(foods.get(trueNum));
	     }
	}

	setAttr("foods", showFoods);
	setAttr("pageCount", pageCount);
	setAttr("pageidx", pageidx);
	setAttr("products_type", "allProducts");
	renderJsp("admin/productManage.jsp");
	}
}
//未上架商品
public void unShelfedProductsManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	List<Food> foods = Food.dao.find("select * from food where if_shelf='false'");
	
	//做分页
	String pageSize=getPara("pageSize");
	String pageidx=getPara("pageidx");
	String pageCount=(int)Math.ceil(foods.size()/Double.valueOf(pageSize))+"";
	List<Food> showFoods=new ArrayList<Food>();
	for(int i=0;i<Integer.valueOf(pageSize);i++){
		int trueNum=i+(Integer.valueOf(pageidx)-1)*Integer.valueOf(pageSize);
		if(trueNum<foods.size()){
			showFoods.add(foods.get(trueNum));
	     }
	}

	setAttr("foods", showFoods);
	setAttr("pageCount", pageCount);
	setAttr("pageidx", pageidx);
	setAttr("products_type", "unShelfedProducts");
	renderJsp("admin/productManage.jsp");
	}
}
//推荐商品
public void recommendProductsManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	List<Food> foods = Food.dao.find("select * from food where if_recommend='true' and if_shelf='true'");
	
	//做分页
	String pageSize=getPara("pageSize");
	String pageidx=getPara("pageidx");
	String pageCount=(int)Math.ceil(foods.size()/Double.valueOf(pageSize))+"";
	List<Food> showFoods=new ArrayList<Food>();
	for(int i=0;i<Integer.valueOf(pageSize);i++){
		int trueNum=i+(Integer.valueOf(pageidx)-1)*Integer.valueOf(pageSize);
		if(trueNum<foods.size()){
			showFoods.add(foods.get(trueNum));
	     }
	}

	setAttr("foods", showFoods);
	setAttr("pageCount", pageCount);
	setAttr("pageidx", pageidx);
	setAttr("products_type", "recommendProducts");
	renderJsp("admin/productManage.jsp");
	}
}


//根据信息查找商品
public void findProcucts(){
	String find_type=getPara("find_type");
	String products_type=getPara("products_type");
	String detail=getPara("detail");
	List<Food> foods = null;
	if(products_type.equals("shelfedProducts")){
		if(find_type.equals("食物名")){
			foods = Food.dao.find("select * from food where if_shelf='true' and food_name like '%"+detail+"%'");
		}else if(find_type.equals("详细信息")){
			foods = Food.dao.find("select * from food where if_shelf='true' and food_detail like '%"+detail+"%'");
		}else if(find_type.equals("学校")){
			foods = Food.dao.find("select * from food where if_shelf='true' and school like '%"+detail+"%'");
		}else if(find_type.equals("价格")){
			foods = Food.dao.find("select * from food where if_shelf='true' and price like '%"+detail+"%'");
		}else if(find_type.equals("商店名称")){
			foods = Food.dao.find("select * from food where if_shelf='true' and shop_name like '%"+detail+"%'");
		}
	}else if(products_type.equals("unShelfedProducts")){
		if(find_type.equals("食物名")){
			foods = Food.dao.find("select * from food where if_shelf='false' and food_name like '%"+detail+"%'");
		}else if(find_type.equals("详细信息")){
			foods = Food.dao.find("select * from food where if_shelf='false' and food_detail like '%"+detail+"%'");
		}else if(find_type.equals("学校")){
			foods = Food.dao.find("select * from food where if_shelf='false' and school like '%"+detail+"%'");
		}else if(find_type.equals("价格")){
			foods = Food.dao.find("select * from food where if_shelf='false' and price like '%"+detail+"%'");
		}else if(find_type.equals("商店名称")){
			foods = Food.dao.find("select * from food where if_shelf='false' and shop_name like '%"+detail+"%'");
		}
	}else if(products_type.equals("allProducts")){
		if(find_type.equals("食物名")){
			foods = Food.dao.find("select * from food where  food_name like '%"+detail+"%'");
		}else if(find_type.equals("详细信息")){
			foods = Food.dao.find("select * from food where  food_detail like '%"+detail+"%'");
		}else if(find_type.equals("学校")){
			foods = Food.dao.find("select * from food where  school like '%"+detail+"%'");
		}else if(find_type.equals("价格")){
			foods = Food.dao.find("select * from food where  price like '%"+detail+"%'");
		}else if(find_type.equals("商店名称")){
			foods = Food.dao.find("select * from food where  shop_name like '%"+detail+"%'");
		}
	}else if(products_type.equals("recommendProducts")){
		if(find_type.equals("食物名")){
			foods = Food.dao.find("select * from food where  if_recommend='true' and food_name like '%"+detail+"%'");
		}else if(find_type.equals("详细信息")){
			foods = Food.dao.find("select * from food where  if_recommend='true' and food_detail like '%"+detail+"%'");
		}else if(find_type.equals("学校")){
			foods = Food.dao.find("select * from food where  if_recommend='true' and school like '%"+detail+"%'");
		}else if(find_type.equals("价格")){
			foods = Food.dao.find("select * from food where  if_recommend='true' and price like '%"+detail+"%'");
		}else if(find_type.equals("商店名称")){
			foods = Food.dao.find("select * from food where  if_recommend='true' shop_name like '%"+detail+"%'");
		}
	}
	
	//做分页
		String pageSize=getPara("pageSize");
		String pageidx=getPara("pageidx");
		String pageCount=(int)Math.ceil(foods.size()/Double.valueOf(pageSize))+"";
		List<Food> showFoods=new ArrayList<Food>();
		for(int i=0;i<Integer.valueOf(pageSize);i++){
			int trueNum=i+(Integer.valueOf(pageidx)-1)*Integer.valueOf(pageSize);
			if(trueNum<foods.size()){
				showFoods.add(foods.get(trueNum));
		     }
		}

		setAttr("foods", showFoods);
		setAttr("pageCount", pageCount);
		setAttr("pageidx", pageidx);
	setAttr("products_type", products_type);
	renderJsp("admin/productManage.jsp");
}

//添加商品
public void addProductsManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	renderJsp("admin/addProductManage.jsp");
	}
}

//修改food
public void changeFood(){
	List<Food> foods = Food.dao.find("select * from food where id=?",getPara("foodId"));
	setAttr("food", foods.get(0));
	renderJsp("admin/changeProductManage.jsp");
}

//用户管理
public void userManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	List<User> users = User.dao.find("select * from user");
	setAttr("users", users);
	renderJsp("admin/userManage.jsp");
	}
}

//配送员管理
public void senterManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	List<Senter> senters = Senter.dao.find("select * from senter");
	setAttr("senters", senters);
	renderJsp("admin/senterManage.jsp");
	}
}

//管理员管理管理
public void adminManage(){
	if(this.getSession().getAttribute("admin_name")==null){
		render("login/login.html");
	}else{
	List<Admin> admins = Admin.dao.find("select * from admin");
	setAttr("admins", admins);
	renderJsp("admin/adminManage.jsp");
	}
}


/////以下部分为ajax请求
///order部分
//设置senter
public void setSenter(){
	List<Order> orders = Order.dao.find("select * from orders where id=?",getPara("orderId"));
	List<Senter> senters = Senter.dao.find("select * from senter where id=?",getPara("senterId"));
	orders.get(0).set("senter_id", getPara("senterId"));
	orders.get(0).set("if_sent","true");
	orders.get(0).set("senter_name", senters.get(0).get("senter_name"));
	orders.get(0).update();
	renderJson("{\"status\":true}");
}

//取消订单
public void cancelOrder(){
	List<Order> orders = Order.dao.find("select * from orders where id=?",getPara("orderId"));
	orders.get(0).set("if_cancel","true");
	orders.get(0).update();
	renderJson("{\"status\":true}");
}
///商品部分
//上架商品
public void shelfFood(){
	List<Food> foods = Food.dao.find("select * from food where id=?",getPara("foodId"));
	foods.get(0).set("if_shelf","true");
	foods.get(0).update();
	renderJson("{\"status\":true}");
}
//下架商品
public void unshelfFood(){
	List<Food> foods = Food.dao.find("select * from food where id=?",getPara("foodId"));
	foods.get(0).set("if_shelf","false");
	foods.get(0).update();
	renderJson("{\"status\":true}");
}
//下架商品
public void recommendFood(){
	List<Food> foods = Food.dao.find("select * from food where id=?",getPara("foodId"));
	if(foods.size()<8){
		foods.get(0).set("if_recommend","true");
		foods.get(0).update();
		renderJson("{\"status\":true}");
	}else{
		renderJson("{\"status\":false}");
	}
	

}
//下架商品
public void unrecommendFood(){
	List<Food> foods = Food.dao.find("select * from food where id=?",getPara("foodId"));
	foods.get(0).set("if_recommend","false");
	foods.get(0).update();
	renderJson("{\"status\":true}");
}


//添加商品
public void addProduct(){	
	String path_tmp = "";
  String uploadDir = File.separator + "upload" + File.separator + "contract" + File.separator;
  path_tmp = PathKit.getWebRootPath() + uploadDir;
  String real_name="";
  UploadFile uploadFile = getFile("file", path_tmp);
  if(uploadFile!=null){
      File f = uploadFile.getFile();
      real_name=System.currentTimeMillis()+".jpg";
      f.renameTo(new File(path_tmp+real_name));
  }
  
//设置一下存入数据库的文件名
  String food_img=path_tmp+real_name;
  String food_name=getPara("food_name");
  String food_detail=getPara("food_detail");
  String school=getPara("school");
  String price=getPara("price");
  String shop_name=getPara("shop_name");
  Food food = new Food();
  food.set("food_name", food_name);
  food.set("food_detail", food_detail);
  food.set("food_img", food_img);
  food.set("school", school);
  food.set("price", price);
  food.set("shop_name", shop_name);

  food.save();
  allProductsManage();
}
//修改商品
public void changeProduct(){
	String path_tmp = "";
  String uploadDir = File.separator + "upload" + File.separator + "contract" + File.separator;
  path_tmp = PathKit.getWebRootPath() + uploadDir;
  String real_name="";
  UploadFile uploadFile = getFile("file", path_tmp);
  if(uploadFile!=null){
      File f = uploadFile.getFile();
      real_name=System.currentTimeMillis()+".jpg";
      f.renameTo(new File(path_tmp+real_name));
  }

  
//设置一下存入数据库的文件名
  String food_img=path_tmp+real_name;
  
  String food_name=getPara("food_name");
  String food_detail=getPara("food_detail");
  String school=getPara("school");
  String price=getPara("price");
  String shop_name=getPara("shop_name");
  List<Food> foods = Food.dao.find("select * from food where id=?",getPara("food_id"));
  foods.get(0).set("food_name", food_name);
  foods.get(0).set("food_detail", food_detail);
  foods.get(0).set("food_img", food_img);
  foods.get(0).set("school", school);
  foods.get(0).set("price", price);
  foods.get(0).set("shop_name", shop_name);

  foods.get(0).update();
  //renderJson("{\"status\":true}");
  allProductsManage();
}

}