package prod.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prod.entities.Capacite; 

@Primary
public interface CapaciteRepository extends JpaRepository<Capacite,Integer> {

	@Query(value = "SELECT barrage.id as id,nom,vol,volume,image,ddate"+
			" FROM barrage,capacite where barrage.id= capacite.barrage "+
			" and DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE) and capacite.year=year(CURRENT_DATE)-1 "
			, nativeQuery = true)
	public List<?> getAnnPrecInfo();//get_ann-prec.info

	
	@Query(value = "SELECT capacite.id as id,nom,ddate,vol,volume "+
			" FROM barrage,capacite where barrage.id= capacite.barrage and"+
			" DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE) and "+
			" capacite.year=year(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getAujourInfo();//get_aujour.info
	

	@Query(value = "SELECT capacite.id as id,nom,ddate,vol,volume"+
			" FROM barrage,capacite where barrage.id= capacite.barrage"+
			" and DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE) and capacite.year=year(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getAujourInfo2();//get_aujour.info2
	
	
	@Query(value = "SELECT capacite.id as id,nom,vol,volume,image,ddate,barrage "+
			" FROM barrage,capacite where barrage.id= capacite.barrage and DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE)"+
			" and capacite.year=year(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getAujourInfo3();//get_aujour.info3
	
	
	@Query(value = "SELECT capacite.id as id,nom,vol,volume,ddate "+
			" FROM barrage,capacite where barrage.id= capacite.barrage "+
			" and DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE) and "+
			" capacite.year=year(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getAujourInfo4();//get_aujour.info4

	@Query(value = "SELECT b.nom, (select capacite.volume from capacite "+
			" where capacite.barrage = b.id and year(capacite.ddate)=year(CURRENT_DATE)"+
			" and month(capacite.ddate)=month(CURRENT_DATE) and"+
			" day(capacite.ddate)= day(CURRENT_DATE)) as currentdate,"+
			" (select capacite.volume from capacite where capacite.barrage = b.id"+
			" and year(capacite.ddate)=year(CURRENT_DATE)-1 and month(capacite.ddate)=month(CURRENT_DATE)"+
			" and day(capacite.ddate)= day(CURRENT_DATE)) as lastdate from barrage b"
			, nativeQuery = true)
	public List<?> getAujourInfo5();//get_aujour.info5

	@Query(value = "SELECT capacite.month,barrage.id,capacite.year, avg(capacite.volume) as vol "+
			"FROM barrage,capacite where barrage.id= capacite.barrage group by capacite.month,"+
			"barrage.id ,capacite.year"
			, nativeQuery = true)
	public List<?> getAujourBarInfo();//get_aujour-bar.info
	

	@Query(value = "SELECT barrage.nom,barrage.vol,capacite.volume "+
			"FROM barrage,capacite where barrage.id= capacite.barrage "+
			"and DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE) and "+
			"capacite.year=year(CURRENT_DATE) "
			, nativeQuery = true)
	public List<?> getAujourBarInfo2();//get_aujour-bar.info2
	

	@Query(value = "SELECT sum(b.vol) as volume,sum(capacite.volume ) as vol"+
			" From barrage as b,capacite WHERE b.id=capacite.barrage and"+
			" DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE); "
			, nativeQuery = true)
	public List<?> getAujourBarInfo4();//get_aujour-bar.info4
	

	@Query(value = "SELECT nom,vol FROM barrage ;", nativeQuery = true)
	public List<?> getBarragesInfo2();//get_barrages.info2
	
	@Query(value = "SELECT id,nom,vol FROM barrage ;", nativeQuery = true)
	public List<?> getBarragesInfo3();//get_barrages.info3
	
	
	@Query(value = "SELECT barrage.id as id,nom,vol,volume,image,ddate "+
			"FROM barrage,capacite where barrage.id= capacite.barrage and "+
			"DAYOFYEAR(capacite.ddate)=DAYOFYEAR(CURRENT_DATE)-1 and "+
			"capacite.year=year(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getHierInfo();//get_hier.info


	
	

	
}
