package restaurant.model;

import db.accessor.DB_MySQL;
import db.accessor.IDBAccessor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Machi
 */
public class RestaurantService {
    private final IMenuItemDAO menuDAO;
    
    public RestaurantService() {    
	IDBAccessor db = new DB_MySQL();
	menuDAO = new MenuItemDAO(db);
    }
	
	
    public List<MenuItem> getAllMenuItems() throws Exception {	    
	    return menuDAO.getAllMenuItems();	
    }   
    
	
//	
//    public static void main (String[] args) {
//	
//	RestaurantService resSvce = new RestaurantService();
//	try {
//	    for(MenuItem mi: resSvce.getAllMenuItems()) {		
//		System.out.println(mi.toString());		
//		
//	    }
//	} catch (Exception ex) {
//	    Logger.getLogger(RestaurantService.class.getName()).log(Level.SEVERE, null, ex);
//	}
//    
//    
//    }
}

