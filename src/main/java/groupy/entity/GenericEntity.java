package groupy.entity;

public abstract class GenericEntity<Entity extends GenericEntity<Entity>> {
	
	public abstract Long getIdentifiant();
	
	public abstract void setAll(Entity entity);
	
	public abstract boolean equals(Entity entity);
}
