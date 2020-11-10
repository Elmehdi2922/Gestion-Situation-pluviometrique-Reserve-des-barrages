package prod.entities;


import java.text.ParseException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Capacite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float volume; 
	private String day;
	private String month;
	private String year;
	private String ddate;
	@ManyToOne
	@JoinColumn(name = "barrage", referencedColumnName = "id")
	private Barrage barrage;
	 
	public Capacite() {
 
	}

	@SuppressWarnings("deprecation")
	public Capacite(float volume, Barrage barrage) {
		super();
		this.volume = volume;
		this.barrage = barrage;
		Date t = new Date();
		year=""+t.getYear();
		if(t.getDay()<10)
		{day="0"+t.getDay();}else {day=""+t.getDay();}
		if(t.getMonth()<10)
		{month="0"+t.getMonth();}else {month=""+t.getMonth();}
		ddate=year+"-"+month+"-"+day; 
	}


	public Capacite(int id,float volume,int day, int month, int year, Barrage barrage) {
	
		this.id = id;
		this.volume = volume; 
		this.barrage = barrage;
		this.year=""+year ;
		this.ddate=year+"-";
		if(month<10)
		{this.ddate+="0"+ month ;this.month="0"+ month ;}else{this.month=""+month ;this.ddate+=""+month ;}
		if(day<10)
		{this.ddate+="-0"+day;this.day="0"+day;}else{this.ddate+="-"+day;this.day=""+day;}
	}
	

	/*public Capacite(float volume,int day, int month, int year, Barrage barrage){
		super();
		this.volume = volume; 
		this.barrage = barrage;
		this.year=""+year ;
		this.ddate=year+"-";
		if(month<10)
		{this.ddate+="0"+ month ;this.month="0"+ month ;}else{this.month=""+month ;this.ddate+=""+month ;}
		if(day<10)
		{this.ddate+="-0"+day;this.day="0"+day;}else{this.ddate+="-"+day;this.day=""+day;}
	}*/

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	 

	public float getVolume() {
		return volume;
	}


	public void setVolume(float volume) {
		this.volume = volume;
	}

	public Barrage getBarrage() {
		return barrage;
	}

	public void setBarrage(Barrage barrage) {
		this.barrage = barrage;
	}

	public String getDay() {
		return day;
	}


	/*public void setDay(String day) {
		this.day = day;
	}
*/

	public String getMonth() {
		return month;
	}


	/*public void setMonth(String month) {
		this.month = month;
	}*/


	public String getYear() {
		return year;
	}


	/*public void setYear(String year) {
		this.year = year;
	}*/


	public String getDdate() {
		return ddate;
	}


	public void setDdate(String ddate) throws ParseException {
		this.ddate = ddate;
		String[] ary = ddate.split("-|\\/"); 
		this.year=ary[0];this.month=ary[1];this.day=ary[2];
	}
}
