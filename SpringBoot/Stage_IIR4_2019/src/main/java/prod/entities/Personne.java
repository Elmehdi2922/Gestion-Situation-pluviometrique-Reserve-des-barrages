package prod.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String cin;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String tele;
	protected String email;
	protected String image;
	private String login;
	private String motpasse;
	private boolean etat;
	private String typecompte;
	private int sid=5 ;
	private int sss=255;
	
	



	public Personne(String cin, String nom, String prenom, String adresse, String tele, String email, String image,
			String login,String motpasse, String typecompte,int sid) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tele = tele;
		this.email = email;
		this.image = image;
		this.login = login;
		this.motpasse = motpasse;
		this.typecompte = typecompte;
		this.sid = sid;
		this.sss= 158;
		
	}



	public Personne(String cin, String nom, String prenom, String adresse, String tele, String email, String image,
			String login, String motpasse, String typecompte) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tele = tele;
		this.email = email;
		this.image = image;
		this.login = login;
		this.motpasse = motpasse;
		this.typecompte = typecompte;

		this.sss= 158;
		this.sid = 10;
	}









	public Personne() {
		super();
	}
	
	
	
	 


	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getmotpasse() {
		return motpasse;
	}



	public void setmotpasse(String motpasse) {
		this.motpasse = motpasse;
	}



	public boolean isEtat() {
		return etat;
	}



	public void setEtat(boolean etat) {
		this.etat = etat;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getCin() {
		return cin;
	}





	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

 
	public String getTypecompte() {
		return typecompte;
	}

	public void setTypecompte(String typecompte) {
		this.typecompte = typecompte;
	}



	public int getSid() {
		return sid;
	}



	public void setSid(int sid) {
		this.sid = id;
	}



	public int getSss() {
		return sss;
	}



	public void setSss(int sss) {
		this.sss = sss;
	}

	
}
