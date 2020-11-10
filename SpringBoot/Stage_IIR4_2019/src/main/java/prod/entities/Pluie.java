package prod.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Pluie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jour;
	private String moisName;
	private String mois;
	private String annee;
	private float moyenne;
	@ManyToOne
	@JoinColumn(name = "sbassin", referencedColumnName = "id")
	private Sbassin sbassin;
	private String ddate;
	
	public Pluie() {
		
	}

	public Pluie(String jour, String mois, String annee,float moyenne, Sbassin sbassin) {
		
		this.jour = jour;
		this.moyenne = moyenne;
		this.moisName= getMonthName(mois);
		this.mois = mois;
		this.annee = annee;
		this.sbassin = sbassin;
		this.ddate=annee;
		if(Integer.parseInt(mois) <10)
		{this.ddate+="-0"+mois;}else {this.ddate+="-"+mois;}
		if(Integer.parseInt(jour) <10)
		{this.ddate+="-0"+ jour ;}else {this.ddate+="-"+jour ;}
		
	}

	public Pluie(float moyenne, Sbassin sbassin) {
		this.jour = LocalDate.now().getDayOfMonth()+"";
		this.mois = LocalDate.now().getMonth()+"";
		this.moisName= getMonthName(LocalDate.now().getMonth()+"");
		this.annee = LocalDate.now().getYear()+"";
		this.moyenne = moyenne;
		this.sbassin = sbassin;
	}

	public Pluie(String mois, String annee, float moyenne, Sbassin idsb) {
	    this.jour = LocalDate.now().getDayOfMonth()+"";
		this.mois = mois;
		this.moisName= getMonthName(mois);
		this.annee = annee;
		this.moyenne = moyenne;
		this.sbassin = idsb;
	}


	public String getMoisName() {
		return moisName;
	}


	/*public void setMoisName(String moisName) {
		this.moisName = moisName;
	}*/


	public Sbassin getSbassin() {
		return sbassin;
	}


	public void setSbassin(Sbassin sbassin) {
		this.sbassin = sbassin;
	}


	public String getDdate() {
		return ddate;
	}


	public void setDdate(String ddate) {
		this.ddate = ddate;
		String[] ary = ddate.split("-|\\/"); 
		this.annee=ary[0];this.mois=ary[1];this.jour=ary[2];this.moisName= getMonthName(ary[1]);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJour() {
		return jour;
	}

	/*public void setJour(String jour) {
		this.jour = jour;
	}*/

	public String getMois() {
		return mois;
	}

	/*public void setMois(String mois) {
		this.mois = mois;
	}
*/
	public String getAnnee() {
		return annee;
	}

	/*public void setAnnee(String annee) {
		this.annee = annee;
	}*/

	public float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}

	
	public String getMonthName(String month)
	{   String monthString="";
        switch (Integer.parseInt(month)) {
            case 1 :  monthString = "janvier";break;
            case 2 :  monthString = "février";break;
            case 3 :  monthString = "mars";break;
            case 4 :  monthString = "avril";break;
            case 5 :  monthString = "mai";break;
            case 6 :  monthString = "juin";break;
            case 7 :  monthString = "juillet";break;
            case 8 :  monthString = "août";break;
            case 9 :  monthString = "septembre";break;
            case 10:  monthString = "octobre";break;
            case 11:  monthString = "novembre";break;
            case 12:  monthString = "décembre";break;
            default  :  monthString = "Invalid month";break;
        }
		return monthString;
	}
}
