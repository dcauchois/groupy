package groupy.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;

import groupy.dao.GenericDao;
import groupy.entity.GenericEntity;
import groupy.exception.EntityExistsException;
import groupy.exception.EntityNotFoundException;
import groupy.service.GenericService;

public abstract class GenericServiceImpl<Entity extends GenericEntity<Entity>> implements GenericService<Entity>{

	abstract GenericDao<Entity> getDao();
	abstract String getNomEntity();
	abstract Logger getLogger();


	@Override
	public void create(Entity entity) throws EntityExistsException {
		getLogger().info(getNomEntity()+" | CREATES | {}",entity);
		if(exists(entity)){
			throw new EntityExistsException();
		}
		getDao().save(entity);
	}

	@Override
	public Entity retrieve(Long identifiant) throws EntityNotFoundException {
		getLogger().info(getNomEntity()+" | SEARCHES BY ID | {}",identifiant);
		Entity entity = getDao().findOne(identifiant);
		if(entity!=null){
			getLogger().debug(getNomEntity()+" | SEARCHES BY ID | FOUND {} pour id : {}",entity, entity.getIdentifiant());
			return entity;
		}
		throw new EntityNotFoundException();
	}

	@Override
	public void update(Long identifiant, Entity entity) throws EntityNotFoundException {
		getLogger().info(getNomEntity()+" | UPDATES | {}",identifiant);
		Entity current = getDao().findOne(identifiant);
		if(current!=null){
			current.setAll(entity);
			getDao().save(current);
		}else{
			throw new EntityNotFoundException();
		}
		
	}

	@Override
	public void delete(Long identifiant) throws EntityNotFoundException {
		getLogger().info(getNomEntity()+" | DELETES | {}",identifiant);
		try{
			getDao().delete(identifiant);
		}catch(EmptyResultDataAccessException e){
			throw new EntityNotFoundException();
		}
			
		
	}
	
	@Override
	public List<Entity> retrieveAll(){
		List<Entity> entities = new ArrayList<Entity>();
		for(Entity entity : getDao().findAll()){
			entities.add(entity);
		}
		return entities;
	}

	
	private boolean exists(Entity entity){
		for(Entity currentEntity : getDao().findAll()){
			if(currentEntity.equals(entity)){
				return true;
			}
		}
		return false;
	}
	
	
}
