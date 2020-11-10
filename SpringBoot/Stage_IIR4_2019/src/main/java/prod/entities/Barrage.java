package prod.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Barrage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private float vol; 
	private String image; 
	@OneToMany(mappedBy="barrage",cascade = {CascadeType.ALL}) 
	@JsonIgnore
    private List<Capacite> capacites;
	
	public Barrage() {
		super();
	}

	public Barrage(String nom, float vol, String image) {
		super();
		this.nom = nom;
		this.vol = vol;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getVol() {
		return vol;
	}

	public void setVol(float vol) {
		this.vol = vol;
	}

	public String getImage() {
		return image;
	}
	
	public List<Capacite> getCapacites() {
		return capacites;
	}

	public void setCapacites(List<Capacite> capacites) {
		this.capacites = capacites;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
