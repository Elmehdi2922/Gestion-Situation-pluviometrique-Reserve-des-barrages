package prod.repositories;

 

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prod.entities.Sbassin; 


@Primary
public interface SbassinRepository extends JpaRepository<Sbassin,Integer> {

	@Query(value = "SELECT p.mois as moisp,pro.nomp as nomp,sb.province as provinceid,"
			+ " sb.id as sbid,sb.nom as nomsb,CAST((SELECT p2.moyenne from pluie p2"
			+ " Where p2.sbassin=p.sbassin and p2.annee=year(CURRENT_DATE)-1 and p2.mois=moisp)"
			+ " AS DECIMAL(3,1)) as p2018,CAST((SELECT p3.moyenne from pluie p3 "
			+ " Where p3.sbassin=p.sbassin and p3.annee=year(CURRENT_DATE) and p3.mois=moisp)"
			+ " AS DECIMAL(2,1)) as p2019 FROM pluie p,province pro,sbassin sb"
			+ " Where pro.id=sb.province and p.sbassin=sb.id and p.mois=mois "
			+ " GROUP by moisp,nomp,provinceid,sbid,nomsb,p2018,p2019 ORDER by provinceid,sbid"
			, nativeQuery = true)
	public List<?> getSbassinInfo2();//get_sbassin.info2

	@Query(value = "SELECT sb.id,sb.nom,pro.nomp as province,pro.id as proid"
			+ " FROM province pro,sbassin sb where pro.id=sb.province"
			, nativeQuery = true)
	public List<?> getSbassinInfo3();//get_sbassin.info3
	

	@Query(value = "SELECT sb.id,sb.nom,pro.nomp as province "
			+ " FROM province pro,sbassin sb where pro.id=sb.province"
			, nativeQuery = true)
	public List<?> getSbassinByProvinceInfo();//get_sbassinbyprovince.info
	
}
