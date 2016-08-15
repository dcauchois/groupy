package groupy.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import groupy.entity.Territoire;

@Transactional
public interface TerritoireDao extends CrudRepository<Territoire, Long> {

	public Territoire findByLibelle(String libelle);
}
