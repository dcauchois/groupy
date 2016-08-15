package groupy.service;

import groupy.entity.GenericEntity;

public interface GenericService<Entity extends GenericEntity<Entity>>{
	
	void create(Entity entity);
	
	Entity retrieve(Long identifiant);

	void update(Long identifiant, Entity entity);
	
	void delete(Long identifiant);

}
