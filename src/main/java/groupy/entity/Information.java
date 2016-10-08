package groupy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Information extends GenericEntity<Information> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	@Column(nullable=false)
	private Date date;
	
	@ManyToOne
	private Structure structure;
	
	@ManyToOne
	private Utilisateur rapporteur;
	
	@Column(nullable=false)
	private String commentaire;

	@Override
	public Long getIdentifiant() {
		 return this.identifiant;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Utilisateur getRapporteur() {
		return rapporteur;
	}

	public void setRapporteur(Utilisateur rapporteur) {
		this.rapporteur = rapporteur;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public void setAll(Information entity) {
		if(entity!=null){
			this.setDate(entity.getDate());
			this.setCommentaire(entity.getCommentaire());
			this.setRapporteur(entity.getRapporteur());
		}
	}

	@Override
	public boolean equals(Information entity) {
		return identifiant.equals(entity.getIdentifiant());
	}
	
	

}
