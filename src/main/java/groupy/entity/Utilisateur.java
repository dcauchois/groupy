package groupy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur extends GenericEntity<Utilisateur>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	@Column(nullable=false,length=100)
	private String login;

	@Column(nullable=false,length=100)
	private String password;
	
	@OneToMany(mappedBy="rapporteur")
	private List<Information> informationsRapportees;

	@Override
	public Long getIdentifiant() {
		 return this.identifiant;
	}
	
	@Override
	public void setAll(Utilisateur entity) {
		if(entity!=null){
			this.setLogin(entity.getLogin());
			this.setPassword(entity.getPassword());
			this.setInformationsRapportees(entity.getInformationsRapportees());
		}
	}

	@Override
	public boolean equals(Utilisateur entity) {
		return entity != null && this.login.equals(entity);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Information> getInformationsRapportees() {
		return informationsRapportees;
	}

	public void setInformationsRapportees(List<Information> informationsRapportees) {
		this.informationsRapportees = informationsRapportees;
	}
	
	
	
	
}
