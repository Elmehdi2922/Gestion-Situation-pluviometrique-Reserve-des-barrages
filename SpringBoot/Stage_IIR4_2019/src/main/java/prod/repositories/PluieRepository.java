package prod.repositories;

 

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prod.entities.Pluie; 


@Primary
public interface PluieRepository extends JpaRepository<Pluie,Integer> {
	
	@Query(value = "SELECT mois_name FROM pluie where annee= year(CURRENT_DATE) GROUP by mois_name;"
			, nativeQuery = true)
	public List<?> getMoisInfo();//get_mois.info

	@Query(value = "SELECT pluie.id, pluie.ddate as ddate,pluie.moyenne,province.id as proid"+
			" ,province.nomp as pronom,sbassin.id as sbassinid,sbassin.nom as sbassinnom "+
			" FROM `pluie`,sbassin,province WHERE pluie.sbassin=sbassin.id and "+
			" sbassin.province = province.id and pluie.annee=year(CURRENT_DATE) and pluie.mois=month(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getPluieInfo3();//get_pluie.info3
	
	
	@Query(value = "SELECT pluie.id,province.nomp as pronom, sbassin.nom as sbassinnom,"+
			" pluie.ddate as ddate,pluie.moyenne FROM `pluie`,sbassin,province WHERE"+
			" pluie.sbassin=sbassin.id and sbassin.province = province.id and pluie.annee=year(CURRENT_DATE)"+
			" and pluie.mois=month(CURRENT_DATE)"
			, nativeQuery = true)
	public List<?> getPluieInfo4();//get_pluie.info4
	
}
