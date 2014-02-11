
package restaurant.model;

import db.accessor.IDBAccessor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Machi
 */
public class MenuItemDAO implements IMenuItemDAO{
    
    private IDBAccessor db;
    final String DRV_ClASS_NAME = "com.mysql.jdbc.Driver";
    final String LOCAL_URL = "jdbc:mysql://localhost:3306/restaurant";
    final String USER = "admin";
    final String PASSWORD = "Gul@db13";

    final String SELECT_ALL_QUERY = "SELECT * FROM menu_item";
    
    /**
     * no-arg constructor
     */
    public MenuItemDAO(){}
    
    /**
     * convenience constructor; automatically sets db accessor
     * @param db
     */
    public MenuItemDAO(IDBAccessor db){
	this.db = db;    
    }
	    
    
    public void openMySQLConnection() throws  Exception {
	try {
            // Each time you perform a new query you must re-open the connection
            db.openDBConnection(
		DRV_ClASS_NAME,
		LOCAL_URL,
                USER, PASSWORD);
	
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }
    
    // method gets all the items from menu_item table
    public List<MenuItem> getAllMenuItems() throws Exception {
	this.openMySQLConnection();
	
	List<LinkedHashMap> rawData = new ArrayList<>();
	List<MenuItem> menuRecords = new ArrayList<>();

	   	
    //rawData = db.findAllRecords(SELECT_ALL_QUERY, true);
    
    MenuItem item = null;

	for (LinkedHashMap m : rawData) {
	item = new MenuItem();

	String id = m.get("item_id").toString();
	item.setItemId(new Integer(id));

	String name = m.get("item_name").toString();
	item.setItemName(name);

	String description = m.get("item_info").toString();
	item.setItemInfo(description);

	//		String price = m.get("item_price").toString();
	//		item.setItemPrice(new Double(price));		    


	menuRecords.add(item);

	}
		
    return menuRecords;
    }
       
    public static void main(String[] args) {
	
	MenuItemDAO menu = new MenuItemDAO();
	try {
	   	    
	    for (MenuItem m:  menu.getAllMenuItems() ){
		System.out.println(m.toString());
	    }
	} catch (Exception ex) {
	    Logger.getLogger(MenuItemDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
    
    }
}
