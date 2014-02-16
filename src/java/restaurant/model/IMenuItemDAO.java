package restaurant.model;

import java.util.List;

/**
 *
 * @author Machi
 */
interface IMenuItemDAO {
    
    public abstract void openDBConnection() throws  Exception;
    
    public abstract List getAllMenuItems() throws Exception;
    
}
