package groupy.dao;

import javax.transaction.Transactional;

import groupy.entity.Information;

@Transactional
public interface InformationDao extends GenericDao<Information>{

}
