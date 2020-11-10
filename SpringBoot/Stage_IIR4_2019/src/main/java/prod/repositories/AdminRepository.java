package prod.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import prod.entities.Admin; 

@Primary
public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
