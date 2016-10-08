package groupy.service;


import java.util.List;

import groupy.entity.GenericEntity;
import groupy.exception.EntityExistsException;
import groupy.exception.EntityNotFoundException;

public interface GenericService<Entity extends GenericEntity<Entity>>{
	
	void create(Entity entity) throws EntityExistsException;
	
	Entity retrieve(Long identifiant) throws EntityNotFoundException;

	void update(Long identifiant, Entity entity) throws EntityNotFoundException;
	
	void delete(Long identifiant) throws EntityNotFoundException;
	
	List<Entity> retrieveAll();

}
