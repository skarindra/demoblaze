package demoblaze.object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sekarayukarindra.
 */
public class StoreOrderDetails {

    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsList.add(orderDetails);
    }
}
