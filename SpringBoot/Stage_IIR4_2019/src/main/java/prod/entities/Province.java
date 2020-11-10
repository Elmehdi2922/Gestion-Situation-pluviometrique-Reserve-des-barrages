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
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomp;
	@OneToMany(mappedBy="province",cascade = {CascadeType.ALL}) 
	@JsonIgnore
    private List<Sbassin> sbassins;
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Province(String nomp) {
		super();
		
		this.nomp = nomp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", nomp=" + nomp + "]";
	}
	
	
	
}
