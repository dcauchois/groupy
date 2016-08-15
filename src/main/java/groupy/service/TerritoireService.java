package groupy.service;

import groupy.entity.Territoire;

public interface TerritoireService extends GenericService<Territoire> {
	
	Territoire retrieveTerritoireByLibelle(String libelle);
}
