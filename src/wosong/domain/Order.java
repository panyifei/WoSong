package wosong.domain;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class Order extends Model<Order>{
	public static Order dao=new Order();
    public List<Order_detail> order_details;
	
}
