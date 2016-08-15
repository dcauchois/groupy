package groupy.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import groupy.entity.Information;

@Transactional
public interface InformationDao extends CrudRepository<Information, Long>{

}
