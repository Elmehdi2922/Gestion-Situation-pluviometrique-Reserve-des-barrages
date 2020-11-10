package prod.repositories;

 

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prod.entities.Barrage;
 

@Primary
public interface BarrageRepository extends JpaRepository<Barrage,Integer> {

	
}
