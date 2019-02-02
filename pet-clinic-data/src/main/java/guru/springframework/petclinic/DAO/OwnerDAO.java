package guru.springframework.petclinic.DAO;

import guru.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface OwnerDAO extends CrudRepository<Owner, Long> {

  public List<Owner> findAll();

}
