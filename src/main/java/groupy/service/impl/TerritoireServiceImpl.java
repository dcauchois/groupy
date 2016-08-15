package groupy.service.impl;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupy.dao.TerritoireDao;
import groupy.entity.Territoire;
import groupy.service.TerritoireService;

@Service("territoireService")
public class TerritoireServiceImpl implements TerritoireService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
	
	@Autowired
	private TerritoireDao territoireDao;
	
	

	@Override
	public void createTerritoire(Territoire territoire) {
		logger.info("TERRITOIRE | CREATION | {}",territoire);
		territoireDao.save(territoire);
	}

	@Override
	public Territoire retrieveTerritoireByLibelle(String libelle){
		logger.info("TERRITOIRE | RECHERCHE BY LIBELLE | {}",libelle);
		Territoire territoire = territoireDao.findByLibelle(libelle);
		if(territoire!=null){
			logger.debug("TERRITOIRE | RECHERCHE BY LIBELLE | FOUND id : {}  pour libelle : {}",territoire.getIdentifiant(), territoire.getLibelle());
			return territoire;
		}
		throw new EntityNotFoundException();
	}

	@Override
	public Territoire retrieveTerritoire(Long identifiant) {
		logger.info("TERRITOIRE | RECHERCHE BY ID | {}",identifiant);
		Territoire territoire = territoireDao.findOne(identifiant);
		if(territoire!=null){
			logger.debug("TERRITOIRE | RECHERCHE BY ID | FOUND libelle : {} pour id : {}",territoire.getLibelle(), territoire.getIdentifiant());
			return territoire;
		}
		throw new EntityNotFoundException();
	}

	@Override
	public void updateTerritoire(Long identifiant, Territoire territoire) {
		logger.info("TERRITOIRE | UPDATE | {}",identifiant);
		Territoire current = retrieveTerritoire(identifiant);
		current.setLibelle(territoire.getLibelle());
		territoireDao.save(current);
	}

	@Override
	public void deleteTerritoire(Long identifiant) {
		logger.info("TERRITOIRE | DELETE | {}",identifiant);
		territoireDao.delete(identifiant);
	}

}
