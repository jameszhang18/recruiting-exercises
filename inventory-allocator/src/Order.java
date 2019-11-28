import java.util.HashMap;
import java.util.Set;

/**
 * The Order class
 */
public class Order {
    HashMap<Item, Integer> orderDetails;

    public Order(){
        this.orderDetails = new HashMap<Item, Integer>();
    }

    /**
     * Return all the items in the order
     * @return set of items
     */
    public Set<Item> getOrderedItems(){
        return this.orderDetails.keySet();
    }

    /**
     * Return the number of the given item in the order
     * @param item - the item being checked
     * @return int - the number of the items
     */
    public Integer getItemNum(Item item){
        return this.orderDetails.get(item);
    }

    /**
     * Check if the order has no items
     * @return boolean - if the order has no items
     */
    public boolean isEmpty(){
        return this.orderDetails.size() == 0;
    }

    /**
     * Uodate the items in the order
     * @param item - the item being updated
     * @param num - the number of the item
     */
    public void updateItemNum(Item item, Integer num){
            this.orderDetails.put(item, num);

    }
}
