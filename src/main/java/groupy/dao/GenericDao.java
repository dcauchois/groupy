package groupy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import groupy.entity.GenericEntity;

@NoRepositoryBean
public interface GenericDao<Entity extends GenericEntity<Entity>> extends CrudRepository<Entity, Long> {

}
