package prod.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import prod.entities.Personne; 


@Primary
public interface PersonneRepository extends JpaRepository<Personne,Long> {

	@Query(value = "SELECT p.* FROM reservation r,personne p,tables t,suite s WHERE r.tableid=t.id and p.id=r.clientid and p.typecompte='client' and t.suiteid=s.id and s.id in(select personne.sid from personne where personne.id=:x) ", nativeQuery = true)
	public List<Personne> getusersofsuite(@Param("x")int x);
}
