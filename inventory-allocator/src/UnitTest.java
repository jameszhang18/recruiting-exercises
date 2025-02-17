import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;
public class UnitTest {

    private Item apple = new Item("apple");
    private Item mango = new Item("mango");
    private Worker worker = new Worker();
    private Order orders = new Order();
    private List finalShipment = new ArrayList();
    private List inputList;
    private String expectedOutput;

    private List<Warehouse> warehouseList = new ArrayList();
    private Map<Item, Integer> firstInventory = new HashMap<>();
    private Map<Item, Integer> secondInventory = new HashMap<>();
    private Map<Item, Integer> thirdInventory = new HashMap<>();


    @Test
    public void createShipmentsWithNoInput() {

        inputList = worker.createShipments(orders, warehouseList);
        Assert.assertEquals(finalShipment, inputList);

    }

    @Test
    public void shipmentsWithOneInventory() {

        orders.updateItemNum(apple, 10);
        orders.updateItemNum(mango, 10);

        firstInventory.put(apple, 10);
        firstInventory.put(mango, 10);

        Warehouse warehouse1 = new Warehouse("xyz", firstInventory);

        warehouseList.add(warehouse1);

        inputList = worker.createShipments(orders, warehouseList);

        expectedOutput = "[{xyz: {apple=10, mango=10}}]";

        Assert.assertEquals(expectedOutput, inputList.toString());
    }

    @Test
    public void shipmentsWithDistributedInventory() {

        orders.updateItemNum(apple, 5);
        orders.updateItemNum(mango, 5);

        firstInventory.put(apple, 3);
        firstInventory.put(mango, 2);

        secondInventory.put(apple, 1);
        secondInventory.put(mango, 2);

        thirdInventory.put(apple, 2);
        thirdInventory.put(mango, 2);


        Warehouse warehouse1 = new Warehouse("xyz", firstInventory);
        Warehouse warehouse2 = new Warehouse("abc", secondInventory);
        Warehouse warehouse3 = new Warehouse("owd", thirdInventory);

        warehouseList.add(warehouse1);
        warehouseList.add(warehouse2);
        warehouseList.add(warehouse3);

        finalShipment = worker.createShipments(orders, warehouseList);

        expectedOutput = "[{xyz: {apple=3, mango=2}}, {abc: {apple=1, mango=2}}, {owd: {apple=1, mango=1}}]";

        Assert.assertEquals(expectedOutput, finalShipment.toString());

    }

    @Test
    public void shipmentsWithEmptyWarehouseList() {

        orders.updateItemNum(apple, 10);
        orders.updateItemNum(mango, 10);

        inputList = worker.createShipments(orders, warehouseList);

        Assert.assertEquals(finalShipment, inputList);

    }

    @Test
    public void shipmentsWithEmptyOrders() {

        firstInventory.put(apple, 10);
        secondInventory.put(mango, 10);

        Warehouse warehouse1 = new Warehouse("xyz", firstInventory);
        Warehouse warehouse2 = new Warehouse("abc", secondInventory);

        warehouseList.add(warehouse1);
        warehouseList.add(warehouse2);

        inputList = worker.createShipments(orders, warehouseList);

        Assert.assertEquals(finalShipment, inputList);

    }
}

