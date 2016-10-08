package groupy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Structure extends GenericEntity<Structure>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	@Column(unique=true, nullable=false)
	private String libelle;
	
	@ManyToOne
	private Structure structureMere;
	
	@OneToMany(mappedBy="structureMere")
	private List<Structure> structuresFilles;	
	
	@OneToMany(mappedBy="structure")
	private List<Equipe> equipes;
	

	@Override
	public Long getIdentifiant() {
		 return this.identifiant;
	}
	
	public Structure(){
		super();
	}
	
	public Structure(String libelle){
		this();
		this.libelle = libelle;
	}
	
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Structure getStructureMere() {
		return structureMere;
	}

	public void setStructureMere(Structure structureMere) {
		this.structureMere = structureMere;
	}

	public List<Structure> getStructuresFilles() {
		return structuresFilles;
	}

	public void setStructuresFilles(List<Structure> structuresFilles) {
		this.structuresFilles = structuresFilles;
	}
	
	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	@Override
	public void setAll(Structure entity) {
		if(entity!=null){
			this.setLibelle(entity.getLibelle());
			this.setStructureMere(entity.getStructureMere());
			this.setStructuresFilles(entity.getStructuresFilles());
			this.setEquipes(entity.getEquipes());
		}
	}

	@Override
	public boolean equals(Structure entity) {
		if(entity != null){
			Structure structureMere = entity.getStructureMere();
			if(structureMere == null && this.getStructureMere()==null){
				return this.libelle.equals(entity.getLibelle());
			}
			else if(structureMere.equals(this.getStructureMere())){
				return this.libelle.equals(entity.getLibelle());
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.libelle;
	}

	
	
	
	
}
