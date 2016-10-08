package groupy.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Equipe extends GenericEntity<Equipe> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	private String libelle;
	
	private Structure structure;
	
	@Override
	public Long getIdentifiant() {
		return identifiant;
	}

	@Override
	public void setAll(Equipe entity) {
		if(entity!=null){
			this.setLibelle(entity.getLibelle());
			this.setStructure(entity.getStructure());
		}
	}

	@Override
	public boolean equals(Equipe entity) {
		if(entity!=null){
			Structure structure = entity.getStructure();
			if(structure != null && structure.equals(structure)){
				return this.libelle.equals(structure.getLibelle());
			}
		}
		return false;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	
	
}
