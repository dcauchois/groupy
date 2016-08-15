package groupy.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import groupy.entity.Utilisateur;

@Transactional
public interface UtilisateurDao extends CrudRepository<Utilisateur, Long>{

}
