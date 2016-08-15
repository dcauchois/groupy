package groupy.service.impl;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;

import groupy.dao.GenericDao;
import groupy.entity.GenericEntity;
import groupy.service.GenericService;

public abstract class GenericServiceImpl<Entity extends GenericEntity<Entity>> implements GenericService<Entity>{

	abstract GenericDao<Entity> getDao();
	abstract String getNomEntity();
	abstract Logger getLogger();

	@Override
	public void create(Entity entity) {
		getLogger().info(getNomEntity()+" | CREATION | {}",entity);
		getDao().save(entity);
	}

	@Override
	public Entity retrieve(Long identifiant) {
		getLogger().info(getNomEntity()+" | RECHERCHE BY ID | {}",identifiant);
		Entity entity = getDao().findOne(identifiant);
		if(entity!=null){
			getLogger().debug(getNomEntity()+" | RECHERCHE BY ID | FOUND {} pour id : {}",entity, entity.getIdentifiant());
			return entity;
		}
		throw new EntityNotFoundException();
	}

	@Override
	public void update(Long identifiant, Entity entity) {
		getLogger().info(getNomEntity()+" | UPDATE | {}",identifiant);
		Entity current = getDao().findOne(identifiant);
		current.setAll(entity);
		getDao().save(current);
	}

	@Override
	public void delete(Long identifiant) {
		getLogger().info(getNomEntity()+" | DELETE | {}",identifiant);
		getDao().delete(identifiant);
	}

}
