package prod;


import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 
import prod.entities.Admin;
import prod.entities.Barrage;
import prod.entities.Capacite;
import prod.entities.Pluie;
import prod.entities.Province;
import prod.entities.Sbassin;
import prod.repositories.AdminRepository;
import prod.repositories.BarrageRepository;
import prod.repositories.CapaciteRepository;
import prod.repositories.PluieRepository;
import prod.repositories.ProvinceRepository;
import prod.repositories.SbassinRepository;




@SpringBootApplication
public class EmsiStageirr42019Application implements CommandLineRunner {

	@Autowired
	public AdminRepository adminRepository ;

	@Autowired
	public BarrageRepository barRepository2 ;

	@Autowired
	public BarrageRepository barrageRepository ;

	@Autowired
	public CapaciteRepository capaciteRepository ;
	
	@Autowired
	public ProvinceRepository provinceRepository;
	
	@Autowired
	public SbassinRepository sbassinRepository;
	
	@Autowired
	public PluieRepository pluieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmsiStageirr42019Application.class, args);
	}
	
	public void run(String... arg0) throws Exception {	
		System.out.println("############## Projet ################");
		System.out.println("############## Admin Compte ################");
		
		adminRepository.save(new Admin("n410299","KHALKI","Elmehdi","Marrakech","d53177942","mehdikhalki45@gmail.com","images/icon/avatar-7.jpg","Admin","123"));
		adminRepository.save(new Admin("n20192","KHALKI","HAMZA","ESSAOUIRA","0604020505","HAMZAKHOKHO@gmail.com","images/icon/avatar-06.jpg","HAMZA","123"));
		
		adminRepository.save(new Admin("n20192","Persone","p1","ESSAOUIRA","0604020505","personne1@gmail.com","images/icon/avatar-06.jpg","HAMZA","123"));
		adminRepository.save(new Admin("n20192","Homme","p2","Casa","0604020505","personne2@gmail.com","images/icon/avatar-06.jpg","HAMZA","123"));
		adminRepository.save(new Admin("n20192","Femme","p3","Beni Mellal","0604020505","personne4@gmail.com","images/icon/avatar-06.jpg","HAMZA","123"));
		
		System.out.println("############## Barrages ################");

 
		Barrage b1= new Barrage("Bin El Ouidane",1215.50f ,"fff");
		Barrage b2= new Barrage("Hassan 1er",236.04f ,"fff");
		Barrage b3= new Barrage("Sidi Driss",2.45f,"fff");
		Barrage b4= new Barrage("Moulay Youssef",142.80f,"fff");
		Barrage b5= new Barrage("Timinoutine", 1.35f,"fff" ); 
		Barrage b6= new Barrage("Ahmed Al Hanssali", 668.17f,"fff" ); 
		Barrage b7= new Barrage("Ait Messaoud", 14.33f,"fff" ); 
		Barrage b8= new Barrage("Al Massira", 2656.99f,"fff" ); 
		Barrage b9= new Barrage("Imfout", 9.41f,"fff" ); 
		Barrage b10= new Barrage("Daourat", 6.76f,"fff" );  
		Barrage b11= new Barrage("Sidi Said Maachou",1.10f,"fff" ); 
		
		barrageRepository.save(b1);
		barrageRepository.save(b2);  
		barrageRepository.save(b3);  
		barrageRepository.save(b4);  
		barrageRepository.save(b5);  
		barrageRepository.save(b6);  
		barrageRepository.save(b7);  
		barrageRepository.save(b8);  
		barrageRepository.save(b9);  
		barrageRepository.save(b10);  
		barrageRepository.save(b11);  
		 
		
		System.out.println("############## Capacite ################");
		
		Calendar today = Calendar.getInstance();
		today.add(Calendar.HOUR_OF_DAY, +1);
		
		@SuppressWarnings("deprecation")
		int d=today.getTime().getDate();
		@SuppressWarnings("deprecation")
		int m=today.getTime().getMonth()+1;
		int y=LocalDate.now().getYear();
		
		System.out.println("############## Ajourdhui ################"); 
		capaciteRepository.save(new Capacite(1,713.09f,d,m,y, b1));
		capaciteRepository.save(new Capacite(2,204.66f,d,m,y ,b2));
		capaciteRepository.save(new Capacite(3,2.30f,d,m,y, b3));
		capaciteRepository.save(new Capacite(4,99.01f,d,m,y, b4));
		capaciteRepository.save(new Capacite(5,1.33f,d,m,y, b5));
		capaciteRepository.save(new Capacite(6,662.99f,d,m,y, b6));
		capaciteRepository.save(new Capacite(7,12.99f,d,m,y,b7));
		capaciteRepository.save(new Capacite(8,2002.41f,d,m,y, b8));
		capaciteRepository.save(new Capacite(9,6.70f,d,m,y, b9));
		capaciteRepository.save(new Capacite(10,0.99f,d,m,y, b10));
		

		System.out.println("############## Hier ################");
		
		capaciteRepository.save(new Capacite(11,710.09f,d-1,m,y,b1));
		capaciteRepository.save(new Capacite(12,214.66f,d-1,m,y,b2));
		capaciteRepository.save(new Capacite(13,1.30f,d-1,m,y,b3));
		capaciteRepository.save(new Capacite(14,141.01f,d-1,m,y,b4));
		capaciteRepository.save(new Capacite(15,0.33f,d-1,m,y,b5));
		capaciteRepository.save(new Capacite(16,500.99f,d-1,m,y,b6));
		capaciteRepository.save(new Capacite(17,5.99f,d-1,m,y,b7));
		capaciteRepository.save(new Capacite(18,1007.41f,d-1,m,y, b8));
		capaciteRepository.save(new Capacite(19,3.70f,d-1,m,y, b9));
		capaciteRepository.save(new Capacite(20,1.09f,d-1,m,y, b10)); 
		
		System.out.println("############## année précédente ################");
		
		capaciteRepository.save(new Capacite(21,992.09f,d,m,y-1,b1));
		capaciteRepository.save(new Capacite(22,100.66f,d,m,y-1,b2));
		capaciteRepository.save(new Capacite(23,2.30f,d,m,y-1,b3));
		capaciteRepository.save(new Capacite(24,99.01f,d,m,y-1,b4));
		capaciteRepository.save(new Capacite(25,1.33f,d,m,y-1,b5));
		capaciteRepository.save(new Capacite(26,660.99f,d,m,y-1,b6)); 
		capaciteRepository.save(new Capacite(27,10.99f,d,m,y-1,b7));
		capaciteRepository.save(new Capacite(28,2222.01f,d,m,y-1,b8));
		capaciteRepository.save(new Capacite(29,5.70f,d,m,y-1,b9));
		capaciteRepository.save(new Capacite(30,1.00f,d,m,y-1,b10)); 

		System.out.println("############## Mois precedent ################");
		
		capaciteRepository.save(new Capacite(31,713.09f,d,m-1,y, b1));
		capaciteRepository.save(new Capacite(32,204.66f,d,m-1,y ,b2));
		capaciteRepository.save(new Capacite(33,2.30f,d,m-1,y, b3));
		capaciteRepository.save(new Capacite(34,99.01f,d,m-1,y, b4));
		capaciteRepository.save(new Capacite(35,1.33f,d,m-1,y, b5));
		capaciteRepository.save(new Capacite(36,662.99f,d,m-1,y, b6));
		capaciteRepository.save(new Capacite(37,12.99f,d,m-1,y,b7));
		capaciteRepository.save(new Capacite(38,2002.41f,d,m-1,y, b8));
		capaciteRepository.save(new Capacite(39,6.70f,d,m-1,y, b9));
		capaciteRepository.save(new Capacite(40,0.99f,d,m-1,y, b10)); 
		
	
		
		capaciteRepository.save(new Capacite(41,600.09f,d-1,m-1,y, b1));
		capaciteRepository.save(new Capacite(42,200.66f,d-1,m-1,y ,b2));
		capaciteRepository.save(new Capacite(43,0.30f,d-1,m-1,y, b3));
		capaciteRepository.save(new Capacite(44,55.01f,d-1,m-1,y, b4));
		capaciteRepository.save(new Capacite(45,0.33f,d-1,m-1,y, b5));
		capaciteRepository.save(new Capacite(46,302.99f,d-1,m-1,y, b6));
		capaciteRepository.save(new Capacite(47,10.99f,d-1,m-1,y,b7));
		capaciteRepository.save(new Capacite(48,1588.41f,d-1,m-1,y, b8));
		capaciteRepository.save(new Capacite(49,4.70f,d-1,m-1,y, b9));
		capaciteRepository.save(new Capacite(50,0.09f,d-1,m-1,y, b10)); 
		System.out.println("############## Mois prochain ################");
		
		capaciteRepository.save(new Capacite(51,713.09f,d,m+1,y, b1));
		capaciteRepository.save(new Capacite(52,204.66f,d,m+1,y ,b2));
		capaciteRepository.save(new Capacite(53,2.30f,d,m+1,y, b3));
		capaciteRepository.save(new Capacite(54,99.01f,d,m+1,y, b4));
		capaciteRepository.save(new Capacite(55,1.33f,d,m+1,y, b5));
		capaciteRepository.save(new Capacite(56,662.99f,d,m+1,y, b6));
		capaciteRepository.save(new Capacite(57,12.99f,d,m+1,y,b7));
		capaciteRepository.save(new Capacite(58,2002.41f,d,m+1,y,b8));
		capaciteRepository.save(new Capacite(59,6.70f,d,m+1,y, b9));
		capaciteRepository.save(new Capacite(60,0.99f,d,m+1,y, b10));
		
		System.out.println("############## Sous Bassins ################");

		Province p1 = new Province("Beni Mellal");
		Province p2 = new  Province("Khenifra");
		Province p3 = new  Province("Azilal");
		Province p4 = new  Province("El Kelaa");
		Province p5 = new  Province("Settat");
		Province p6 = new  Province("Al Haouz");
		Province p7 = new  Province("Safi");
		Province p8 = new  Province("Marrakech");
		

		provinceRepository.save(p1);
		provinceRepository.save(p2);
		provinceRepository.save(p3);
		provinceRepository.save(p4);
		provinceRepository.save(p5);
		provinceRepository.save(p6);
		provinceRepository.save(p7);
		provinceRepository.save(p8);
		
		System.out.println("############## Sous Bassins ################");
		
		
		Sbassin sb1 = new Sbassin("Ahmed El Hansali",p1);
		Sbassin sb2 = new Sbassin("Tizi N`Isly",p1);
		Sbassin sb3 = new Sbassin("Beni Mellal",p1);
		Sbassin sb4 = new Sbassin("Mechra Eddahk",p1);
		Sbassin sb5 = new Sbassin("Ouled Sidi Driss",p1);
		Sbassin sb6 = new Sbassin("Taghzirt",p1);
		Sbassin sb7 = new Sbassin("My Bouzekri",p1);

		Sbassin sb8 = new Sbassin("Tarhat",p2);
		Sbassin sb9 = new Sbassin("Aval El Heri",p2);
		Sbassin sb10 = new Sbassin("Chacha N`Amellah",p2);
		Sbassin sb11 = new Sbassin("Taghzoute",p2);
		Sbassin sb12 = new Sbassin("Tamchachate",p2);

		Sbassin sb13 = new Sbassin("Ait Segmine",p3);
		Sbassin sb14 = new Sbassin("Ouaouirhint",p3);
		Sbassin sb15 = new Sbassin("Ait Ouchene",p3);
		Sbassin sb16 = new Sbassin("Tilouguite",p3);
		Sbassin sb17 = new Sbassin("Adammaghene",p3);
		Sbassin sb18 = new Sbassin("Bge Hassan 1er",p3);
		Sbassin sb19 = new Sbassin("Ait Tamlilt",p3);
		Sbassin sb20 = new Sbassin("Sgatt",p3);
		Sbassin sb21 = new Sbassin("Zaouite Ahansal",p3);
		

		sbassinRepository.save(sb1);
		sbassinRepository.save(sb2);
		sbassinRepository.save(sb3);
		sbassinRepository.save(sb4);
		sbassinRepository.save(sb5);
		sbassinRepository.save(sb6);
		sbassinRepository.save(sb7);
		
		sbassinRepository.save(sb8);
		sbassinRepository.save(sb9);
		sbassinRepository.save(sb10);
		sbassinRepository.save(sb11);
		sbassinRepository.save(sb12);
		
		sbassinRepository.save(sb13);
		sbassinRepository.save(sb14);
		sbassinRepository.save(sb15);
		sbassinRepository.save(sb16);
		sbassinRepository.save(sb17);
		sbassinRepository.save(sb18);
		sbassinRepository.save(sb19);
		sbassinRepository.save(sb20);
		sbassinRepository.save(sb21);

		System.out.println("############## Pluie ################");

		System.out.println("############## 06 2018 ################");

		pluieRepository.save(new Pluie("1","6","2018",0.0f,sb1));
		pluieRepository.save(new Pluie("1","6","2018",0.2f,sb2));
		pluieRepository.save(new Pluie("1","6","2018",3.0f,sb3));
		pluieRepository.save(new Pluie("1","6","2018",0.4f,sb4));
		pluieRepository.save(new Pluie("1","6","2018",0.0f,sb5));
		pluieRepository.save(new Pluie("1","6","2018",5.0f,sb6));
		pluieRepository.save(new Pluie("1","6","2018",1.0f,sb7));
		

		pluieRepository.save(new Pluie("1","6","2018",1.0f,sb8));
		pluieRepository.save(new Pluie("1","6","2018",5.23f,sb9));
		pluieRepository.save(new Pluie("1","6","2018",7.0f,sb10));
		pluieRepository.save(new Pluie("1","6","2018",3.6f,sb11));
		pluieRepository.save(new Pluie("1","6","2018",1.23f,sb12));
		

		pluieRepository.save(new Pluie("1","6","2018",1.45f,sb13));
		pluieRepository.save(new Pluie("1","6","2018",2.25f,sb14));
		pluieRepository.save(new Pluie("1","6","2018",3.17f,sb15));
		pluieRepository.save(new Pluie("1","6","2018",1.10f,sb16));
		pluieRepository.save(new Pluie("1","6","2018",3.9f,sb17));
		pluieRepository.save(new Pluie("1","6","2018",5.89f,sb18));
		pluieRepository.save(new Pluie("1","6","2018",5.80f,sb19));
		pluieRepository.save(new Pluie("1","6","2018",2.7f,sb20));
		pluieRepository.save(new Pluie("1","6","2018",1.6f,sb21));
		
		

		System.out.println("############## 07 2018 ################");
		
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb1));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb2));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb3));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb4));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb5));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb6));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb7));
		

		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb8));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb9));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb10));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb11));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb12));
		

		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb13));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb14));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb15));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb16));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb17));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb18));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb19));
		pluieRepository.save(new Pluie("1","7","2018",0.0f,sb20));
		pluieRepository.save(new Pluie("1","7","2018",8.6f,sb21));
		
		
		System.out.println("############## 06 2019 ################");

		pluieRepository.save(new Pluie("1","6","2019",0.0f,sb1));
		pluieRepository.save(new Pluie("1","6","2019",0.5f,sb2));
		pluieRepository.save(new Pluie("1","6","2019",0.3f,sb3));
		pluieRepository.save(new Pluie("1","6","2019",1.6f,sb4));
		pluieRepository.save(new Pluie("1","6","2019",0.0f,sb5));
		pluieRepository.save(new Pluie("1","6","2019",0.0f,sb6));
		pluieRepository.save(new Pluie("1","6","2019",0.1f,sb7));
		

		pluieRepository.save(new Pluie("1","6","2019",7.2f,sb8));
		pluieRepository.save(new Pluie("1","6","2019",2.8f,sb9));
		pluieRepository.save(new Pluie("1","6","2019",0.7f,sb10));
		pluieRepository.save(new Pluie("1","6","2019",2.0f,sb11));
		pluieRepository.save(new Pluie("1","6","2019",4.2f,sb12));
		

		pluieRepository.save(new Pluie("1","6","2019",1.8f,sb13));
		pluieRepository.save(new Pluie("1","6","2019",0.3f,sb14));
		pluieRepository.save(new Pluie("1","6","2019",0.2f,sb15));
		pluieRepository.save(new Pluie("1","6","2019",7.0f,sb16));
		pluieRepository.save(new Pluie("1","6","2019",7.0f,sb17));
		pluieRepository.save(new Pluie("1","6","2019",1.4f,sb18));
		pluieRepository.save(new Pluie("1","6","2019",2.5f,sb19));
		pluieRepository.save(new Pluie("1","6","2019",0.0f,sb20));
		pluieRepository.save(new Pluie("1","6","2019",0.0f,sb21));		
		
		
		System.out.println("############## 07 2019 ################");

		pluieRepository.save(new Pluie("1","7","2019",0.0f,sb1));
		pluieRepository.save(new Pluie("1","7","2019",0.5f,sb2));
		pluieRepository.save(new Pluie("1","7","2019",0.3f,sb3));
		pluieRepository.save(new Pluie("1","7","2019",1.6f,sb4));
		pluieRepository.save(new Pluie("1","7","2019",0.0f,sb5));
		pluieRepository.save(new Pluie("1","7","2019",0.0f,sb6));
		pluieRepository.save(new Pluie("1","7","2019",0.1f,sb7));
		

		pluieRepository.save(new Pluie("1","7","2019",7.2f,sb8));
		pluieRepository.save(new Pluie("1","7","2019",2.8f,sb9));
		pluieRepository.save(new Pluie("1","7","2019",0.7f,sb10));
		pluieRepository.save(new Pluie("1","7","2019",2.0f,sb11));
		pluieRepository.save(new Pluie("1","7","2019",4.2f,sb12));
		

		pluieRepository.save(new Pluie("1","7","2019",1.8f,sb13));
		pluieRepository.save(new Pluie("1","7","2019",0.3f,sb14));
		pluieRepository.save(new Pluie("1","7","2019",0.2f,sb15));
		pluieRepository.save(new Pluie("1","7","2019",7.0f,sb16));
		pluieRepository.save(new Pluie("1","7","2019",7.0f,sb17));
		pluieRepository.save(new Pluie("1","7","2019",1.4f,sb18));
		pluieRepository.save(new Pluie("1","7","2019",2.5f,sb19));
		pluieRepository.save(new Pluie("1","7","2019",0.0f,sb20));
		pluieRepository.save(new Pluie("1","7","2019",0.0f,sb21));
		
		System.out.println("############## 09 2019 ################");

		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb1));
		pluieRepository.save(new Pluie("1","9","2019",0.5f,sb2));
		pluieRepository.save(new Pluie("1","9","2019",0.3f,sb3));
		pluieRepository.save(new Pluie("1","9","2019",1.6f,sb4));
		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb5));
		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb6));
		pluieRepository.save(new Pluie("1","9","2019",0.1f,sb7));
		

		pluieRepository.save(new Pluie("1","9","2019",7.2f,sb8));
		pluieRepository.save(new Pluie("1","9","2019",2.8f,sb9));
		pluieRepository.save(new Pluie("1","9","2019",0.7f,sb10));
		pluieRepository.save(new Pluie("1","9","2019",2.0f,sb11));
		pluieRepository.save(new Pluie("1","9","2019",4.2f,sb12));
		

		pluieRepository.save(new Pluie("1","9","2019",1.8f,sb13));
		pluieRepository.save(new Pluie("1","9","2019",0.3f,sb14));
		pluieRepository.save(new Pluie("1","9","2019",0.2f,sb15));
		pluieRepository.save(new Pluie("1","9","2019",7.0f,sb16));
		pluieRepository.save(new Pluie("1","9","2019",7.0f,sb17));
		pluieRepository.save(new Pluie("1","9","2019",1.4f,sb18));
		pluieRepository.save(new Pluie("1","9","2019",2.5f,sb19));
		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb20));
		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb21));
		
		System.out.println("############## 09 2019 ################");

		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb1));
		pluieRepository.save(new Pluie("1","9","2019",0.5f,sb2));
		pluieRepository.save(new Pluie("1","9","2019",0.3f,sb3));
		pluieRepository.save(new Pluie("1","9","2019",1.6f,sb4));
		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb5));
		pluieRepository.save(new Pluie("1","9","2019",0.0f,sb6));
		pluieRepository.save(new Pluie("1","9","2019",0.1f,sb7));
		

		pluieRepository.save(new Pluie("1","9","2019",7.2f,sb8));
		pluieRepository.save(new Pluie("1","9","2019",2.8f,sb9));
		pluieRepository.save(new Pluie("1","9","2019",0.7f,sb10));
		pluieRepository.save(new Pluie("1","9","2019",2.0f,sb11));
		pluieRepository.save(new Pluie("1","9","2019",4.2f,sb12));

		System.out.println("############## 11 2019 ################");

		pluieRepository.save(new Pluie("1","11","2020",1.0f,sb1));
		pluieRepository.save(new Pluie("1","11","2020",0.2f,sb2));
		pluieRepository.save(new Pluie("1","11","2020",3.1f,sb3));
		pluieRepository.save(new Pluie("1","11","2020",0.4f,sb4));
		pluieRepository.save(new Pluie("1","11","2020",0.0f,sb5));
		pluieRepository.save(new Pluie("1","11","2020",5.4f,sb6));
		pluieRepository.save(new Pluie("1","11","2020",1.5f,sb7));
		

		pluieRepository.save(new Pluie("1","11","2020",1.0f,sb8));
		pluieRepository.save(new Pluie("1","11","2020",5.23f,sb9));
		pluieRepository.save(new Pluie("1","11","2020",7.4f,sb10));
		pluieRepository.save(new Pluie("1","11","2020",3.6f,sb11));
		pluieRepository.save(new Pluie("1","11","2020",1.33f,sb12));
		

		pluieRepository.save(new Pluie("1","11","2020",1.45f,sb13));
		pluieRepository.save(new Pluie("1","11","2020",2.25f,sb14));
		pluieRepository.save(new Pluie("1","11","2020",0.17f,sb15));
		pluieRepository.save(new Pluie("1","11","2020",1.10f,sb16));
		pluieRepository.save(new Pluie("1","11","2020",3.9f,sb17));
		pluieRepository.save(new Pluie("1","11","2020",5.89f,sb18));
		pluieRepository.save(new Pluie("1","11","2020",0.80f,sb19));
		pluieRepository.save(new Pluie("1","11","2020",2.7f,sb20));
		pluieRepository.save(new Pluie("1","11","2020",1.6f,sb21));
		
		
		System.out.println("############## 06 2020 ################");

		pluieRepository.save(new Pluie("1","6","2020",0.0f,sb1));
		pluieRepository.save(new Pluie("1","6","2020",0.2f,sb2));
		pluieRepository.save(new Pluie("1","6","2020",3.0f,sb3));
		pluieRepository.save(new Pluie("1","6","2020",0.4f,sb4));
		pluieRepository.save(new Pluie("1","6","2020",0.0f,sb5));
		pluieRepository.save(new Pluie("1","6","2020",7.0f,sb6));
		pluieRepository.save(new Pluie("1","6","2020",1.0f,sb7));
		

		pluieRepository.save(new Pluie("1","6","2020",9.0f,sb8));
		pluieRepository.save(new Pluie("1","6","2020",5.23f,sb9));
		pluieRepository.save(new Pluie("1","6","2020",7.0f,sb10));
		pluieRepository.save(new Pluie("1","6","2020",3.6f,sb11));
		pluieRepository.save(new Pluie("1","6","2020",1.23f,sb12));
		

		pluieRepository.save(new Pluie("1","6","2020",1.45f,sb13));
		pluieRepository.save(new Pluie("1","6","2020",5.25f,sb14));
		pluieRepository.save(new Pluie("1","6","2020",3.17f,sb15));
		pluieRepository.save(new Pluie("1","6","2020",1.10f,sb16));
		pluieRepository.save(new Pluie("1","6","2020",3.9f,sb17));
		pluieRepository.save(new Pluie("1","6","2020",6.89f,sb18));
		pluieRepository.save(new Pluie("1","6","2020",5.80f,sb19));
		pluieRepository.save(new Pluie("1","6","2020",2.7f,sb20));
		pluieRepository.save(new Pluie("1","6","2020",1.6f,sb21));
		
		

		System.out.println("############## 07 2020 ################");
		
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb1));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb2));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb3));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb4));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb5));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb6));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb7));
		

		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb8));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb9));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb10));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb11));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb12));
		

		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb13));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb14));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb15));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb16));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb17));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb18));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb19));
		pluieRepository.save(new Pluie("1","7","2020",0.0f,sb20));
		pluieRepository.save(new Pluie("1","7","2020",8.6f,sb21));
		
		System.out.println("############## 11 2020 ################");

		pluieRepository.save(new Pluie("1","11","2020",0.0f,sb1));
		pluieRepository.save(new Pluie("1","11","2020",0.5f,sb2));
		pluieRepository.save(new Pluie("1","11","2020",0.3f,sb3));
		pluieRepository.save(new Pluie("1","11","2020",1.6f,sb4));
		pluieRepository.save(new Pluie("1","11","2020",0.0f,sb5));
		pluieRepository.save(new Pluie("1","11","2020",0.0f,sb6));
		pluieRepository.save(new Pluie("1","11","2020",0.1f,sb7));

		pluieRepository.save(new Pluie("1","11","2020",7.2f,sb8));
		pluieRepository.save(new Pluie("1","11","2020",2.8f,sb9));
		pluieRepository.save(new Pluie("1","11","2020",0.7f,sb10));
		pluieRepository.save(new Pluie("1","11","2020",2.0f,sb11));
		pluieRepository.save(new Pluie("1","11","2020",4.2f,sb12));

		pluieRepository.save(new Pluie("1","11","2020",1.8f,sb13));
		pluieRepository.save(new Pluie("1","11","2020",0.3f,sb14));
		pluieRepository.save(new Pluie("1","11","2020",0.2f,sb15));
		pluieRepository.save(new Pluie("1","11","2020",7.0f,sb16));
		pluieRepository.save(new Pluie("1","11","2020",7.0f,sb17));
		pluieRepository.save(new Pluie("1","11","2020",1.4f,sb18));
		pluieRepository.save(new Pluie("1","11","2020",2.5f,sb19));
		pluieRepository.save(new Pluie("1","11","2020",0.0f,sb20));
		pluieRepository.save(new Pluie("1","11","2020",0.0f,sb21));
		
		System.out.println("############## The END ################");
		
		
		 
	}

}
