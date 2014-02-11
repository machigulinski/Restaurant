package db.accessor;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Machi
 */
public interface IDBAccessor {
    
    public abstract void openDBConnection(String driverClassName, String url, String username, String password)
	    throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    
    public abstract void closeDBConnection() throws SQLException;
	    
    public abstract List findAllRecords(String sqlQuery, boolean closeConnection)
	    throws SQLException, Exception;
    
}
