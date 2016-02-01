package openeja.dal;


import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

public interface IDBAdapter {
	
	public void connect(String connectionString, String username, String password);
	public ResultSet retrieve(String table, HashMap<?, ?> whereCondition, List<String> columns, String order, int offset, int limit );
	public ResultSet retrieve(String table, HashMap<?, ?> whereCondition);	
	public void insert(String table, HashMap<?, ?> newData);
	public void update(String table, HashMap<?,?> modifiedData, HashMap<?, ?> whereCondition );
	public void delete(String table, HashMap<?, ?> whereCondition);	
}
