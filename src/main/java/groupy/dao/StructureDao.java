package groupy.dao;

import javax.transaction.Transactional;

import groupy.entity.Structure;

@Transactional
public interface StructureDao extends GenericDao<Structure> {

	public Structure findByLibelle(String libelle);
}
