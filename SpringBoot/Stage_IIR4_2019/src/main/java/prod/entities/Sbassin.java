package prod.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Sbassin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "province", referencedColumnName = "id")
	private Province province;
	@OneToMany(mappedBy="sbassin",cascade = {CascadeType.ALL}) 
	@JsonIgnore
    private List<Pluie> pluies;
	public Sbassin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sbassin(String nom, Province province) {
		super();
		this.nom = nom;
		this.province = province;
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
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	public List<Pluie> getPluies() {
		return pluies;
	}
	public void setPluies(List<Pluie> pluies) {
		this.pluies = pluies;
	}
	@Override
	public String toString() {
		return "Sbassin [id=" + id + ", nom=" + nom + ", province=" + province + "]";
	}
	
	
	
}
