package db.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashMap;
@Table(name="Orders")
public class Order {

    private long menu_id;
    @Column(name = "item_list")
    private HashMap<Long, Integer> item_list; //  Item Id and quantity so if pizza has id 151651163 and one orders 3 of them we get  { 151651163 : 3 }
    private Date order_date;
    private Long picked_up_by; // Courier ID
    private Long customer_id;
    private double total_price;


    public Order() {
    }
}
