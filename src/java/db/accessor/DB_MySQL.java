
package db.accessor;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class is an implementation of IDBAccessor Interface
 * and represents module that connects to MySQL Database
 * @author Machi
 */
public class DB_MySQL  implements IDBAccessor {
    
    private Connection connection;
    
    /** no-arg constructor
     * 
     */
    public DB_MySQL() {}
    /**
     * implementation of openDBConnection method 
     */
    @Override
    public void openDBConnection(String driverClassName, String url, String username, String password) 
	    throws IllegalArgumentException, ClassNotFoundException, SQLException	
    {
	String msg = "Error: url is null or zero length!";
	
	if( url == null || url.length() == 0 ) throw new IllegalArgumentException(msg);
	username = (username == null) ? "" : username;
	password = (password == null) ? "" : password;
	Class.forName (driverClassName);
	connection = DriverManager.getConnection(url, username, password);
	}

    @Override
    public void closeDBConnection() throws SQLException {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAllRecords(String sqlQuery, boolean closeConnection) 
	    throws SQLException, Exception {
	
	Statement stmt = null;
	ResultSet rs = null;
	ResultSetMetaData metaData = null;
	final List recordList = new ArrayList();
	Map record = null;
	
	try {
	    stmt = connection.createStatement();
	    rs = stmt.executeQuery(sqlQuery);
	    metaData = rs.getMetaData();
	    final int fieldCount = metaData.getColumnCount();
	    
	    while(rs.next()) {
		record = new LinkedHashMap();
		
		for (int i = 1; i <= fieldCount; i++) {
		    try {
			record.put( metaData.getColumnName(i), rs.getObject(i) );
			} catch(NullPointerException npe) { 
			}
		  } 	
		  recordList.add(record);
	    }	    
	
	} catch (SQLException sqle) {
			throw sqle;
		
	} finally {
		try {
		    stmt.close();
		    if(closeConnection) connection.close();
		} catch(SQLException e) {
		    throw e;
		} 
	} // end finally
	
	return recordList;	
    }	

    @Override
    public int deleteRecord(String tableName, String whereField, Object whereValue, boolean closeConnection) 
	    throws SQLException, Exception {
	
	PreparedStatement deleteStmt = null;		
	int recsDeleted = 0;
	
	try {			
	    deleteStmt = buildDeleteStatement(connection, tableName, whereField);
	    
//	    if(whereValue instanceof Integer ){
//		deleteStmt.setInt( 1,((Integer)whereValue).intValue() );
//	    }
	    
	    if(whereValue instanceof String ){
		deleteStmt.setString( 1,((String)whereValue ));
	    }
	    
	    deleteStmt.executeUpdate();

		
	} catch (SQLException sqle) {
			throw sqle;	
	} finally {			
	    try {				
		deleteStmt.close();				
		if(closeConnection) connection.close();
			
	    } catch(SQLException e) {
		throw e;
	    } 		
	} // end finally
		
	return recsDeleted;	    
    }
    

    private PreparedStatement buildDeleteStatement
	(Connection connection, String tableName, String whereField) throws SQLException 
	{
	    final StringBuffer str = new StringBuffer("DELETE FROM ");
	    str.append(tableName);
	    str.append(" WHERE ").append(whereField).append(" = ?");

	    final String deleteStmt = str.toString();
	    return connection.prepareStatement(deleteStmt);
	}
	
	
	   public static void main(String[] args) {
	       
	    final String DRV_ClASS_NAME = "com.mysql.jdbc.Driver";
	    final String LOCAL_URL = "jdbc:mysql://localhost:3306/restaurant";
	    final String USER = "admin";
	    final String PASSWORD = "Gul@db13";
	    try {
		IDBAccessor db = new DB_MySQL();

		db.openDBConnection(
		    DRV_ClASS_NAME,
		    LOCAL_URL,
		    USER, PASSWORD);

		db.deleteRecord("menu_item", "item_name", "garden salad", true);
	    } catch (Exception ex) {
		Logger.getLogger(DB_MySQL.class.getName()).log(Level.SEVERE, null, ex);
	    }

    }
}
