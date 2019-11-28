import java.util.HashMap;
import java.util.Map;

/**
 * The Delivery class
 */
public class Delivery {
    String warehouseName;
    Map<String, Integer> shipmentDetails;

    public Delivery(String warehouseName){
        this.warehouseName = warehouseName;
        this.shipmentDetails = new HashMap<String, Integer>();
    }

    @Override
    public String toString() {
        return "{" +
                "" + this.warehouseName +
                ": " + this. shipmentDetails +
                '}';
    }


    public void sendDelivery(Item item, Integer itemNum) {
        this.shipmentDetails.put(item.itemName, itemNum);
    }
}
