package wosong.config; 
import wosong.Controller.*;
import wosong.domain.*;

import com.jfinal.config.*; 
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
public class ProjectConfig extends JFinalConfig { 
 
public void configConstant(Constants me) { 
	me.setDevMode(true); 	 
	me.setViewType(ViewType.JSP);
} 
 
public void configRoute(Routes me) { 
 
me.add("/login", LoginController.class,"/client"); 
me.add("/register", RegisterController.class,"/client"); 
me.add("/userManage", UserManageController.class,"/client"); 
me.add("/adminLogin", AdminLoginController.class,"/client"); 
me.add("/adminManage", AdminManageController.class,"/client");
//me.add("/main", MainController.class,"/client"); 
//me.add("/manager", ManagerController.class,"/client"); 
//me.add("/managerMain", ManagerMainController.class,"/client"); 
//me.add("/header", HeaderController.class,"/client"); 
} 
 
public void configPlugin(Plugins me) {
	C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/wosong", 
			"root", "admin"); 
			 me.add(cp); 
			 ActiveRecordPlugin arp = new ActiveRecordPlugin(cp); 
			 me.add(arp); 
			 arp.addMapping("user", "id",User.class); 
			 arp.addMapping("shoppingCart", "id",Shopping_cart.class); 
			 arp.addMapping("shoppingCartDetail", "id",Shopping_cart_detail.class); 
			 arp.addMapping("orders","id",Order.class); 
			 arp.addMapping("orderDetail","id",Order_detail.class); 
			 arp.addMapping("food","id",Food.class);
			 arp.addMapping("admin","id",Admin.class);
			 arp.addMapping("senter","id",Senter.class);
//			 arp.addMapping("paylog", "id",Pay.class); 
//			 arp.addMapping("managerinfo", "managerID",Manager.class); 
//			 arp.addMapping("headerinfo", "headerID",Header.class); 

} 
 
public void configInterceptor(Interceptors me) {} 
 
public void configHandler(Handlers me) {} 
} 