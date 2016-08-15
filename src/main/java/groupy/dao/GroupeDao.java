package groupy.dao;

import javax.transaction.Transactional;

import groupy.entity.Groupe;

@Transactional
public interface GroupeDao extends GenericDao<Groupe>{

	public Groupe findByLibelle(String libelle);
}
