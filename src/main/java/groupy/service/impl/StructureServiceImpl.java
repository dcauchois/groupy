package groupy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupy.dao.GenericDao;
import groupy.dao.StructureDao;
import groupy.entity.Structure;
import groupy.exception.EntityNotFoundException;
import groupy.service.StructureService;

@Service("territoireService")
public class StructureServiceImpl extends GenericServiceImpl<Structure> implements StructureService{

	private static Logger LOGGER = LoggerFactory.getLogger(StructureServiceImpl.class);
				
	@Autowired
	private StructureDao structureDao;
	
	@Override
	public Structure retrieveStructureByLibelle(String libelle) throws EntityNotFoundException {
		LOGGER.info(getNomEntity()+ " | " + "SEARCHES BY LIBELLE "+" | {}",libelle);
		return structureDao.findByLibelle(libelle);
	}

	@Override
	GenericDao<Structure> getDao() {
		return structureDao;
	}

	@Override
	String getNomEntity() {
		return "Structure";
	}

	@Override
	Logger getLogger() {
		return LOGGER;
	}
}
