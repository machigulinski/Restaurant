package restaurant.model;

/**
 *
 * @author Machi
 */
public class MenuItem {
    
    private int itemId;
    private String itemName;
    private String itemInfo;
    private double itemPrice;
    
    public MenuItem() {}

    public int getItemId() {
	return itemId;
    }

    public void setItemId(int itemId) {
	this.itemId = itemId;
    }

    public String getItemName() {
	return itemName;
    }

    public void setItemName(String itemName) {
	this.itemName = itemName;
    }

    public String getItemInfo() {
	return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
	this.itemInfo = itemInfo;
    }

    public double getItemPrice() {
	return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
    }
    
    
}
