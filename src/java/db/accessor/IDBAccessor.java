package db.accessor;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for database 
 * @author Machi
 */
public interface IDBAccessor {
    /**
     * method opens database connection
     * @param driverClassName
     * @param url
     * @param username
     * @param password
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public abstract void openDBConnection(String driverClassName, String url, 
	    String username, String password)
	    throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    
    public abstract void closeDBConnection() throws SQLException;
	    
    public abstract List findAllRecords(String sqlQuery, boolean closeConnection)
	    throws SQLException, Exception;
    
    public abstract int deleteRecord(String tableName, String whereField, Object whereValue, boolean closeConnection)
	throws SQLException, Exception;
    
}
