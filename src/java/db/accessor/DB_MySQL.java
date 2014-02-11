
package db.accessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Machi
 */
public class DB_MySQL  implements IDBAccessor {
    
    private Connection connection;
    // no-arg constructor
    public DB_MySQL() {}
    
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
		
		for (int i = 1; i < fieldCount; i++) {
		    try {
			record.put( metaData.getColumnName(i), rs.getObject(i) );
			} catch(NullPointerException npe) { 
			    // no need to do anything... if it fails, just ignore it and continue
			}
		  } 	
		  recordList.add(record);
	    }	    
	
	} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
	} finally {
		try {
		    stmt.close();
		    if(closeConnection) connection.close();
		    } catch(SQLException e) {
			    throw e;
		} // end try
	} // end finally
	
	return recordList;
	
    }
	
}
