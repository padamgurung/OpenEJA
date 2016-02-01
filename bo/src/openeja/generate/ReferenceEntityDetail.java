package openeja.generate;

public class ReferenceEntityDetail {

	private String tableName;
	private String columnName;
	private String referencedTableName;
	private String referencedColumnName;
	
	public ReferenceEntityDetail(){
		this.tableName = "";
		this.columnName = "";
		this.referencedTableName = "";
		this.referencedColumnName = "";
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getReferencedTableName() {
		return referencedTableName;
	}

	public void setReferencedTableName(String referencedTableName) {
		this.referencedTableName = referencedTableName;
	}

	public String getReferencedColumnName() {
		return referencedColumnName;
	}

	public void setReferencedColumnName(String referencedColumnName) {
		this.referencedColumnName = referencedColumnName;
	}
	
}
