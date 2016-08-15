package groupy.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import groupy.entity.Groupe;

@Transactional
public interface GroupeDao extends CrudRepository<Groupe, Long>{

	public Groupe findByLibelle(String libelle);
}
