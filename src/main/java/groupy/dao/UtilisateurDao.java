package groupy.dao;

import javax.transaction.Transactional;

import groupy.entity.Utilisateur;

@Transactional
public interface UtilisateurDao extends GenericDao<Utilisateur>{

}
