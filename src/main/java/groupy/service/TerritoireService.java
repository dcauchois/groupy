package groupy.service;

import groupy.entity.Territoire;

public interface TerritoireService {

	void createTerritoire(Territoire territoire);
	
	Territoire retrieveTerritoireByLibelle(String libelle);
	
	Territoire retrieveTerritoire(Long identifiant);
	
	void updateTerritoire(Long identifiant, Territoire territoire);
	
	void deleteTerritoire(Long identifiant);
}
