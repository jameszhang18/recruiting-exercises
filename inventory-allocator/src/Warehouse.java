import java.util.Map;
import java.util.Set;

/**
 * The Warehouse class
 */
public class Warehouse {
    String name;
    Map<Item, Integer> inventoryDistribution;

    public Warehouse(String name, Map<Item, Integer> inventoryDistribution){
        this.name = name;
        this.inventoryDistribution = inventoryDistribution;
    }

    /**
     * Return the name of the warehouse
     * @return string - name of the warehouse
     */
    public String getName(){
        return this.name;
    }

    /**
     * Return if the warehouse has the given item
     * @param item - the item being checked
     * @return boolean - if the warehouse has the item
     */
    public boolean hasItem(Item item){
        return this.inventoryDistribution.containsKey(item);
    }

    /**
     * Return the number of the items in the warehouse
     * @param item - the item being checked
     * @return int - the number of that item
     */
    public Integer getItemNums(Item item){
        return this.inventoryDistribution.get(item);
    }

    /**
     * Update the inventory for the given item in the warehouse
     * @param item - the item being updated
     * @param num - the updated number of items
     */
    public void updateInventory(Item item, Integer num){
        if (num == 0){
            this.inventoryDistribution.remove(item);
        } else{
            this.inventoryDistribution.put(item, num);
        }

    }

}
