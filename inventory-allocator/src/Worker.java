import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * the Worker class
 */
public class Worker {
    /**
     * Create Shipments for the given order from the warehouses
     * @param orders - the order
     * @param warehouseList - the available warehouses
     * @returncd
     */
    public List<Delivery> createShipments(Order orders, List<Warehouse> warehouseList){
        List<Delivery> shipmentList = new ArrayList();

        if(orders == null || orders.isEmpty() || warehouseList.size() == 0 || warehouseList == null){
            return shipmentList;
        }

        for (Warehouse warehouse : warehouseList){
            Delivery delivery = new Delivery(warehouse.getName());
            for (Item item : orders.getOrderedItems()){
                if (warehouse.hasItem(item)){
                    if (warehouse.getItemNums(item) >= orders.getItemNum(item)){
                        delivery.sendDelivery(item, orders.getItemNum(item));
                        warehouse.updateInventory(item, warehouse.getItemNums(item)-orders.getItemNum(item));
                        orders.updateItemNum(item, 0);

                    } else {
                        delivery.sendDelivery(item, warehouse.getItemNums(item));
                        orders.updateItemNum(item, orders.getItemNum(item)-warehouse.getItemNums(item));
                        warehouse.updateInventory(item, warehouse.getItemNums(item));
                    }
                }
            }
            shipmentList.add(delivery);
            }
        return shipmentList;
    }
}
