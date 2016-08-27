package groupy.service.impl;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupy.dao.GenericDao;
import groupy.dao.TerritoireDao;
import groupy.entity.Territoire;
import groupy.service.TerritoireService;

@Service("territoireService")
public class TerritoireServiceImpl extends GenericServiceImpl<Territoire> implements TerritoireService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

	@Autowired
	private TerritoireDao territoireDao;

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
	GenericDao<Territoire> getDao() {
		return territoireDao;
	}

	@Override
	String getNomEntity() {
		return "TERRITOIRE";
	}

	@Override
	Logger getLogger() {
		return logger;
	}

}
