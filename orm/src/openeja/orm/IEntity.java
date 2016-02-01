package openeja.orm;

public interface IEntity {	
	
	public void load();
	public void findById(String id);
	public void add();
	public void remove();
	public void update();	
	
}
