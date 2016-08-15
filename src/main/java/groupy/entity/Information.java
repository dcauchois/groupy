package groupy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import groupy.enumeration.Unite;

@Entity
public class Information extends GenericEntity<Information> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	
	@Column(nullable=false)
	private Date date;
	
	@ManyToOne
	private Groupe groupe;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Unite unite;
	
	@ManyToOne
	private Utilisateur rapporteur;
	
	@Column(nullable=false,length=2000)
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

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
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
		
	}
	
	

}
