package openeja.dal;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class DBAdapter implements IDBAdapter {

	protected Connection myConn;
	protected Statement myStmt;

	@Override
	public void connect(String connectionString, String username, String password) {
		try {

			myConn = DriverManager.getConnection(connectionString, username, password);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void insert(String table, HashMap<?, ?> newData) {
		try {
			StringBuffer fieldNames = new StringBuffer();
			StringBuffer fieldValues = new StringBuffer();
			Iterator<?> iterator = newData.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) iterator.next();
				fieldNames.append(entry.getKey());
				fieldValues.append("'").append(entry.getValue()).append("'");
				if (iterator.hasNext()) {
					fieldNames.append(",");
					fieldValues.append(",");
				}
			}
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(table).append("( ").append(fieldNames.toString()).append(" )");
			sql.append("VALUES (").append(fieldValues.toString()).append(" )");
			System.out.println(sql.toString());
			myStmt = myConn.createStatement();

			myStmt.executeUpdate(sql.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void update(String table, HashMap<?, ?> modifiedData, HashMap<?, ?> whereCondition) {
		try {
			StringBuffer fieldDetails = new StringBuffer();
			Iterator<?> dataIterator = modifiedData.entrySet().iterator();
			while (dataIterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) dataIterator.next();
				fieldDetails.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");

				if (dataIterator.hasNext()) {
					fieldDetails.append(",");

				}
			}
			StringBuffer whereDetails = new StringBuffer();
			Iterator<?> whereIterator = whereCondition.entrySet().iterator();
			while (whereIterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) whereIterator.next();
				whereDetails.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");

				if (whereIterator.hasNext()) {
					whereDetails.append(",");

				}
			}
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE ").append(table).append(" SET ").append(fieldDetails.toString());
			sql.append(" WHERE ").append(whereDetails.toString());

			System.out.println(sql.toString());
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void delete(String table, HashMap<?, ?> whereCondition) {
		try {

			StringBuffer whereDetails = new StringBuffer();
			Iterator<?> whereIterator = whereCondition.entrySet().iterator();
			while (whereIterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) whereIterator.next();
				whereDetails.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");

				if (whereIterator.hasNext()) {
					whereDetails.append(",");

				}
			}
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(table);
			sql.append(" WHERE ").append(whereDetails.toString());

			System.out.println(sql.toString());
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public ResultSet retrieve(String table, HashMap<?, ?> whereCondition, List<String> columns, String order,
			int offset, int limit) {
		try {
			StringBuffer whereDetails = new StringBuffer();
			Iterator<?> whereIterator = whereCondition.entrySet().iterator();
			while (whereIterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) whereIterator.next();
				whereDetails.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");

				if (whereIterator.hasNext()) {
					whereDetails.append(",");

				}
			}
			StringBuffer columnDetails = new StringBuffer();
			Iterator<String> columnIterator = columns.iterator();
			while (columnIterator.hasNext()) {
				columnDetails.append(columnIterator.next().toString());
				if (columnIterator.hasNext()) {
					columnDetails.append(",");
				}
			}
			StringBuilder sql = new StringBuilder();
			String fields = columnDetails.toString();
			if (fields.trim().equals(""))
				sql.append("SELECT ").append("*").append(" FROM ").append(table);
			else
				sql.append("SELECT ").append(fields).append(" FROM ").append(table);
			if (whereDetails.toString() != "")
				sql.append(" WHERE ").append(whereDetails.toString());
			if (!order.trim().equals(""))
				sql.append(" ORDER BY ").append(order);
			if (limit > 0)
				sql.append(" LIMIT ").append(limit);
			if (offset > 0)
				sql.append(" OFFSET ").append(offset);

			myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql.toString());
			return myRs;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ResultSet retrieve(String table, HashMap<?, ?> whereCondition) {
		try {
			StringBuffer whereDetails = new StringBuffer();
			Iterator<?> whereIterator = whereCondition.entrySet().iterator();
			while (whereIterator.hasNext()) {
				Entry<?, ?> entry = (Entry<?, ?>) whereIterator.next();
				whereDetails.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'");

				if (whereIterator.hasNext()) {
					whereDetails.append(",");

				}
			}

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ").append("*").append(" FROM ").append(table);
			if (whereDetails.toString() != "")
				sql.append(" WHERE ").append(whereDetails.toString());
			myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql.toString());
			return myRs;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public ResultSet tableDetail(String tableName, String databaseName) {

		StringBuilder sql = new StringBuilder();
		// select column_name, column_default, is_nullable,
		// data_type,character_maximum_length, column_key, extra from
		// information_schema.columns where table_name='test' and
		// table_schema='javadb';
		sql.append(
				"SELECT column_name, column_default, is_nullable, data_type,character_maximum_length, column_key, extra from information_schema.columns ");
		sql.append(" WHERE table_name='").append(tableName).append("' AND table_schema='").append(databaseName)
				.append("'");

		try {
			System.out.println(sql.toString());
			myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql.toString());
			return myRs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	public ResultSet referencedTableDetail(String tableName, String databaseName) {

		StringBuilder sql = new StringBuilder();
		/*SELECT table_name, column_name, referenced_table_name, referenced_column_name
		FROM information_schema.key_column_usage
		WHERE table_name =  'employees'
		AND table_schema =  'javadb'
		AND referenced_table_name IS NOT NULL 
		LIMIT 0 , 30*/
		sql.append(
				"SELECT table_name, column_name, referenced_table_name, referenced_column_name FROM information_schema.key_column_usage ");
		sql.append(" WHERE table_name='").append(tableName).append("' AND table_schema='").append(databaseName)
				.append("'");
		sql.append(" AND referenced_table_name IS NOT NULL ");

		try {
			System.out.println(sql.toString());
			myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql.toString());
			return myRs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ResultSet listTables(String databaseName) {

		StringBuilder sql = new StringBuilder();
		sql.append("select distinct(table_name) from information_schema.columns");
		sql.append(" where table_schema='").append(databaseName).append("'");

		try {
			myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql.toString());
			return myRs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
