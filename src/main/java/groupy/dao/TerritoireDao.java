package groupy.dao;

import javax.transaction.Transactional;

import groupy.entity.Territoire;

@Transactional
public interface TerritoireDao extends GenericDao<Territoire> {

	public Territoire findByLibelle(String libelle);
}
