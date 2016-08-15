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
public class Groupe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	@Column(unique=true, nullable=false)
	private String libelle;
	
	@ManyToOne
	private Territoire territoire;
	
	@OneToMany(mappedBy="groupe")
	private List<Information> informations;

	public Long getIdentifiant() {
		return identifiant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Territoire getTerritoire() {
		return territoire;
	}

	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((territoire == null) ? 0 : territoire.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (territoire == null) {
			if (other.territoire != null)
				return false;
		} else if (!territoire.equals(other.territoire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(libelle!=null){
			String libelleTerritoire="?";
			if(territoire!=null){
				libelleTerritoire = territoire.toString();
			}
		
			return libelle + "("+libelleTerritoire+")";
			
		}
		return "?";
		
	}
	
	
}
