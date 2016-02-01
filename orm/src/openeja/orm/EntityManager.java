package openeja.orm;

import java.util.LinkedList;

public abstract class EntityManager implements IEntity{
	
	
	private final LinkedList<IEntity> entities;
	
	public EntityManager() {
		
		this.entities = new LinkedList<IEntity>();
	}
	
	@Override
	public void add() {
		for(IEntity entity : entities){
			entity.add();
		}		
	}
	@Override
	public void remove() {
		for(IEntity entity : entities){
			entity.remove();
		}		
	}
	@Override
	public void update() {
		for(IEntity entity : entities){
			entity.update();
		}		
		
	}
	public void addEntity(IEntity entity){
		entities.add(entity);
	}
	
	public void removeEntity(IEntity entity){
		entities.remove(entity);
	}
}
