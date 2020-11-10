package prod.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends Personne{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date_emb; 
	
	
	public Admin(String cin, String nom, String prenom, String adresse, String tele, String email, String image,
			String login, String mot_passe) {
		super(cin, nom, prenom, adresse, tele, email, image, login, mot_passe,"admin");
		this.date_emb = new Date();
	 
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_emb() {
		return date_emb;
	}
	public void setDate_emb(Date date_emb) {
		this.date_emb = date_emb;
	}
	 
	
	
}
