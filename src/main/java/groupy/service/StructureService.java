package groupy.service;

import groupy.entity.Structure;
import groupy.exception.EntityNotFoundException;

public interface StructureService extends GenericService<Structure>{
	
	Structure retrieveStructureByLibelle(String libelle) throws EntityNotFoundException;

}
