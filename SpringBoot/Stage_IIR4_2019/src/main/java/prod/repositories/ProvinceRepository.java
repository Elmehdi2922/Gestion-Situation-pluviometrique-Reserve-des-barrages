package prod.repositories;

  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prod.entities.Province; 


public interface ProvinceRepository extends JpaRepository<Province,Long> {

	@Query(value = "SELECT province.id,province.nomp, COUNT(sbassin.id) as nbrbassin"+
			" From province LEFT JOIN sbassin ON province.id=sbassin.province GROUP"+
			" By province.id,province.nomp ORDER by province.id "
			, nativeQuery = true)
	public List<?> getProvinceInfo();//get_province.info

	@Query(value = "SELECT sb.id,sb.nom,pro.nomp as province "
			+ " FROM province pro,sbassin sb where pro.id=sb.province"
			, nativeQuery = true)
	public List<?> getSbassinInfo4();//get_sbassin.info4
	

	@Query(value = "SELECT * from sbassin where sbassin.province= ?1"
			, nativeQuery = true)
	public List<?> getSbassinByProvinceInfo(int id);//get_sbassinbyprovince.info
}
