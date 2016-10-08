package groupy.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipe extends GenericEntity<Equipe> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	private String libelle;
	
	@ManyToOne
	private Structure structure;
	
	@OneToMany(mappedBy="equipe")
	private List<Information> informations;
	
	@Override
	public Long getIdentifiant() {
		return identifiant;
	}

	@Override
	public void setAll(Equipe entity) {
		if(entity!=null){
			this.setLibelle(entity.getLibelle());
			this.setStructure(entity.getStructure());
			this.setInformations(entity.getInformations());
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

	public List<Information> getInformations() {
		return informations;
	}

	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}

	
	
}
